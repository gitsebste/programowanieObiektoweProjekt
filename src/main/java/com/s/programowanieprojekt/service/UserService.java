/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.service;

import com.s.programowanieprojekt.dao.UserDAO;
import com.s.programowanieprojekt.dao.UserDAO;
import com.s.programowanieprojekt.model.UserWithAccessLevel;
import com.s.programowanieprojekt.model.UserWithAccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class UserService extends GenericService<UserWithAccessLevel>{

    @Autowired            
    UserDAO dao;
    
    @Override
    public Iterable<UserWithAccessLevel> getAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserWithAccessLevel toSave) {
        dao.save(toSave);
    }

    @Override
    public UserWithAccessLevel getObjById(int objId) {
        return dao.findById(objId);        
    }
        public UserWithAccessLevel getObjByEmail(String email) {
        return dao.findByEmail(email);        
    }

    @Override
    public void update(UserWithAccessLevel toUpdate) {
        dao.save(toUpdate);
    }
  
    
}
