package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Food;
import com.example.repository.FoodRepository;

@Service ("foodService")
public class FoodServiceImpl implements FoodService {

	@Autowired 
	private FoodRepository foodRepository;
	
	@Override
	public void saveFood (Food food) {
		foodRepository.save(food);
	}
	
	@Override
	public Food findByName(String name) {
		return foodRepository.findByName(name);
	}
	
	@Override
	public List<Food> findAll(){
		return foodRepository.findAll();
	}
}
