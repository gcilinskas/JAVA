/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.controllers;

import com.mycompany.store.dao.CartDAO;
import com.mycompany.store.dao.CartLineDAO;
import com.mycompany.store.dao.OrderDAO;
import com.mycompany.store.dao.OrderLineDAO;
import com.mycompany.store.dao.ProductDAO;
import com.mycompany.store.dao.RolesDAO;
import com.mycompany.store.dao.UsersDAO;
import com.mycompany.store.dto.Cart;
import com.mycompany.store.dto.CartLine;
import com.mycompany.store.dto.Order;
import com.mycompany.store.dto.OrderLine;
import com.mycompany.store.dto.Product;
import com.mycompany.store.dto.Users;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/admin")
public class AdminControllerOrders {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderLineDAO orderLineDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    CartLineDAO cartLineDAO;

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    RolesDAO rolesDAO;

    @Autowired
    private PasswordEncoder pe;

    //Show All Orders
    @RequestMapping(value = "/manageOrders")
    public ModelAndView manageOrders() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageOrders", true);
        mv.addObject("title", "Manage Orders");
        mv.addObject("allOrders", orderDAO.findAll());

        return mv;
    }

    //Show Order Lines
    @RequestMapping(value = "/manageOrders/manageOrderLines/{id}")
    public ModelAndView manageOrderLines(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageOrderLines", true);
        mv.addObject("title", "Manage Order lines");
        mv.addObject("allOrderLines", orderLineDAO.findAllByOrderId(id));

        return mv;
    }

    //Open Add Order Page
    @RequestMapping(value = "/addOrder")
    public ModelAndView newOrder() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickAdminSectionAddOrder", true);
        mv.addObject("title", "Add Order");
        return mv;
    }

    //Show Add Order Form With Required Details
    @RequestMapping(value = "/addOrderForm", method = RequestMethod.POST)
    public ModelAndView newOrderForm(@RequestParam int userID) {
        Cart cart = null;
        Users user = null;

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickAdminSectionAddOrderForm", true);
        try {
            cart = cartDAO.findByUserId(userID);
            user = usersDAO.findByUserId(userID);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ModelAndView("redirect:/error");
        }
        mv.addObject("userCartLines", cartLineDAO.findAllByCartId(cart.getId()));
        mv.addObject("userId", userID);
        mv.addObject("user", user);

        return mv;
    }

    // Make Order As Admin For User
    @RequestMapping(value = {"/manageOrders/saveNewOrder", "/saveNewOrder"}, method = RequestMethod.POST)
    public String purchaseNewOrder(@RequestParam int userId) {

        Date date = new Date();
        Users users = null;
        Cart cart = null;

        try {
            //Get CurrentUser Cart & Set Date Purchased
            users = usersDAO.findByUserId(userId);
            cart = cartDAO.findByUserId(users.getId());
            cart.setDatePurchased(date);
            cartDAO.save(cart);
        } catch (Exception ex) {
            System.out.println(ex);
            return "redirect:/error";
        }

        //Save New Order
        Order order = new Order();
        order.setInfo("Added by Admin");
        order.setDateAdded(date);

        BigDecimal tp = new BigDecimal(0);

        //Create OrderLine For Each CartLine
        for (CartLine cl : cartLineDAO.findAllByCartId(cart.getId())) {

            //Update Product Quantity Left In Stock
            Product product = productDAO.getOne(cl.getProduct().getId());

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
            order.setInfo("Ordered By Admin. User = " + users.getUsername() + ". Total Price: " + tp);
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

    //Add To User Cart As Admin
    @RequestMapping(value = {"/manageOrders/saveNewUserCartLine", "/saveNewUserCartLine"}, method = RequestMethod.POST)
    public String saveNewUserCartLine(@RequestParam int productId, @RequestParam int quantity, @RequestParam int userId) {

        try {
            Users users = usersDAO.findByUserId(userId);
            Cart cart = cartDAO.findByUserId(users.getId());
            Product p = productDAO.getOne(productId);

            CartLine cartLine = new CartLine();
            cartLine.setCart(cart);
            cartLine.setProduct(p);
            cartLine.setPrice(p.getPrice());
            cartLine.setQuantity(quantity);
            cartLineDAO.save(cartLine);
        } catch (Exception ex) {
            System.out.println(ex);
            return "redirect:/error";
        }

        return "redirect:/admin/addOrder";
    }

    //Open Edit Order Page
    @RequestMapping(value = "/manageOrders/editOrder/{id}")
    public ModelAndView editOrder(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickAdminSectionEditOrder", true);
        mv.addObject("title", "Edit Order");
        mv.addObject("order", orderDAO.getOne(id));
        return mv;
    }

    //Open Edit OrderLine Page
    @RequestMapping(value = "/manageOrders/editOrderLine/{id}")
    public ModelAndView editOrderLine(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickAdminSectionEditOrderLine", true);
        mv.addObject("title", "Edit Order Line");
        mv.addObject("orderLine", orderLineDAO.getOne(id));
        return mv;
    }

    //Bind Data For Getting Date From OrderEdit Page
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    //Save Order Edits
    @RequestMapping(value = {"/manageOrders/saveOrder", "/saveOrder"}, method = RequestMethod.POST)
    public String saveUpdateOrder(@ModelAttribute("order") Order o) {
        orderDAO.save(o);
        return "redirect:/";
    }

    //Save OrderLine Edits
    @RequestMapping(value = {"/manageOrders/saveOrderLine", "/saveOrderLine"}, method = RequestMethod.POST)
    public String saveUpdateOrderLine(@ModelAttribute("orderLine") OrderLine ol) {

        orderLineDAO.save(ol);
        return "redirect:/";
    }
    
    //Delete Order
    @RequestMapping(value = "deleteOrder/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderDAO.deleteById(id);
        return "redirect:/";
    }

}
