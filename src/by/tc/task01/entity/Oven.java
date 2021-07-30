package by.tc.task01.entity;

import java.util.*;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Oven extends Appliance{
	
	public Oven() { 
		parametrs = new HashMap<String, Object>();
	}
	public Oven(Map<String, Object> parametrs) {
		this.parametrs = parametrs;
	}
	public Oven(int val1, int val2, int val3, int val4, double val5, double val6) { 	
		parametrs.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), val1);
		parametrs.put(SearchCriteria.Oven.WEIGHT.toString(), val2);
		parametrs.put(SearchCriteria.Oven.CAPACITY.toString(), val3);
		parametrs.put(SearchCriteria.Oven.DEPTH.toString(), val4);
		parametrs.put(SearchCriteria.Oven.HEIGHT.toString(), val5);
		parametrs.put(SearchCriteria.Oven.WIDTH.toString(), val6);
	}	
	
}
