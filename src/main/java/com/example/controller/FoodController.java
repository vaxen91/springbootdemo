package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Food;
import com.example.service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "/foodApp/foodManager", method = RequestMethod.POST)
	public ModelAndView createNewFood(@Valid Food food, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Food foodExists = foodService.findByName(food.getName());
		if (foodExists != null) {
			bindingResult
					.rejectValue("name", "error.food",
							"There is already a food registered with the name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/foodApp/foodManager");
		} else {
			foodService.saveFood(food);
			modelAndView.addObject("successMessage", "Food has been registered successfully");
			modelAndView.addObject("food", new Food());
			modelAndView.setViewName("/foodApp/foodManager");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/foodApp/foodManager", method = RequestMethod.GET)
	public ModelAndView foodRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		Food food = new Food();
		modelAndView.addObject("food", food);
		modelAndView.setViewName("/foodApp/foodManager");
		return modelAndView;
	}
	
	@RequestMapping(value="/foodApp/foodMenu", method = RequestMethod.GET)
	public ModelAndView foodMenu(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("foods", foodService.findAll());
		modelAndView.setViewName("/foodApp/foodMenu");
		return modelAndView;
	}

}
