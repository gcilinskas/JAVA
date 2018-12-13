/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.controllers;

import com.mycompany.store.dao.ProductDAO;
import com.mycompany.store.dao.UsersDAO;
import com.mycompany.store.dto.Users;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Moe
 */
@Controller
public class PageController {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private ProductDAO productDAO;

    //Home Page
    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");
        mv.addObject("userClickHome", true);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String logUserUsername = auth.getName();

        mv.addObject("logUserUsername", logUserUsername);

        return mv;
    }

    //Show Products
    @RequestMapping(value = "/products")
    public ModelAndView products() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Products");
        mv.addObject("userClickProducts", true);
        mv.addObject("allProducts", productDAO.findAll());

        return mv;
    }

    //Show Cart
    @RequestMapping(value = "/cart")
    public ModelAndView cart() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Cart");
        mv.addObject("userClickCart", true);

        return mv;
    }

    //Access Denied Page(Not Set)
    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied() {

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("title", "Access Denied");
        mv.addObject("userClickAccessDenied", true);
        mv.addObject("error", "You do not have rights for this access");
        mv.addObject("errorSolution", "Please login with authorised account");

        return mv;
    }
    
    @RequestMapping(value = "/error")
    public ModelAndView error() {

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("title", "Error");
        mv.addObject("userClickError", true);
        mv.addObject("error", "Something Went Wrong..");
        mv.addObject("errorSolution", "Try again");

        return mv;
    }

}
