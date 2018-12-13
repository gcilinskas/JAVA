/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dao;

import com.mycompany.store.dto.Cart;
import com.mycompany.store.dto.CartLine;
import com.mycompany.store.dto.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Moe
 */
@Transactional
public interface CartLineDAO extends JpaRepository<CartLine, Integer> {
    
    
//    @Query("SELECT c FROM CartLine c INNER JOIN c.users u WHERE u.username = :username")
//    @Query("SELECT c FROM CartLine")
//    public List<CartLine> findAllByUserUsername(@Param("username")String username);
      @Query("SELECT cl FROM CartLine cl INNER JOIN cl.cart c WHERE c.id = :cartId")
      public List<CartLine> findAllByCartId(@Param("cartId")int cartId);
      
    
}
