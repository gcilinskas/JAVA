/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.config;


import com.mycompany.store.dao.UsersDAO;
import com.mycompany.store.dto.Users;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nikanoras
 */
@Component
public class MyUserDetails implements UserDetailsService {

    private final static Log LOG = LogFactory.getLog(MyUserDetails.class);
    
//    @Autowired
//    private PasswordEncoder pe;
    
    
    @Autowired
    private UsersDAO usersDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        List<Users> users = usersDAO.findByName(username);
        if(users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

}
