package com.expolre.pattern.decorator.coffee;

/**
 * 牛奶
 * @author lengyul
 *
 */
public class Milk extends CondimentDecorator{
	
	Beverage beverage;
	
	public Milk(Beverage beverage){
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		
		return beverage.getDescription() + ",Milk";
	}

	@Override
	public double cost() {
		
		return beverage.cost() + 0.10;
	}

}
