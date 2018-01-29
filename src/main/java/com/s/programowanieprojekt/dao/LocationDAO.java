/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.dao;

import com.s.programowanieprojekt.model.Location;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface LocationDAO extends CrudRepository<Location, Integer>{
    public Location findById(int id);
    public Location findByName(String name);
    
}
