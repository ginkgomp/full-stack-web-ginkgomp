package edu.infsci2560.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.infsci2560.repositories.UserRepository;

public class UserController {
	@Autowired
    private UserRepository repository;
	
   @RequestMapping(value = "account", method = RequestMethod.GET)
   public ModelAndView index() {
       return new ModelAndView("account", "user", repository.findAll());
   }

}
