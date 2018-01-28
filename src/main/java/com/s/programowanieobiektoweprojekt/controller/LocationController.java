/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.model.Location;
import com.s.programowanieobiektoweprojekt.model.Person;
import com.s.programowanieobiektoweprojekt.service.GenericService;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/location")
public class LocationController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @Autowired @Qualifier("locationService")
    GenericService<Location> service;//PersonDAO personDAO;
    
    @RequestMapping("/add")
    public ModelAndView add() {
        
        logger.debug("LocationController.add()");
        
        ModelAndView model = new ModelAndView("addLocation");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("location", new Location());
        
        return model;
    }
    
            @RequestMapping("/get/all")
    public ModelAndView getAll( ) {
        
        logger.debug("LocationController.getAll()");
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getAll());
        
        return model;
    }
    
//    @RequestMapping("/get/{id}")
//    public ModelAndView get(@PathVariable("id") int id) {
//        
//        logger.debug("LocationController.get() + id = "+id);
//        
//        ModelAndView model = new ModelAndView("response");                
//        model.addObject("object", personService.getObjById(id));
//        
//        return model;
//    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Location p,BindingResult bindingResult) {
        logger.debug("LocationController.save() + location = "+p);//System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            return "addLocation";
        }
        service.save(p);
        //personDAO.save(p);
        
        return "redirect:/home.htm";
    
    }
//    
}
