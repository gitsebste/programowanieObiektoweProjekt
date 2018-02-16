/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.service;

import com.s.programowanieobiektoweprojekt.dto.OuterApi;
import com.s.programowanieprojekt.dao.PersonDAO;
import com.s.programowanieprojekt.model.Person;
import com.s.programowanieprojekt.model.Unit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class PersonService extends GenericService<Person>{
    
    OuterApi<Person> api = new OuterApi<Person>();
    OuterApi<Unit> uapi = new OuterApi<Unit>();

    @Autowired            
    PersonDAO dao;
    
    @Autowired 
    UnitService uservice;
    
    @Override
    public Iterable<Person> getAll() {
        List<Person> tmp = api.getAll();
        
        HashSet<Person> ans = new HashSet<Person>();
        for(Person p:tmp)
            ans.add(p);
        for(Person p:dao.findAll())
            ans.add(p);
        return ans;
    }

    @Override
    public void save(Person toSave) {
        dao.save(toSave);
    }

    @Override
    public Person getObjById(int objId) {
        Person tmp = dao.findById(objId);        
        if(tmp!=null)return tmp;
        List<Person> list = api.getAll();
        for(Person p:list)
            if(p.getId()==objId)return p;
        return null;
    }
        public Person getObjByEmail(String email) {
        Person tmp = dao.findByEmail(email);        
        if(tmp!=null){tmp.setUnit(uservice.getObjByShortName(tmp.getUnitShortName()));
        return tmp;}
        
        List<Person> list = api.getAll();
        for(Person p:list)
            if(p.getEmail().equals(email))return p;
        return null;        
    }
         public List<Person> getObjByUnitShortName(String unitShortName) {
            List<Person> ans = new ArrayList<Person>();
        
        List<Person> list = api.getAll();
        for(Person p:list)
            if(p.getUnitShortName().equals(unitShortName))ans.add(p); 
        
        Integer unitId = uservice.getObjByShortName(unitShortName).getId();
        if(unitId==null)return ans;
        List<Person> tmp = dao.findByUnitId( unitId); 
        for(Person v:tmp)
                 ans.add(v);
        return ans;
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
        if(unitShortName!=null)
        {
            Unit tmp = uservice.getObjByShortName(unitShortName);
            if(tmp!=null)
            {
                List<Unit> list = uapi.getAll();
                for(Unit el:list)
                    if(el.getShortName().equals(unitShortName)){tmp=el;break;}
            }
            toUpdate.setUnit(tmp);
        }
        
        Integer id = getObjByEmail(toUpdate.getEmail()).getId();
        
        if(id==null)
        {
            List<Person> list = api.getAll();String email = toUpdate.getEmail();
            for(Person el:list)
                    if(el.getEmail().equals(email)){id=el.getId();break;}
        }
        
        toUpdate.setId(id);
        dao.save(toUpdate);
    }
  
    
}
