package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class restServiceController {
	
	@RequestMapping(value="/foodApp/rest", method = RequestMethod.GET)
	public ModelAndView foodRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/foodApp/restservices");
		return modelAndView;
	}

}
