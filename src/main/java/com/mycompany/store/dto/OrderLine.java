/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moe
 */
@Entity
@Table(name="order_line")
@XmlRootElement
public class OrderLine {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int quantity;
    
    @JoinColumns({
        @JoinColumn(name = "product_id", referencedColumnName = "id")})
    @OneToOne
    private Product product;
    
    @JoinColumns({
        @JoinColumn(name = "order_id", referencedColumnName = "id")})
    @OneToOne
    private Order order;
    
    public OrderLine(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" + "id=" + id + ", quantity=" + quantity + ", product=" + product + ", order=" + order + '}';
    }
    
    
    
    
}
