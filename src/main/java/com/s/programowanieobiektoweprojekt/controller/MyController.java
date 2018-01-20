/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.model.Item;
import com.s.programowanieobiektoweprojekt.model.Person;
import com.s.programowanieobiektoweprojekt.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/")
public class MyController {
     //@Autowired ItemService service;

    
    protected Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping("/home")
    public ModelAndView home() {
        
        logger.debug("MyController.home()");
        
        ModelAndView model = new ModelAndView("home");
        
        Person p = new Person();p.setName("Name");
        model.addObject("person", p);
        
        return model;
    }
    
    //    @RequestMapping("/debug")
  //  public ModelAndView debug() {
//        String code = "KRZESLO000001";
//        logger.debug("ItemController.get() + code = "+code);
//        
//        Item item = service.getObjByCode(code);
//        item.setDescription("krzesło nie działa");
//        service.save(item);
//        
//            System.out.println("1st call of getObjByCode() succeeded");
//        
//        ModelAndView model = new ModelAndView("response");                
//        model.addObject("object", service.getObjByCode(code));
//        
//        return model;        
    //}
    
}
