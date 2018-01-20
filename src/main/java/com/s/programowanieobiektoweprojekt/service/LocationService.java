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
public class LocationService extends GenericService<Location>{
    
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
        locationDAO.save(toUpdate);
    }

    @Override
    public Location getObjById(int objId) {
        return locationDAO.findById(objId);
    }
    
    public Location getObjByName(String name) {
        return locationDAO.findByName(name);
    }
    
}
