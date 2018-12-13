/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dao;

import com.mycompany.store.dto.OrderLine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Moe
 */
public interface OrderLineDAO extends JpaRepository<OrderLine, Integer> {
    
     @Query("SELECT ol FROM OrderLine ol INNER JOIN ol.order o WHERE o.id = :orderId")
      public List<OrderLine> findAllByOrderId(@Param("orderId")int orderId);
    
}
