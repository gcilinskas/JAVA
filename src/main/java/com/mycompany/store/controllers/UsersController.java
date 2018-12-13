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
import com.mycompany.store.dao.RolesDAO;
import com.mycompany.store.dao.UsersDAO;
import com.mycompany.store.dto.Cart;
import com.mycompany.store.dto.Roles;
import com.mycompany.store.dto.Users;
import com.mycompany.store.models.AnonymousUserModel;
import java.io.IOException;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Moe
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    RolesDAO rolesDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    CartLineDAO cartLineDAO;

    @Autowired
    private PasswordEncoder pe;
    
    @Autowired
    OrderDAO orderDAO;
    
    @Autowired
    OrderLineDAO orderLineDAO;

    //Registration
    @RequestMapping(value = "/register")
    public ModelAndView register() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Register");
        mv.addObject("userClickRegister", true);
        mv.addObject("user", new Users());

        return mv;
    }

    //Not Set(default is security)
    @RequestMapping(value = "/login")
    public ModelAndView login() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Login");
        mv.addObject("userClickLogin", true);
        mv.addObject("user", new Users());

        return mv;
    }

    //Not Set(default is security)
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Logout");
        mv.addObject("userClickLogout", true);
        mv.setViewName("redirect:/");
        return mv;
    }

    //Save New User With Current Session
    @RequestMapping(value = {"/users/save", "/save"}, method = RequestMethod.POST)
    public String saveUpdateUser(@ModelAttribute("user") Users u, HttpSession session) {

        AnonymousUserModel aUser = (AnonymousUserModel) session.getAttribute("anonymousUserModel");
        Cart aCart = (Cart) session.getAttribute("cart");

        if (aUser != null) {

            //set encoded password & Save user
            String username = u.getUsername();
            
            if(usersDAO.findByUsername(username) != null){
                return "redirect:/error";
            }
            
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

            //Set Cart
            
            if(aCart != null){
                Cart cart = aCart;
                cart.setUsers(u);
                cartDAO.save(cart);
                session.invalidate();
            } else{
                //Create New Cart
                Cart cart = new Cart();
                cart.setUsers(u);
                Date date = new Date();
                cart.setDateAdded(date);
                cart.setDatePurchased(null);
                cartDAO.save(cart);
            }

        } 

        return "redirect:/";
    }

    //Not Set(default is spring security)
    @RequestMapping(value = {"/users/log", "/log"}, method = RequestMethod.POST)
    public ModelAndView loginUser(@ModelAttribute("user") Users u, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        ModelAndView mv = new ModelAndView("page");
        Users users = null;
        users = usersDAO.login(u.getUsername(), u.getPassword());

        if (users != null) {
            mv.setViewName("redirect:/");
            return mv;
        } else {
            mv.setViewName("redirect:/users/login");
            mv.addObject("errors", "Wrong Username Or Password!");
            return mv;
        }
    }
    
    
    

    
    
    


}
