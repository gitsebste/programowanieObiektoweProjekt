/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.PersonDAO;
import com.s.programowanieobiektoweprojekt.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class PersonService extends GenericService<Person>{

    @Autowired            
    PersonDAO dao;
    
    @Override
    public Iterable<Person> getAll() {
        return dao.findAll();
    }

    @Override
    public void save(Person toSave) {
        dao.save(toSave);
    }

    @Override
    public Person getObjById(int objId) {
        return dao.findById(objId);        
    }
        public Person getObjByEmail(String email) {
        return dao.findByEmail(email);        
    }

    @Override
    public void update(Person toUpdate) {
        dao.save(toUpdate);
    }
  
    
}
