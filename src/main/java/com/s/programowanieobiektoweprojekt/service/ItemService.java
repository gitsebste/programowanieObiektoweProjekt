/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.ItemDAO;
import com.s.programowanieobiektoweprojekt.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class ItemService extends GenericService<Item>{

    @Autowired            
    ItemDAO dao;
    
    @Autowired            
    UnitService uservice;
    @Autowired            
    PersonService pservice;
    @Autowired            
    LocationService lservice;
    
    @Override
    public Iterable<Item> getAll() {
        return dao.findAll();
        
    }

    @Override
    public void save(Item toSave) {
        dao.save(toSave);
    }

    @Override
    public Item getObjById(int objId) {
        return dao.findById(objId);        
    }

    public Item getObjByCode(String code) {
        return dao.findByCode(code); 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Item toUpdate) {
        toUpdate.setId(getObjByCode(toUpdate.getCode()).getId());
        if(!IsNull(toUpdate.getUnitShortName()))
            toUpdate.setUnit(uservice.getObjByShortName(toUpdate.getUnitShortName()));
        if(!IsNull(toUpdate.getPersonEmail()))
            toUpdate.setPerson(pservice.getObjByEmail(toUpdate.getPersonEmail()));
        if(!IsNull(toUpdate.getLocationName()))
            toUpdate.setLocation(lservice.getObjByName(toUpdate.getLocationName()));
            
        dao.save(toUpdate);
    }
    
    boolean IsNull(String tmp)
    {
        return (tmp==null || tmp=="");
    }
    }
