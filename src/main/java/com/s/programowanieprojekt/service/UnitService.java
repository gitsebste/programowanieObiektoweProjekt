/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.service;

import com.s.programowanieobiektoweprojekt.dto.OuterApi;
import com.s.programowanieprojekt.dao.PersonDAO;
import com.s.programowanieprojekt.dao.UnitDAO;
import com.s.programowanieprojekt.model.Person;
import com.s.programowanieprojekt.model.Unit;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class UnitService extends GenericService<Unit>{
    
    OuterApi<Unit> api = new OuterApi<Unit>();

    @Autowired            
    UnitDAO dao;
    
    @Override
    public Iterable<Unit> getAll() {
        Iterable<Unit> tmp = dao.findAll();
        HashSet<Unit> ans = new HashSet<Unit>();
        for(Unit el:tmp)
            ans.add(el);
        List<Unit> list = api.getAll();
        for(Unit el:list)
            ans.add(el);
        return ans;
    }

    @Override
    public void save(Unit toSave) {
        dao.save(toSave);
    }

    
    public Unit getObjByShortName(String shortName) {
        Unit tmp = dao.findByShortName(shortName);     
        if(tmp!=null)return tmp;
        List<Unit> list = api.getAll();
        for(Unit el:list)
            if(el.getShortName().equals(shortName)){return el;}  
        return null;
    }
    @Override
        public Unit getObjById(int objId) {
                    Unit tmp = dao.findById(objId);     
        if(tmp!=null)return tmp;
        List<Unit> list = api.getAll();
        for(Unit el:list)
            if(el.getId()==objId){return el;}  
        return null;
    }

    @Override
    public void update(Unit toUpdate) {
        Integer id = getObjByShortName(toUpdate.getShortName()).getId();
        if(id==null)
        {
            List<Unit> list = api.getAll();String shortName = toUpdate.getShortName();
            for(Unit el:list)
                if(el.getShortName().equals(shortName)){id= el.getId();break;}
        }
        toUpdate.setId(id);
        dao.save(toUpdate);
    }      
}
