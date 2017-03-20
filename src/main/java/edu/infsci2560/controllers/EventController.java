package edu.infsci2560.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.infsci2560.models.Event;
import edu.infsci2560.repositories.EventRepository;;


/**
*
* @author Wenwen Sun
*/
@Controller
public class EventController {

	@Autowired
    private EventRepository repository;
	
   @RequestMapping(value = "photos", method = RequestMethod.GET)
   public ModelAndView index() {
       return new ModelAndView("events", "photos", repository.findAll());
   }

   @RequestMapping(value = "photos/add", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Event event, BindingResult result) {
        repository.save(event);
        return new ModelAndView("events", "photos", repository.findAll());
    }

}
