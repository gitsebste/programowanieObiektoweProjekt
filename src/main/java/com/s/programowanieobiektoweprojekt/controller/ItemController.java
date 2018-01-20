/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieobiektoweprojekt.controller;

import com.s.programowanieobiektoweprojekt.model.Item;
import com.s.programowanieobiektoweprojekt.service.GenericService;
import com.s.programowanieobiektoweprojekt.service.ItemService;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @Autowired //@Qualifier("itemService")
    ItemService service;
    
    @RequestMapping("/add")
    public ModelAndView add() {
        
        logger.debug("ItemController.add()");
        
        ModelAndView model = new ModelAndView("addItem");
        
        //Person p = new Person();p.setName("Name");
        model.addObject("item", new Item());
        
        return model;
    }
    @RequestMapping("/get/{id}")
    public ModelAndView get(@PathVariable("id") int id) {
        
        logger.debug("ItemController.get() + id = "+id);
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getObjById(id));
        
        return model;
    }
        @RequestMapping("/get/byCode/{code}")
    public ModelAndView getByCode(@PathVariable("code") String code) {
        
        logger.debug("ItemController.get() + code = "+code);
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getObjByCode(code));
        
        return model;
    }
    
            @RequestMapping("/update/byCode/{code}")
    public ModelAndView updateByCode(@PathVariable("code") String code,BindingResult bindingResult) {
        
        logger.debug("ItemController.updateByCode() + code = "+code);
        
        for (ObjectError e : bindingResult.getAllErrors())
            System.out.println(e);
        
        ModelAndView model = new ModelAndView("addItem");
        Item item = service.getObjByCode(code);
        model.addObject("item", item);
        
        return model;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Item p,BindingResult bindingResult) {
        logger.debug("ItemController.get() + item = "+p);//System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            for (ObjectError e : bindingResult.getAllErrors())
            System.out.println(e);
            return "addItem";
        }
        service.save(p);
        //personDAO.save(p);
        
        return "redirect:/home.htm";
    
    }
        @RequestMapping(value = "/update/byCode/save", method = RequestMethod.POST)
    public String updateByCode(@Valid Item p,BindingResult bindingResult) {
        logger.debug("ItemController.get() + item = "+p);//System.out.println(p);
        
        if(bindingResult.hasErrors())
        {
            for (ObjectError e : bindingResult.getAllErrors())
            System.out.println(e);
            return "addItem";
        }
        service.update(p);
        //personDAO.save(p);
        
        return "redirect:/home.htm";
    
    }
    
}
