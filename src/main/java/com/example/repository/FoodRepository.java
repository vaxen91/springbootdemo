package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Food;



@Repository("foodRepository")
public interface FoodRepository extends JpaRepository<Food, Long>{
	Food findByName(String name);

}
