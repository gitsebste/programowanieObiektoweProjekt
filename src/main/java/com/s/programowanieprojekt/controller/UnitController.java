/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieprojekt.controller;

import com.s.programowanieprojekt.model.Person;
import com.s.programowanieprojekt.model.Unit;
import com.s.programowanieprojekt.service.GenericService;
import com.s.programowanieprojekt.service.UnitService;
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
@RequestMapping("/unit")
public class UnitController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @Autowired //@Qualifier("unitService")
    UnitService service;//PersonDAO personDAO;
    private boolean update;
    
    @RequestMapping("/add")
    public ModelAndView add() {
        
        logger.debug("UnitController.add()");
        
        ModelAndView model = new ModelAndView("addUnit");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("obj", new Unit());
        
        return model;
    }
    @RequestMapping("/get/{id}")
    public ModelAndView get(@PathVariable("id") int id) {
        
        logger.debug("UnitController.get() + id = "+id);
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getObjById(id));
        
        return model;
    }
        @RequestMapping("/get/all")
    public ModelAndView getAll( ) {
        
        logger.debug("UnitController.getAll()");
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getAll());
        
        return model;
    }
    
                 @RequestMapping("/update/byShortName/{shortName}")
    public ModelAndView updateByShortName(@PathVariable("shortName") String shortName){//,BindingResult bindingResult) {
        
        logger.debug("UnitController.updateByEmail(){shortName} + shortName = "+shortName);
        
        ModelAndView model = new ModelAndView("addUnit");
        Unit unit = service.getObjByShortName(shortName);
        System.out.println(unit);
        model.addObject("obj", unit);
        
        return model;
    }
                @RequestMapping("/update/byShortName")
    public String updateByShortName(Person p) {
        String name = p.getName();
        logger.debug("UnitController.byShortName() + shortName = "+name);
        
        return "redirect:/unit/update/byShortName/"+name+".htm";
    }
    
               @RequestMapping(value = "/update/byShortName/save", method = RequestMethod.POST)
    public String update(@Valid Unit p,BindingResult bindingResult) {
        update=true;
        return save(p,bindingResult);
    
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Unit p,BindingResult bindingResult) {
        logger.debug("UnitController.get() + unit = "+p);//System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            return "addUnit";
        }
        if(!update)
        service.save(p);
        else
            service.update(p);
        
        update=false;
        //personDAO.save(p);
        
        return "redirect:/home.htm";
    
    }
    
}
