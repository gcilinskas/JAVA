/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dao;

import com.mycompany.store.dto.Cart;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Moe
 */

@Transactional
public interface CartDAO extends JpaRepository<Cart, Integer>{
    
    //@Query(value="SELECT * FROM cart INNER JOIN users u WHERE u.id = ?userId order BY date_added ASC LIMIT 1;", nativeQuery=true)
//     @Query("SELECT c FROM Cart c INNER JOIN c.users u WHERE u.id = :userId")
    @Query(value="SELECT * from cart INNER JOIN users where users.id = cart.user_id and cart.user_id=?1 ORDER BY date_added DESC LIMIT 1;",nativeQuery=true)
    public Cart findByUserId(@Param("userId")int userId);
    
    @Query(value="SELECT * FROM cart WHERE date_purchased IS NOT NULL;",nativeQuery=true)
    public List<Cart> getPurchasedCarts();  
    
    @Query(value="SELECT * FROM cart WHERE date_purchased IS NULL;",nativeQuery=true)
    public List<Cart> getNotPurchasedCarts();
    
    @Query(value="SELECT * FROM cart WHERE user_id IS NULL;",nativeQuery=true)
    public List<Cart> getAnonymousCarts();
    
    @Query(value="SELECT * FROM cart WHERE user_id IS NOT NULL;",nativeQuery=true)
    public List<Cart> getUsersCarts();
    
    @Query(value="SELECT * from cart INNER JOIN users where users.id = cart.user_id and cart.user_id=?1 ORDER BY date_added DESC;",nativeQuery=true)
    public List<Cart> findAllByUserId(@Param("userId")int userId);
    
}
