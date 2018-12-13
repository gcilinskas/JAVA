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
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Moe
 */
@Controller
@RequestMapping("/admin")
public class AdminControllerCarts {
    
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
    
    
    
    
     //Show All Carts
    @RequestMapping(value = "/manageCarts")
    public ModelAndView manageCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageCarts", true);
        mv.addObject("title", "Manage Carts");
        mv.addObject("allCartsB", true);
        mv.addObject("allPurchasedCartsB", false);
        mv.addObject("allNotPurchasedCartsB", false);
        mv.addObject("allCarts", cartDAO.findAll());

        return mv;
    }

    //Show CartLines
    @RequestMapping(value = {"/manageCarts/manageCartLines/{id}"})
    public ModelAndView manageCartLines(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageCartLines", true);
        mv.addObject("title", "Manage Cart lines");
        mv.addObject("allCartLines", cartLineDAO.findAllByCartId(id));

        return mv;
    }

    //*********************************** Cart Sorting *************************//
    @RequestMapping(value = "/managePurchasedCarts")
    public ModelAndView managePurchasedCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManagePurchasedCarts", true);
        mv.addObject("title", "Manage Purchased Carts");
        mv.addObject("allCartsB", false);
        mv.addObject("allPurchasedCartsB", true);
        mv.addObject("allNotPurchasedCartsB", false);
        mv.addObject("allNotPurchasedFullCartsB", false);
        mv.addObject("allNotPurchasedEmptyCartsB", false);
        mv.addObject("allPurchasedCarts", cartDAO.getPurchasedCarts());

        return mv;
    }

    @RequestMapping(value = "/manageNotPurchasedCarts")
    public ModelAndView manageNotPurchasedCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageNotPurchasedCarts", true);
        mv.addObject("title", "Manage Not Purchased Carts");
        mv.addObject("allCartsB", false);
        mv.addObject("allPurchasedCartsB", false);
        mv.addObject("allNotPurchasedCartsB", true);
        mv.addObject("allNotPurchasedFullCartsB", false);
        mv.addObject("allNotPurchasedEmptyCartsB", false);
        mv.addObject("allNotPurchasedCarts", cartDAO.getNotPurchasedCarts());

        return mv;
    }

    @RequestMapping(value = "/manageNotPurchasedFullCarts")
    public ModelAndView manageNotPurchasedFullCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageNotPurchasedFullCarts", true);
        mv.addObject("title", "Manage Not Purchased Full Carts");
        mv.addObject("allCartsB", false);
        mv.addObject("allPurchasedCartsB", false);
        mv.addObject("allNotPurchasedCartsB", false);
        mv.addObject("allNotPurchasedFullCartsB", true);
        mv.addObject("allNotPurchasedEmptyCartsB", false);
        List<CartLine> cartLineList = cartLineDAO.findAll();
        List<Cart> cList = cartDAO.getNotPurchasedCarts();

        List<Cart> cFList = new ArrayList<>();
        for (Cart cart : cList) {
            for (CartLine cartLine : cartLineList) {
                if (cart.getId() == cartLine.getCart().getId()) {
                    cFList.add(cart);
                }
            }
        }
        mv.addObject("allNotPurchasedFullCarts", cFList);

        return mv;
    }

    @RequestMapping(value = "/manageNotPurchasedEmptyCarts")
    public ModelAndView manageNotPurchasedEmptyCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageNotPurchasedEmptyCarts", true);
        mv.addObject("title", "Manage Not Purchased Empty Carts");
        mv.addObject("allCartsB", false);
        mv.addObject("allPurchasedCartsB", false);
        mv.addObject("allNotPurchasedFullCartsB", false);
        mv.addObject("allNotPurchasedEmptyCartsB", true);
        mv.addObject("allNotPurchasedCartsB", false);
        List<CartLine> cartLineList = cartLineDAO.findAll();
        List<Cart> cList = cartDAO.getNotPurchasedCarts();
        List<Cart> list = new ArrayList<>();

        List<Cart> cFList = new ArrayList<>();
        for (Cart cart : cList) {

            for (CartLine cartLine : cartLineList) {
                if (cart.getId() == cartLine.getCart().getId()) {
                    cFList.add(cart);
                }
            }
        }

        for (Cart cart : cList) {
            if (!cFList.contains(cart)) {
                list.add(cart);
            }
        }

        mv.addObject("allNotPurchasedEmptyCarts", list);

        return mv;

    }

    @RequestMapping(value = "/manageAnonymousCarts")
    public ModelAndView manageAnonymousCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageAnonymousCarts", true);
        mv.addObject("title", "Manage Anonymous Carts");
        mv.addObject("allCartsB", false);
        mv.addObject("allPurchasedCartsB", false);
        mv.addObject("allNotPurchasedCartsB", false);
        mv.addObject("allAnonymousCartsB", true);
        mv.addObject("allNotPurchasedFullCartsB", false);
        mv.addObject("allNotPurchasedEmptyCartsB", false);
        mv.addObject("allAnonymousCarts", cartDAO.getAnonymousCarts());

        return mv;
    }

    @RequestMapping(value = "/manageUsersCarts")
    public ModelAndView manageUsersCarts() {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickAdminSectionManageUsersCarts", true);
        mv.addObject("title", "Manage Users Carts");
        mv.addObject("allCartsB", false);
        mv.addObject("allPurchasedCartsB", false);
        mv.addObject("allNotPurchasedCartsB", false);
        mv.addObject("allAnonymousCartsB", false);
        mv.addObject("allUsersCartsB", true);
        mv.addObject("allNotPurchasedFullCartsB", false);
        mv.addObject("allNotPurchasedEmptyCartsB", false);
        mv.addObject("allUsersCarts", cartDAO.getUsersCarts());

        return mv;
    }
    
    
    
    
    
    
    
    
    
    
    
}
