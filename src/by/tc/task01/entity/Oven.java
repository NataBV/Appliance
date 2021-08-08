package by.tc.task01.entity;

import java.util.*;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Oven implements Appliance{
	
	private int powerCon, weight, capacity, depth;
	private double height, width;
	
	public Oven(int powerCon, int weight, int capacity,
			int depth, double height, double width) { 	
		
		this.powerCon = powerCon;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
		
	}
	
	public Oven(Map<String, Object> ovenDetails) { 	
		
		this.powerCon = (int)ovenDetails.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString());
		this.weight = (int)ovenDetails.get(SearchCriteria.Oven.WEIGHT.toString());
		this.capacity = (int)ovenDetails.get(SearchCriteria.Oven.CAPACITY.toString());
		this.depth = (int)ovenDetails.get(SearchCriteria.Oven.DEPTH.toString());
		this.height = (double)ovenDetails.get(SearchCriteria.Oven.HEIGHT.toString());
		this.width = (double)ovenDetails.get(SearchCriteria.Oven.WIDTH.toString());
		
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
	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + depth;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + powerCon;
		result = prime * result + weight;
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oven other = (Oven) obj;
		if (capacity != other.capacity)
			return false;
		if (depth != other.depth)
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (powerCon != other.powerCon)
			return false;
		if (weight != other.weight)
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Oven [powerCon=" + powerCon + ", weight=" + weight + ", capacity="
				+ capacity + ", depth=" + depth	+ ", height=" + height + ", width="
				+ width + "]";
	}
	
	
	
}
