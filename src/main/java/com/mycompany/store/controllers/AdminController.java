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
import com.mycompany.store.dto.Roles;
import com.mycompany.store.dto.Users;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class AdminController {

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

    //Main Admin Page
    @RequestMapping(value = "/main")
    public ModelAndView showProductsForAdmin(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickAdminSection", true);
        mv.addObject("title", "Admin Section");
        return mv;
    }

    //Manage All Products
    @RequestMapping(value = "/manageProducts")
    public ModelAndView manageProducts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManage", true);
        mv.addObject("title", "Manage Products");
        mv.addObject("allProducts", productDAO.findAll());

        return mv;
    }

    //Add New Product
    @RequestMapping(value = "/addProduct")
    public ModelAndView newProduct() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionAdd", true);
        mv.addObject("title", "Add Product");
        mv.addObject("product", new Product());

        return mv;
    }

    //Open Edit Product Page And Send Product Details
    @RequestMapping(value = "/editProduct/{id}")
    public ModelAndView editProduct(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionEdit", true);
        mv.addObject("title", "Edit Product");
        mv.addObject("product", productDAO.getOne(id));

        return mv;
    }

    //Save Product Edits
    @RequestMapping(value = {"/editProduct/save", "/save"}, method = RequestMethod.POST)
    public String saveUpdateProduct(@ModelAttribute("product") Product p) {
        productDAO.save(p);
        return "redirect:/products";
    }

    //Delete Product
    @GetMapping(value = "deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id) {

        //delete product from all Carts
        List<CartLine> clList = cartLineDAO.findAll();
        for (CartLine cl : clList) {
            if (cl.getProduct().getId() == id) {
                cartLineDAO.delete(cl);
            }
        }

        productDAO.deleteById(id);

        return "redirect:/";
    }

    //Open Add User Page
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionAddUser", true);
        mv.addObject("title", "Add User");
        mv.addObject("user", new Users());

        return mv;
    }

    //Save New User By Admin
    @RequestMapping(value = {"/addUser/saveUser", "/saveUser"}, method = RequestMethod.POST)
    public String saveUpdateUser(@ModelAttribute("user") Users u) {

        String username = u.getUsername();

        if (usersDAO.findByUsername(username) != null) {
            return "redirect:/error";
        }

        //set encoded password & Save user
        u.setPassword(pe.encode(u.getPassword()));
        usersDAO.save(u);

        //set roles
        Roles role = new Roles();
        if (u.isIsAdmin()) {
            role.setRole("ADMIN");
        } else {
            role.setRole("USER");
        }
        role.setUserId(u);
        rolesDAO.save(role);

        //Create New Cart
        Cart cart = new Cart();
        cart.setUsers(u);
        Date date = new Date();
        cart.setDateAdded(date);
        cart.setDatePurchased(null);
        cartDAO.save(cart);

        return "redirect:/";
    }

    //Show All Users
    @RequestMapping(value = "/manageUsers")
    public ModelAndView manageUsers() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageUsers", true);
        mv.addObject("title", "Manage Users");
        mv.addObject("allUsers", usersDAO.findAll());

        return mv;
    }

    //Show User Carts
    @RequestMapping(value = "/manageUserCarts/{id}")
    public ModelAndView manageUserCarts(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageUserCarts", true);
        mv.addObject("title", "Manage User Carts");
        mv.addObject("allUserCarts", cartDAO.findAllByUserId(id));

        return mv;
    }
    
    
    //Delete User
    @RequestMapping(value = "deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        usersDAO.deleteById(id);
        return "redirect:/";
    }


   

}
