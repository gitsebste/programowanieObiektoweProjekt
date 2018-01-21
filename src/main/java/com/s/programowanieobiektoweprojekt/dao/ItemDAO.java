/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.dao;

import com.s.programowanieobiektoweprojekt.model.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author device02
 */

public interface ItemDAO extends CrudRepository<Item, Integer>{
    public Item findById(int id);

    public Item findByCode(String code);
    public List<Item> findByLocationBuilding(float building);
    public List<Item> findByLocationRoom(float room);
    public List<Item> findByLocationFloor(float floor);
    public List<Item> findByUnitShortName(String shortName);
}
