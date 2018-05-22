package com.example.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.model.Food;
import com.example.repository.FoodRepository;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	@Autowired
	FoodRepository foodRepository;

	@RequestMapping(value = { "/hello" }, method = RequestMethod.GET)
	public String sayHello() {
		return "Hello Rest controller";
	}

	@RequestMapping(value = { "/foods" }, method = RequestMethod.GET)
	public List<Food> doGetFoods() {
		return this.foodRepository.findAll();
	}

	@RequestMapping(value = { "/foods/{id}" }, method = RequestMethod.GET)
	public Food getFoodById(@PathVariable int id) {

		Food food = foodRepository.findOne(id);

		if (food == null) {
			throw new FoodNotFoundException("id-" + id);
		}
		return food;

	}

	@RequestMapping(value = { "/foods" }, method = RequestMethod.POST)
	public ResponseEntity<Object> createUsers(@ModelAttribute Food food) {

		Food savedFood = this.foodRepository.save(food);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFood.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = { "/foods/{id}" }, method = RequestMethod.DELETE)
	public void deleteFoodById(@PathVariable int id) {

		this.foodRepository.delete(id);

	}

}
