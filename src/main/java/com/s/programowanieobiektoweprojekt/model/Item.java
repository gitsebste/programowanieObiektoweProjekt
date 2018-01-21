/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.s.programowanieobiektoweprojekt.model;

import com.s.programowanieobiektoweprojekt.service.LocationService;
import com.s.programowanieobiektoweprojekt.service.PersonService;
import com.s.programowanieobiektoweprojekt.service.UnitService;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;



@Entity
public class Item {
    
    @Autowired @Transient
    PersonService pservice;
    @Autowired @Transient
    UnitService uservice;
    @Autowired @Transient
    LocationService lservice;
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotEmpty @Column(unique=true)
    private String code;//ex abcd a-value
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;    
    @ManyToOne//(cascade=CascadeType.PERSIST)
    private Location location;
    @ManyToOne//(cascade=CascadeType.PERSIST)
    private Person person;
    @ManyToOne//(cascade=CascadeType.PERSIST)
    private Unit unit;
    
    private Integer locationId;
    private String locationName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        if(location==null)
            location=new Location();//location = lservice.getObjByName(locationName);
        location.setName(locationName);
        this.locationName = locationName;
    }
    
    private Integer personId;
    @Email
    private String personEmail;
    
    private String unitShortName;

    public String getUnitShortName() {
        return unitShortName;
    }

    public void setUnitShortName(String unitShortName) {
        if(unit== null)
            unit=new Unit();//unit=uservice.getObjByShortName(unitShortName);
        unit.setShortName(unitShortName);
        this.unitShortName = unitShortName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        if(person==null)
            person=new Person();//person=pservice.getObjByEmail(personEmail);
        person.setEmail(personEmail);
        this.personEmail = personEmail;
    }
    
    private Integer unitId;
    
    

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        //System.out.println("SETTING LOCATION ID");
        if(location==null)
            location= new Location();//location = lservice.getObjById(locationId);
        location.setId(locationId);
        this.locationId = locationId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        if(person==null)
            person=new Person();//person = pservice.getObjById(personId);
        person.setId(personId);
        this.personId = personId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        if(unit==null)
            unit=new Unit();//unit = uservice.getObjById(unitId);
        unit.setId(unitId);
        this.unitId = unitId;
    }
    
    

    public Location getLocation() {        
        return location;
    }

    public void setLocation(Location location) {
        if(location!=null){
        locationName=location.getName();
        locationId=location.getId();
        }
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", location=" + location + ", person=" + person + ", unit=" + unit + '}';
    }

 

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        if(person!=null){
        personEmail=person.getEmail();
        personId=person.getId();
        }
        this.person = person;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        if(unit!=null){
        unitShortName=unit.getShortName();
        unitId=unit.getId();}
        this.unit = unit;
    }
    public Location getLocations() {
        return location;
    }

    public void setLocations(Location locations) {
        this.location = locations;
    }
public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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