/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.PersonDAO;
import com.s.programowanieobiektoweprojekt.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class PersonService extends GenericService<Person>{

    @Autowired            
    PersonDAO personDAO;
    
    @Override
    public Iterable<Person> getAll() {
        return personDAO.findAll();
    }

    @Override
    public void save(Person toSave) {
        personDAO.save(toSave);
    }
  
    
}
