/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moe
 */
@Entity
@Table(name = "cart")
@XmlRootElement
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_added")
    private Date dateAdded;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_purchased")
    private Date datePurchased;
    
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @OneToOne
    private Users users;
    
            
    public Cart(){
        
    }

    public Cart(int id, Date dateAdded, Date datePurchased, Users users) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.datePurchased = datePurchased;
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", dateAdded=" + dateAdded + ", datePurchased=" + datePurchased + ", users=" + users + '}';
    }

    

   
    
    
}
