/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author device02
 */
@Entity
public class Location {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotEmpty @Column(unique=true)
    private String name;
    @NotEmpty
    private String description;
    private float building;
    private float room;
    private int floor;

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", name=" + name + ", description=" + description + ", building=" + building + ", room=" + room + ", floor=" + floor + '}';
    }

    public float getBuilding() {
        return building;
    }

    public void setBuilding(float building) {
        this.building = building;
    }

    public float getRoom() {
        return room;
    }

    public void setRoom(float room) {
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    
 

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
