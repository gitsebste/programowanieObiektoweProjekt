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
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteListFromResponse {
    
    @JsonProperty("value")
   private List<Quote> quotes; 

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
    
}
