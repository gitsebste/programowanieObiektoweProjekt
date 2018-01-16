/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.dao;

import com.s.programowanieobiektoweprojekt.model.Person;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface PersonDAO extends CrudRepository<Person, Integer>{
    
}
