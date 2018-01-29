package com.example.service;

import java.util.List;

import com.example.model.Food;

public interface FoodService {

	public void saveFood(Food food);
	public Food findByName(String name);
	public List <Food> findAll();

}
