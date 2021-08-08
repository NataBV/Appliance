package by.tc.task01.entity;

import java.util.*;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Oven implements Appliance{
	
	private String powerCon, weight, capacity, depth, height, width;
	
	
	
	public Oven(String powerCon, String weight, String capacity,
			String depth, String height, String width) {

		this.powerCon = powerCon;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
		
	}

	public Oven(Map<String, Object> ovenDetails) { 	
		
		this.powerCon = (String)ovenDetails.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString());
		this.weight = (String)ovenDetails.get(SearchCriteria.Oven.WEIGHT.toString());
		this.capacity = (String)ovenDetails.get(SearchCriteria.Oven.CAPACITY.toString());
		this.depth = (String)ovenDetails.get(SearchCriteria.Oven.DEPTH.toString());
		this.height = (String)ovenDetails.get(SearchCriteria.Oven.HEIGHT.toString());
		this.width = (String)ovenDetails.get(SearchCriteria.Oven.WIDTH.toString());
		
	}
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
		parametrs.put("POWER_CONSUMPTION", powerCon);
		parametrs.put("WEIGHT", weight);
		parametrs.put("CAPACITY", capacity);
		parametrs.put("DEPTH", depth);
		parametrs.put("HEIGHT", height);
		parametrs.put("WIDTH", width);
		
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
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((depth == null) ? 0 : depth.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((powerCon == null) ? 0 : powerCon.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
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
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (depth == null) {
			if (other.depth != null)
				return false;
		} else if (!depth.equals(other.depth))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (powerCon == null) {
			if (other.powerCon != null)
				return false;
		} else if (!powerCon.equals(other.powerCon))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
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
