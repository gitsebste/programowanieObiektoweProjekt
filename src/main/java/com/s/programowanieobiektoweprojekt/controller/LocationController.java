/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.model.Item;
import com.s.programowanieobiektoweprojekt.model.Location;
import com.s.programowanieobiektoweprojekt.model.Person;
import com.s.programowanieobiektoweprojekt.service.GenericServic;
import com.s.programowanieobiektoweprojekt.service.LocationService;
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
    LocationService service;//PersonDAO personDAO;
    private boolean update;
    
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
    
            @RequestMapping("/update/byName/{name}")
    public ModelAndView updateByName(@PathVariable("name") String name){//,BindingResult bindingResult) {
        
        logger.debug("LocationController.updateByCode(){name} + name = "+name);
        
        ModelAndView model = new ModelAndView("addLocation");
        model.addObject("location", service.getByName (name));
        
        return model;
    }
                @RequestMapping("/update/byName")
    public String updateByName(Person p) {
        String name = p.getName();
        logger.debug("LocationController.updateByName() + name = "+name);
        
        return "redirect:/location/update/byName/"+name+".htm";
    }
            @RequestMapping(value = "/update/byName/save", method = RequestMethod.POST)
    public String update(@Valid Location location,BindingResult bindingResult) {
        update=true;
        return save(location,bindingResult);
    
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Location location,BindingResult bindingResult) {
        logger.debug("LocationController.save() + location = "+location);//System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            
            //return "addLocation";
        }
        if(update)
            service.update(location);
        else
        service.save(location);
        //personDAO.save(p);
        update=false;
        return "redirect:/home.htm";    
    }
                    @RequestMapping("/deleteByName")
    public String deleteByName(Person p) {
        String name = p.getName();
        logger.debug("LocationController.deleteByName() + name = "+name);
        
        service.deleteByName(name);
        
        return "redirect:/home.htm";
    }

//    
}
