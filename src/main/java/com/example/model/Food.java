package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private int id;
	
	@Column(name = "food_name")
	private String name;
	
	@Column(name = "food_price")
	private int  price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodName() {
		return name;
	}

	public void setFoodName(String foodName) {
		this.name = foodName;
	}

	public int getFoodPrice() {
		return price;
	}

	public void setFoodPrice(int foodPrice) {
		this.price = foodPrice;
	}
	
	

}
