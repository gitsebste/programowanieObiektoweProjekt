/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author device02
 */
@Entity
public class Person implements Emailable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @Email @NotEmpty @Column(unique=true)
    private String email;    

    public Person(Integer id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + '}';
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
        System.out.println("com.s.programowanieobiektoweprojekt.model.Person.setName()");
        this.name = name;
    }

    public Person() {
    }
    
}
