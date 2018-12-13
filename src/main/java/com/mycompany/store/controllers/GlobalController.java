/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.controllers;

import com.mycompany.store.dao.CartDAO;
import com.mycompany.store.dao.UsersDAO;
import com.mycompany.store.dto.Cart;
import com.mycompany.store.dto.CartLine;
import com.mycompany.store.dto.Users;
import com.mycompany.store.models.AnonymousUserModel;
import com.mycompany.store.models.UserModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Moe
 */
@ControllerAdvice
public class GlobalController {

    @Autowired
    HttpSession session;

    @Autowired
    UsersDAO usersDAO;

    @Autowired
    CartDAO cartDAO;

    private UserModel userModel = null;
    private AnonymousUserModel aUserModel = null;

    //Create Session For LoggedIn User
    @ModelAttribute("userModel")
    public UserModel getUserModel() {
        if (session.getAttribute("userModel") == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Users users = usersDAO.findByUsername(authentication.getName());
            if (users != null) {
                userModel = new UserModel();
                userModel.setId(users.getId());
                userModel.setUsername(users.getUsername());
                userModel.setIsAdmin(users.isIsAdmin());
                userModel.setCart(users.getCart());
                session.setAttribute("userModel", userModel);
            }
        }
        return (UserModel) session.getAttribute("userModel");
    }

    //Create Session For Anonymous User
    @ModelAttribute("anonymousUserModel")
    public AnonymousUserModel getAnonymousUserModel() {
        if (session.getAttribute("anonymousUserModel") == null) {
            aUserModel = new AnonymousUserModel();
            aUserModel.setId(0);
            aUserModel.setUsername(session.getId());
            aUserModel.setIsAdmin(false);
            aUserModel.setCart(null);
            session.setAttribute("anonymousUserModel", aUserModel);
        }
        return (AnonymousUserModel) session.getAttribute("anonymousUserModel");
    }

}
