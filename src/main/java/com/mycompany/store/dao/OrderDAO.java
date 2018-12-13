/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dao;

import com.mycompany.store.dto.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Moe
 */
public interface OrderDAO extends JpaRepository<Order,Integer> {
    
    
    @Query(value="SELECT * from order_detail INNER JOIN users where users.id = order_detail.user_id and order_detail.user_id=?1 ORDER BY date_added DESC;",nativeQuery=true)
    
    public List<Order> findAllByUserId(@Param("userId")int userId);
    

    
    
}
