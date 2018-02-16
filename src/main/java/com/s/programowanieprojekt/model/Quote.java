/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.model;

/**
 *
 * @author device02
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote<T> {

    private String type;
    @JsonProperty("value")
    private List<T> value = new ArrayList();

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<T> getValue() {
        return value;
    }

    public void setValue(List<T> value) {
        this.value = value;
    }

//    public Value getValue() {
//        return value;
//    }
//
//    public void setValue(Value value) {
//        this.value = value;
//    }

    @Override
    public String toString() {
        String valuesToString = "";
        for(T v:value)valuesToString+=v.toString()+"\n";
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + valuesToString +
                '}';
    }
}
