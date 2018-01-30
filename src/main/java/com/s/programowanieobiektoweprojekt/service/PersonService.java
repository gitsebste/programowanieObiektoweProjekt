/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.PersonDAO;
import com.s.programowanieobiektoweprojekt.model.Item;
import com.s.programowanieobiektoweprojekt.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class PersonService extends GenericServic<Person>{

    @Autowired            
    PersonDAO dao;
    
    @Autowired 
    UnitService uservice;
    
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
            System.out.println("getObjByEmail |"+email+"|");
        Person ans = dao.findByEmail(email);        
        if(ans.getUnitShortName()!=null)
         ans.setUnit(uservice.getObjByShortName(ans.getUnitShortName()));
        return ans;
    }
         public List<Person> getObjByUnitShortName(String unitShortName) {
             Integer unitId = uservice.getObjByShortName(unitShortName).getId();
        return dao.findByUnitId( unitId);        
    }
             private void getData(List<Person> ans) {
        for(Person person :ans)
        {
            setNotUsedToNull(person);
            
            person.setId(getObjByEmail(person.getEmail()).getId());
            if(!IsNull(person.getUnitShortName()))
                person.setUnit(uservice.getObjByShortName(person.getUnitShortName()));
        }
    }
                 boolean IsNull(String tmp)
    {
        return (tmp==null || tmp=="");
    }

    private void setNotUsedToNull(Person toSave) {
                if(toSave.getUnitShortName()!=null)if(toSave.getUnit().getId()==null)toSave.setUnit(null);  
    }
    @Override
    public void update(Person toUpdate) {
        String unitShortName = toUpdate.getUnitShortName();
        toUpdate.setUnit(uservice.getObjByShortName(unitShortName));
        toUpdate.setId(getObjByEmail(toUpdate.getEmail()).getId());
        dao.save(toUpdate);
    }

    public void deleteByEmail(String name) {
        dao.delete(getObjByEmail(name));
    }
  
    
}
