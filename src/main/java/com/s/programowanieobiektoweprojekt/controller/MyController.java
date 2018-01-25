/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.model.Person;
import com.s.programowanieobiektoweprojekt.service.NotificationService;
import org.apache.log4j.Logger;
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
        
        //NotificationService.sendNotification(new Person(1,"n","ln","sebste92@gmail.com"), null, null, null);
        
        logger.debug("MyController.home()");
        
        ModelAndView model = new ModelAndView("home");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("person", new Person());
        
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
