package com.mycompany.store.controllers;

import com.mycompany.store.dao.CartDAO;
import com.mycompany.store.dao.CartLineDAO;
import com.mycompany.store.dao.OrderDAO;
import com.mycompany.store.dao.OrderLineDAO;
import com.mycompany.store.dao.ProductDAO;
import com.mycompany.store.dao.UsersDAO;
import com.mycompany.store.dto.Cart;
import com.mycompany.store.dto.CartLine;
import com.mycompany.store.dto.Order;
import com.mycompany.store.dto.OrderLine;
import com.mycompany.store.dto.Product;
import com.mycompany.store.dto.Users;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Moe
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    CartLineDAO cartLineDAO;

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderLineDAO orderLineDAO;

    private List<CartLine> sessionList = new ArrayList<>();

    //Show Cart Lines
    @RequestMapping(value = "/show")
    public ModelAndView showCart(HttpSession session) {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Cart");
        mv.addObject("userClickCart", true);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersDAO.findByUsername(authentication.getName());
        if (users != null) {
            Cart cart = cartDAO.findByUserId(users.getId());
            mv.addObject("allCartLines", cartLineDAO.findAllByCartId(cart.getId()));
        } else {
            List<CartLine> cList = (List<CartLine>) session.getAttribute("cartLineList");
            mv.addObject("allCartLines", cList);
        }

        return mv;
    }

    //Add Product To Cart
    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String addToCart(@PathVariable int id, @RequestParam("quantityProduct") int quantityProduct, HttpSession session) {

        Product product = productDAO.getOne(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersDAO.findByUsername(authentication.getName());

        //Set CartLine For Users 
        if (users != null) {

            try {
                Cart cart = cartDAO.findByUserId(users.getId());
                CartLine cartLine = new CartLine();
                cartLine.setCart(cart);
                cartLine.setProduct(product);
                cartLine.setPrice(product.getPrice());
                cartLine.setQuantity(quantityProduct);
                cartLineDAO.save(cartLine);
            } catch (Exception ex) {
                System.out.println(ex);
                return "redirect:/error";
            }
            //Set CartLine For Anonymous Users(Add To Session + DB)
        } else {
            //If Anonymous User Dont Have Cart
            if (session.getAttribute("cart") == null) {
                Cart cart = new Cart();
                Date date = new Date();
                cart.setDateAdded(date);
                cart.setDatePurchased(null);
                cart.setUsers(null);
                session.setAttribute("cart", cart);
                cartDAO.save(cart);

                List<CartLine> sessionCLList = new ArrayList<>();
                session.setAttribute("sessionCartLineList", sessionCLList);

                try {
                    CartLine cartLine = new CartLine();
                    cartLine.setCart(cart);
                    cartLine.setProduct(product);
                    cartLine.setPrice(product.getPrice());
                    cartLine.setQuantity(quantityProduct);
                    cartLineDAO.save(cartLine);
                    sessionList.add(cartLine);
                    session.setAttribute("cartLineList", sessionList);
                } catch (Exception ex) {
                    System.out.println(ex);
                    return "redirect:/error";
                }

                //If Anonymous User Have Cart
            } else {

                try {
                    Cart cart = (Cart) session.getAttribute("cart");
                    CartLine cartLine = new CartLine();
                    cartLine.setCart(cart);
                    cartLine.setProduct(product);
                    cartLine.setPrice(product.getPrice());
                    cartLine.setQuantity(quantityProduct);
                    cartLineDAO.save(cartLine);
                    sessionList.add(cartLine);
                    session.setAttribute("cartLineList", sessionList);
                } catch (Exception ex) {
                    System.out.println(ex);
                    return "redirect:/error";
                }

            }
        }

        return "redirect:/products";
    }

    //Delete CartLine From Cart
    @RequestMapping(value = "/delete/{id}")
    public String deleteFromCart(@PathVariable int id) {
        cartLineDAO.deleteById(id);
        return "redirect:/";
    }

    //Make Order
    @RequestMapping(value = "/purchase")
    public String purchaseAll() {

        Date date = new Date();
        Cart cart = null;
        Users users = null;
        Product product = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            //Get CurrentUser Cart & Set Date Purchased
            users = usersDAO.findByUsername(authentication.getName());
            cart = cartDAO.findByUserId(users.getId());
            cart.setDatePurchased(date);
            cartDAO.save(cart);
        } catch (Exception ex) {
            System.out.println(ex);
            return "redirect:/error";
        }

        //Create New Order
        Order order = new Order();
        order.setDateAdded(date);
        order.setInfo("");

        BigDecimal tp = new BigDecimal(0);

        //Create OrderLine For Each CartLine
        for (CartLine cl : cartLineDAO.findAllByCartId(cart.getId())) {

            //Update Product Quantity Left In Stock
            product = productDAO.getOne(cl.getProduct().getId());

            //Check if there are enough products in stock
            try {
                if (product.getQuantity() - cl.getQuantity() < 0) {
                    throw new Exception();
                } else {
                    product.setQuantity(product.getQuantity() - cl.getQuantity());
                    productDAO.save(product);
                }
            } catch (Exception ex) {
                System.out.println(ex);
                return "redirect:/error";
            }

            OrderLine orderLine = new OrderLine();
            orderLine.setOrder(order);
            orderLine.setProduct(cl.getProduct());
            orderLine.setQuantity(cl.getQuantity());

            //Set Additional Info For Order
            BigDecimal qBD = new BigDecimal(cl.getQuantity());
            BigDecimal totalPrice = cl.getPrice().multiply(qBD, MathContext.UNLIMITED);
            tp = tp.add(totalPrice, MathContext.UNLIMITED);
            order.setInfo("Ordered By " + users.getUsername() + ". Total Price: " + tp);
            orderDAO.save(order);
            orderLineDAO.save(orderLine);

        }

        //Creating New Cart
        Cart newCart = new Cart();
        newCart.setUsers(users);
        newCart.setDateAdded(date);
        newCart.setDatePurchased(null);
        cartDAO.save(newCart);

        users.setCart(newCart);
        usersDAO.save(users);

        return "redirect:/";
    }

    //Show Purchases
    @RequestMapping(value = "/purchases")
    public ModelAndView showOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersDAO.findByUsername(authentication.getName());

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickShowPurchases", true);
        mv.addObject("title", "Show User Purchases");

        List<Cart> cList = cartDAO.getPurchasedCarts();
        List<Cart> userPCList = new ArrayList<>();

        for (Cart c : cList) {
            if (c.getUsers().equals(users)) {
                userPCList.add(c);
            }
        }

        mv.addObject("allPurchases", userPCList);

        return mv;
    }

    //Show Purchased Products
    @RequestMapping(value = "/purchases/purchasedProducts/{id}")
    public ModelAndView showOrderLines(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickShowPurchasedProducts", true);
        mv.addObject("title", "Manage Purchased Products");
        mv.addObject("allPurchasedProducts", cartLineDAO.findAllByCartId(id));

        return mv;
    }

}
