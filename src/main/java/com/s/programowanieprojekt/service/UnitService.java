/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.service;

import com.s.programowanieprojekt.dao.PersonDAO;
import com.s.programowanieprojekt.dao.UnitDAO;
import com.s.programowanieprojekt.model.Person;
import com.s.programowanieprojekt.model.Unit;
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
        toUpdate.setId(getObjByShortName(toUpdate.getShortName()).getId());
        dao.save(toUpdate);
    }
  
    
}
