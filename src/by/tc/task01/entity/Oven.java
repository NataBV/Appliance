package by.tc.task01.entity;

import java.util.*;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Oven extends Appliance{
	
	private int powerCon, weight, capacity, depth;
	private double height, width;
	
	/*public Oven() { 
		parametrs = new HashMap<String, Object>();
	}*/
	/*public Oven(Map<String, Object> parametrs) {
		this.parametrs = parametrs;
	}*/
	public Oven(int powerCon, int weight, int capacity,
			int depth, double height, double width) { 	
		
		this.powerCon = powerCon;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
		
	}	
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
		parametrs.put("POWER_CONSUMPTION", powerCon);
		parametrs.put("WEIGHT", weight);
		parametrs.put("CAPACITY", capacity);
		parametrs.put("DEPTH", depth);
		if ((height % 1) == 0) {
			
			parametrs.put("HEIGHT", (int)height);
		} else {
			parametrs.put("HEIGHT", height);
		}
		if ((width % 1) == 0) {
			parametrs.put("WIDTH", (int)width);
		} else {
			parametrs.put("WIDTH", width);
		}
		
		return parametrs;
	}
	
	
}
