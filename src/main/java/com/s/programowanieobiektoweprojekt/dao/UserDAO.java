/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.dao;

import com.s.programowanieobiektoweprojekt.model.UserWithAccessLevel;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface UserDAO extends CrudRepository<UserWithAccessLevel, Integer>{
    public UserWithAccessLevel findById(int id);
    public UserWithAccessLevel findByEmail(String email);
}
