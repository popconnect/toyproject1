package com.personal.juice.sql;

public class Beverage {
	private int pk;
	private String Beverage;
	private String name;
    private String type;
    private String brand;
    private int calories;
    private String servingSize;
    private int caffeine;
    
    public Beverage() {
    	
    }
    
    public Beverage(String resultType, String resultBrand, String resultBeverage) {
		// TODO Auto-generated constructor stub
    	this.type = resultType; this.brand = resultBrand; this.Beverage = resultBeverage;
	}
    
	public int getPk() {
    	return pk;
    }
    public void setPk(int pk) {
    	this.pk = pk;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getServingSize() {
		return servingSize;
	}
	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}
	public int getCaffeine() {
		return caffeine;
	}
	public void setCaffeine(int caffeine) {
		this.caffeine = caffeine;
	}
	public String getBeverage() {
		return Beverage;
	}
	public void setBeverage(String beverage) {
		Beverage = beverage;
	}
    
    
}