/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import com.s.programowanieobiektoweprojekt.dao.ItemDAO;
import com.s.programowanieobiektoweprojekt.model.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class ItemService extends GenericServic<Item>{

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
        List<Item> ans = new ArrayList<Item>();
        for(Item item :dao.findAll())
            ans.add(item);
        getData(ans);
        return ans; 
        
    }

    @Override
    public void save(Item toSave) {
        setNotUsedToNull(toSave);
        dao.save(toSave);
    }

    @Override
    public Item getObjById(int objId) {
        return dao.findById(objId);        
    }

    public Item getObjByCode(String code) {
        return dao.findByCode(code); 
    }
        public List<Item> getObjByLocationBuilding(float building) {
            List<Item> ans = dao.findByLocationBuilding(building); 
        getData(ans);
        return ans; 
    }
        public List<Item> getObjByLocationFloor(float floor) {
             List<Item> ans = dao.findByLocationFloor(floor); 
        getData(ans);
        return ans;
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
                    List<Item> ans = dao.findByLocationRoom(room);
        getData(ans);
        return ans;
    }
           public List<Item> getObjByUnitShortName(String shortName) {
               List<Item> ans = dao.findByUnitShortName(shortName);
        getData(ans);
        return ans;//dao.findByUnitShortName(shortName);
    }   

    @Override
    public void update(Item toUpdate) {
        
        setNotUsedToNull(toUpdate);
        
        toUpdate.setId(getObjByCode(toUpdate.getCode()).getId());
        if(!IsNull(toUpdate.getUnitShortName()))
            toUpdate.setUnit(uservice.getObjByShortName(toUpdate.getUnitShortName()));
        if(!IsNull(toUpdate.getPersonEmail()))
            toUpdate.setPerson(pservice.getObjByEmail(toUpdate.getPersonEmail()));
        if(!IsNull(toUpdate.getLocationName()))
            toUpdate.setLocation(lservice.getByName(toUpdate.getLocationName()));
            
        dao.save(toUpdate);
    }
    
      public void deleteByCode(String code) {
          
          dao.delete(getObjByCode(code));
          
    }
    
    boolean IsNull(String tmp)
    {
        return (tmp==null || tmp.equals(""));
    }

    private void setNotUsedToNull(Item toSave) {
                if(toSave.getLocation()!=null)if(toSave.getLocation().getId()==null)toSave.setLocation(null);
        if(toSave.getPerson()!=null)if(toSave.getPerson().getId()==null)toSave.setPerson(null);
        if(toSave.getUnit()!=null)if(toSave.getUnit().getId()==null)toSave.setUnit(null);
        
        if(!IsNull(toSave.getPersonEmail()))//!=null)
            toSave.setPerson(pservice.getObjByEmail(toSave.getPersonEmail()));
        if(!IsNull(toSave.getLocationName()))//!=null)
            toSave.setLocation(lservice.getByName(toSave.getLocationName()));
        if(!IsNull(toSave.getUnitShortName()))//!=null)
            toSave.setUnit(uservice.getObjByShortName(toSave.getUnitShortName()));
    }
    }
