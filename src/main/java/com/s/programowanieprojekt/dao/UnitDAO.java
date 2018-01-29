/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.dao;

import com.s.programowanieprojekt.model.Unit;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface UnitDAO extends CrudRepository<Unit, Integer>{
    public Unit findById(int id);
    public Unit findByShortName(String shortName);
}
