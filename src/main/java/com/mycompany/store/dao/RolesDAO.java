/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store.dao;

import com.mycompany.store.dto.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nikanoras
 */
public interface RolesDAO extends JpaRepository<Roles, Integer> {
    
}
