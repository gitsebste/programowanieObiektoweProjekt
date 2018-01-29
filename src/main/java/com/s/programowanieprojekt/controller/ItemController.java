/*
 * Copyright 2011-08-31 the original author or authors.
 */
package com.s.programowanieprojekt.controller;

import com.s.programowanieprojekt.model.Item;
import com.s.programowanieprojekt.model.Person;
import com.s.programowanieprojekt.service.GenericService;
import com.s.programowanieprojekt.service.ItemService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/item")
//@SessionAttributes("user")
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
        @RequestMapping("/get/all")
    public ModelAndView getall() {
        
      //  logger.debug("ItemController.get() + id = "+id);
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getAll());
        
        return model;
    }
    @RequestMapping("/get/{id}")
    public ModelAndView get(@PathVariable("id") int id) {
        
        logger.debug("ItemController.get() + id = "+id);
        
        ModelAndView model = new ModelAndView("response");                
        model.addObject("object", service.getObjById(id));
        
        return model;
    }
        @RequestMapping("/getByUnitShortName/{shortName}")
    public ModelAndView getByUnitShortName(@PathVariable("shortName") String shortName) {
        
        logger.debug("ItemController.getByUnitShortName(){shortName} + shortName = "+shortName);
        
        ModelAndView model = new ModelAndView("response");  
            System.out.println("com.s.programowanieobiektoweprojekt.controller.ItemController.getByUnitShortName()");        
        model.addObject("object", new ArrayList<Person>());
        //model.addObject("object", service.getObjByUnitShortName(shortName));
        
        return model;
    }
            @RequestMapping("/getByUnitShortName")
    public String getByUnitShortName(Person p) {
        String name = p.getName();
        logger.debug("ItemController.getByUnitShortName() + shortName = "+name);
        
        return "redirect:/item/getByUnitShortName/"+name+".htm";
    }
    
    
    
    
        @RequestMapping("/get/byCode/{code}")
    public ModelAndView getByCode(@PathVariable("code") String code) {
        
        logger.debug("ItemController.get(){code} + code = "+code);
        
        ModelAndView model = new ModelAndView("singleResponse");                
        model.addObject("object", service.getObjByCode(code));
        
        return model;
    }
                @RequestMapping("/get/byCode")
    public String getByCode(Person p) {
        String name = p.getName();
        logger.debug("ItemController.getByUnitShortName() + shortName = "+name);
        
        return "redirect:/item/get/byCode/"+name+".htm";
    }
    
    
    
    
    
    
    
    
    
            @RequestMapping("/update/byCode/{code}")
    public ModelAndView updateByCode(@PathVariable("code") String code){//,BindingResult bindingResult) {
        
        logger.debug("ItemController.updateByCode(){code} + code = "+code);
        ModelAndView model = new ModelAndView("addItem");
        Item item = service.getObjByCode(code);
        model.addObject("item", item);
        
        return model;
    }
                @RequestMapping("/update/byCode")
    public String updateByCode(Person p) {
        String name = p.getName();
        logger.debug("ItemController.getByUnitShortName() + code = "+name);
        
        return "redirect:/item//update/byCode/"+name+".htm";
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
