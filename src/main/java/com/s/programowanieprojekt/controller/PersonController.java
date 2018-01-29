/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieprojekt.controller;

import com.s.programowanieprojekt.model.Location;
import com.s.programowanieprojekt.model.Person;
import com.s.programowanieprojekt.service.GenericService;
import com.s.programowanieprojekt.service.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @Autowired @Qualifier("personService")
    PersonService personService;//PersonDAO personDAO;
    private boolean update;
    
    @RequestMapping("/add")
    public ModelAndView add() {
        
        logger.debug("PersonController.add()");
        
        ModelAndView model = new ModelAndView("add");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("person", new Person());
        
        return model;
    }
    @RequestMapping("/get/{id}")
    public ModelAndView get(@PathVariable("id") int id) {
        
        logger.debug("PersonController.get() + id = "+id);
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", personService.getObjById(id));
        
        return model;
    }
    
        @RequestMapping("/get/byUnitShortName/{uniShortName}")
    public ModelAndView getByUnitShortName(@PathVariable("uniShortName") String uniShortName) {
        
        
        logger.debug("PersonController.getByUnitShortName() + uniShortName = "+uniShortName);
        
        ModelAndView model = new ModelAndView("response");    
        
        model.addObject("object", personService.getObjByUnitShortName(uniShortName));
        
        return model;
    }
                @RequestMapping("/getByUnitShortName")
    public String getByUnitShortName(Person p) {
        String name = p.getName();
        logger.debug("PersonController.getByUnitShortName() + shortName = "+name);
        
        return "redirect:/person/get/byUnitShortName/"+name+".htm";
    }
    
                @RequestMapping("/update/byEmail/{email}")
    public ModelAndView updateByEmail(@PathVariable("email") String email){//,BindingResult bindingResult) {
        
        logger.debug("PersonController.updateByEmail(){email} + email = "+email);
        
        ModelAndView model = new ModelAndView("add");
        Person person = personService.getObjByEmail(email);
        model.addObject("person", person);
        
        return model;
    }
                @RequestMapping("/update/byEmail")
    public String updateByEmail(Person p) {
        String name = p.getName();
        logger.debug("PersonController.updateByEmail() + name = "+name);
        
        return "redirect:/person/update/byEmail/"+name+".htm";
    }
    
               @RequestMapping(value = "/update/byEmail/save", method = RequestMethod.POST)
    public String update(@Valid Person p,BindingResult bindingResult) {
        update=true;
        return save(p,bindingResult);
    
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Person p,BindingResult bindingResult) {
        logger.debug("PersonController.get() + person = "+p);//System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            return "add";
        }
        if(update)
            personService.update(p);
        else
            personService.save(p);
        //personDAO.save(p);
        
        update=false;
        
        return "redirect:/home.htm";
    
    }
    
}
