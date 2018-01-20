/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.service;

import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 * @param <T>
 */
@Service
public abstract class GenericService<T> {
  
    
    
    /**
     *
     * @return
     */
    public abstract Iterable<T> getAll();
    public abstract void save(T toSave);
    public abstract void update(T toUpdate);
    public abstract T getObjById(int objId);
    
}
