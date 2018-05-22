package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Food;



@Repository("foodRepository")
public interface FoodRepository extends JpaRepository<Food, Integer>{
	
	public Food findByName(String name);
	
	public List <Food> findAll();

}
