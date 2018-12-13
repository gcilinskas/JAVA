///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.store.test;
//
//import com.mycompany.store.dao.UsersDAO;
//import com.mycompany.store.dto.Users;
//import static org.junit.Assert.assertEquals;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
///**
// *
// * @author Moe
// */
//public class UsersTestCase {
//    
//    private static AnnotationConfigApplicationContext context;
//    
//    private static UsersDAO usersDAO;
//    
//    private Users users;
//            
//    @BeforeClass
//    public static void init(){
//        context = new AnnotationConfigApplicationContext();
//        context.scan("com.mycompany.store");
//        context.refresh();
//        usersDAO = (UsersDAO)context.getBean("usersDAO");
//    }
//    
//    @Test
//    public void testAddUsers(){
//        
//        users = new Users();
//        
//     //   users.setId(3);
//        users.setUsername("useer");
//        users.setPassword("pass");
//        users.setIsAdmin(false);
//        
//        assertEquals("Added successfully " + users.getUsername() + "  " + users.getId() + "  ID " + users.isIsAdmin()  +  "   userNAME",true,usersDAO.save(users));
//        
//    }
//    
//}
