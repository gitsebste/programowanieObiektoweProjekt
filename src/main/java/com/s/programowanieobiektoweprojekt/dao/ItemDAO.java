/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.dao;

import com.s.programowanieobiektoweprojekt.model.Item;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface ItemDAO extends CrudRepository<Item, Integer>{
    public Item findById(int id);

    public Item findByCode(String code);
}
