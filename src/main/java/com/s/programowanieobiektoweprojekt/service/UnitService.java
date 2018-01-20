/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.PersonDAO;
import com.s.programowanieobiektoweprojekt.dao.UnitDAO;
import com.s.programowanieobiektoweprojekt.model.Person;
import com.s.programowanieobiektoweprojekt.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class UnitService extends GenericService<Unit>{

    @Autowired            
    UnitDAO dao;
    
    @Override
    public Iterable<Unit> getAll() {
        return dao.findAll();
    }

    @Override
    public void save(Unit toSave) {
        dao.save(toSave);
    }

    
    public Unit getObjByShortName(String shortName) {
        return dao.findByShortName(shortName);        
    }
    @Override
        public Unit getObjById(int objId) {
        return dao.findById(objId);        
    }

    @Override
    public void update(Unit toUpdate) {
        dao.save(toUpdate);
    }
  
    
}
