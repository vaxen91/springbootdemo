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
	
	@RequestMapping(value = "/foodApp/home", method = RequestMethod.POST)
	public ModelAndView createNewFood(@Valid Food food, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Food foodExists = foodService.findByName(food.getFoodName());
		if (foodExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			foodService.saveFood(food);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new Food());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}

}
