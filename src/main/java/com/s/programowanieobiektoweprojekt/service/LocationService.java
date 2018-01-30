/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.LocationDAO;
import com.s.programowanieobiektoweprojekt.model.Location;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author device02
 */
public class LocationService extends GenericServic<Location>{
    
    private Location lastGetted;

    public Location getLastGetted() {
        return lastGetted;
    }
    
    @Autowired
    LocationDAO locationDAO;

    @Override
    public Iterable getAll() {
        return locationDAO.findAll();
    }

    @Override
    public void save(Location toSave) {
        locationDAO.save(toSave);
    }

    @Override
    public void update(Location toUpdate) {
        Integer id = getByName(toUpdate.getName()).getId();
        toUpdate.setId(id);
        locationDAO.save(toUpdate);
    }

    @Override
    public Location getObjById(int objId) {
        lastGetted=locationDAO.findById(objId);
        return lastGetted;
    }
        
    public Location getByName(String name) {
        return locationDAO.findByName(name);        
    }
public Location getByNameForNotWorkingController(String name) {
    if(lastGetted==null)
        lastGetted = locationDAO.findByName(name);
        //lastGetted.getId();
        System.out.println(lastGetted);
        return lastGetted;
    }    

    public void deleteByName(String name) {
        locationDAO.delete( getByName(name));
    }
}
