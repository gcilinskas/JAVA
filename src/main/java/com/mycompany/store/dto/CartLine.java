/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dto;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moe
 */
@Entity
@Table(name = "cart_line")
@XmlRootElement
public class CartLine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private BigDecimal price;
    @JoinColumns({
        @JoinColumn(name = "cart_id", referencedColumnName = "id")})
    @ManyToOne
    private Cart cart;
     @JoinColumns({
        @JoinColumn(name = "product_id", referencedColumnName = "id")})
    @OneToOne
    private Product product;

     public CartLine(){
         
     }
     
    public CartLine(int id, int quantity, BigDecimal price, Cart cart, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.cart = cart;
        this.product = product;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartLine{" + "id=" + id + ", quantity=" + quantity + ", price=" + price + ", cart=" + cart + ", product=" + product + '}';
    }
     
     
     
     
    
    
    
    
    
}
