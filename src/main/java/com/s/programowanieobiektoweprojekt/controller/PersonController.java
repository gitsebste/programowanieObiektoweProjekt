/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.model.Person;
import com.s.programowanieobiektoweprojekt.dao.PersonDAO;
import com.s.programowanieobiektoweprojekt.service.GenericService;
import com.s.programowanieobiektoweprojekt.service.PersonService;
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
    GenericService<Person> personService;//PersonDAO personDAO;
    
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
        
        logger.debug("PersonController.add()");
        
        ModelAndView model = new ModelAndView("add");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("person", new Person());
        
        return model;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Person p,BindingResult bindingResult) {
        System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            return "add";
        }
        personService.save(p);
        //personDAO.save(p);
        
        return "redirect:/home.htm";
    
    }
    
}
