package com.example.service;

import com.example.model.Food;

public interface FoodService {

	public void saveFood(Food food);

	Food findByName(String name);

}
