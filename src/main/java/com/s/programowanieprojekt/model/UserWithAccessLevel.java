/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author device02
 */
@Entity
public class UserWithAccessLevel implements Emailable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    String saltyPassword;
    @Email @NotEmpty @Column(unique=true)
    String email;
    @Transient
    final Date regDate;
    Integer accessLevel;
    
    
    //https://www.youtube.com/watch?v=gBMAGjyE2g4
    //password, login/email, access lvl

    public UserWithAccessLevel() {
        regDate = new Date();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", saltyPassword=" + saltyPassword + ", email=" + email + ", accessLevel=" + accessLevel + '}';
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaltyPassword() {
        return saltyPassword;
    }
    
    private int calcCrazyNum()
    {
        return (int) ((regDate.getTime()/ 1073676287+ 18014398241046527l)/ 27644437);
    }

    public void setSaltyPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(calcCrazyNum());
        this.saltyPassword = encoder.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    
    
    
}
