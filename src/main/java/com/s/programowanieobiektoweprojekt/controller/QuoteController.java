/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.dto.OuterApi;
import com.s.programowanieobiektoweprojekt.service.ItemService;
import com.s.programowanieprojekt.model.Quote;
import com.s.programowanieprojekt.model.Value;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/quote")
//@SessionAttributes("user")
public class QuoteController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @Autowired //@Qualifier("itemService")
    ItemService service;
    //@Autowired //@Qualifier("itemService")
    OuterApi source = new OuterApi();
    RestTemplate restTemplate= new RestTemplate();
    
    @RequestMapping("/get")
    public ModelAndView get() {
        //Quote quote = restTemplate.getForObject("http://api.icndb.com/jokes/random/3", Quote.class);        
        //Quote quote = restTemplate.getForObject(OuterApi.getRandom(5), Quote.class);        
        
        OuterApi<Value> api = new OuterApi<Value>();
        List<Value> quote = api.getAll();
        
        System.out.println( (quote.toString()));        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", quote);        
        return model;
    }
}