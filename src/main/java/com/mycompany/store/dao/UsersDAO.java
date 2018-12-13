/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dao;

import com.mycompany.store.dto.Users;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Moe
 */
//public interface UsersDAO {
//    
//    boolean add(Users users);
//    
//    List<Users> list();
//    
//}
@Transactional
public interface UsersDAO extends JpaRepository<Users, Integer> {
//  
//    @Query("Select b from Basket b where b.sessionId=:sessionId")
//    public Basket findBySessionId(@Param("sessionId") String sessionId); 
    
    
    @Query("Select u from Users u WHERE u.username = :username and u.password = :password")
    public Users login(@Param("username")String username,@Param("password")String password);
    
    @Query("Select u from Users u where u.username=:username")
    public List<Users> findByName(@Param("username") String username); 
    
    @Query("Select u from Users u where u.username=:username")
    public Users findByUsername(@Param("username") String username);
    
    @Query("Select u from Users u where u.id=:id")
    public Users findByUserId(@Param("id")int id);

    
    
       
  }