package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Food;
import com.example.repository.FoodRepository;

@RestController
@RequestMapping("/test")
public class DemoRestController {
	
	@Autowired
	FoodRepository foodRepository;
	
	@RequestMapping(value={"/hello"}, method = RequestMethod.GET)
	public String sayHello() {
		return "Hello Rest controller";
	}
	
	@RequestMapping(value={"/getFoods"}, method = RequestMethod.GET)
	public List<Food> doGetFoods() {
		return this.foodRepository.findAll();
	}

}
