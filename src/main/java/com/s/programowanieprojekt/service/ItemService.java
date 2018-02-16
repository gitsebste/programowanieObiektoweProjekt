/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.service;

import com.s.programowanieobiektoweprojekt.dto.OuterApi;
import com.s.programowanieprojekt.dao.ItemDAO;
import com.s.programowanieprojekt.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author device02
 */
@Service
public class ItemService //extends GenericService<Item>{
    {

    @Autowired            
    ItemDAO dao;
    
    @Autowired            
    UnitService uservice;
    @Autowired            
    PersonService pservice;
    @Autowired            
    LocationService lservice;
    @Autowired            
    RestTemplate restTemplate;
    
    OuterApi<Item> api = new OuterApi<Item>();
    
    public Iterable<Item> getAll() {
        HashSet<Item> ans = new HashSet<Item>();
        for(Item item :dao.findAll())
            ans.add(item);
        for(Item item :api.getAll())
            ans.add(item);
        
        return ans; 
        
    }

    
    public void save(Item toSave) {
        setNotUsedToNull(toSave);
        dao.save(toSave);
    }

    
    public Item getObjById(int objId) {
        Item tmp = dao.findById(objId);  
        if(tmp!=null)return tmp;
        List<Item> list = api.getAll();
        for(Item el:list)
            if(el.getId()==objId)return el;
        return null;
    }

    public Item getObjByCode(String code) {
        Item tmp = dao.findByCode(code); 
        if(tmp!=null)return tmp;
        List<Item> list = api.getAll();
        for(Item el:list)
            if(el.getCode().equals(code))return el;
        return null;
    }
        public List<Item> getObjByLocationBuilding(float building) {
            HashSet<Item> ans = new HashSet<Item>();
            for(Item el:dao.findByLocationBuilding(building))
            {
                ans.add(el);                
            }
            List<Item> list = api.getAll();
        for(Item el:list)
            if(el.getLocation().getBuilding()==building)ans.add(el);
        list = new ArrayList();
        for(Item el:ans)
            list.add(el);
        getData(list);
        return list; 
    }
        public List<Item> getObjByLocationFloor(float floor) {
                        HashSet<Item> ans = new HashSet<Item>();
            for(Item el:dao.findByLocationFloor(floor))
            {
                ans.add(el);                
            }
            List<Item> list = api.getAll();
        for(Item el:list)
            if(el.getLocation().getFloor()==floor)ans.add(el);
        list = new ArrayList();
        for(Item el:ans)
            list.add(el);
        getData(list);
        return list; 
    }

    private void getData(List<Item> ans) {
        for(Item item :ans)
        {
            setNotUsedToNull(item);
            
            item.setId(getObjByCode(item.getCode()).getId());
            if(!IsNull(item.getUnitShortName()))
                item.setUnit(uservice.getObjByShortName(item.getUnitShortName()));
            if(!IsNull(item.getPersonEmail()))
                item.setPerson(pservice.getObjByEmail(item.getPersonEmail()));
            if(!IsNull(item.getLocationName()))
                item.setLocation(lservice.getByName(item.getLocationName()));
        }
    }
        public List<Item> getObjByLocationRoom(float room) {
                                    HashSet<Item> ans = new HashSet<Item>();
            for(Item el:dao.findByLocationRoom(room))
            {
                ans.add(el);                
            }
            List<Item> list = api.getAll();
        for(Item el:list)
            if(el.getLocation().getFloor()==room)ans.add(el);
        list = new ArrayList();
        for(Item el:ans)
            list.add(el);
        getData(list);
        return list; 
    }
           public List<Item> getObjByUnitShortName(String shortName) {
               HashSet<Item> ans = new HashSet<Item>();
            for(Item el:dao.findByUnitShortName(shortName))
            {
                ans.add(el);                
            }
            List<Item> list = api.getAll();
        for(Item el:list)
            if(el.getUnitShortName().equals(shortName))ans.add(el);
        list = new ArrayList();
        for(Item el:ans)
            list.add(el);
        getData(list);
        return list;        
    }   

    
    public void update(Item toUpdate) {
        
        setNotUsedToNull(toUpdate);
        
        Integer id = getObjByCode(toUpdate.getCode()).getId();
        if(id==null)
        {
            List<Item> list = api.getAll();String code = toUpdate.getCode();
            for(Item el:list)
            {
                if(el.getCode().equals(code)){id=el.getId();break;}
            }
        }
        toUpdate.setId(id);
        
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
        return (tmp==null || tmp.equals(""));
    }

    private void setNotUsedToNull(Item toSave) {
//                if(toSave.getLocation()!=null)if(toSave.getLocation().getId()==null)toSave.setLocation(null);
//        if(toSave.getPerson()!=null)if(toSave.getPerson().getId()==null)toSave.setPerson(null);
//        if(toSave.getUnit()!=null)if(toSave.getUnit().getId()==null)toSave.setUnit(null);        
//        if(toSave.getPersonEmail()!=null)            
//            toSave.setPerson(pservice.getObjByEmail(toSave.getPersonEmail()));        
//        if(toSave.getLocationName()!=null)            
//            toSave.setLocation(lservice.getByName(toSave.getLocationName()));        
//        if(toSave.getUnitShortName()!=null)            
//            toSave.setUnit(uservice.getObjByShortName(toSave.getUnitShortName()));        
    }
    }
