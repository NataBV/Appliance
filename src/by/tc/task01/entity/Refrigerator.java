package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Refrigerator implements Appliance{
	
	int powerCon, weight, freezCapacity, height, width;
	double overallCapacity;
	
	public Refrigerator(int powCons, int weight, int freezCapacity,
			int height, int width, double overallCapacity) {
		
		this.powerCon = powCons;
		this.weight = weight;
		this.freezCapacity = freezCapacity;
		this.height = height;
		this.width = width;
		this.overallCapacity = overallCapacity;
		
	}

	public Refrigerator(Map<String, Object> refrDetails) { 
		
		this.powerCon = (int)refrDetails.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString());
		this.weight = (int)refrDetails.get(SearchCriteria.Refrigerator.WEIGHT.toString());
		this.freezCapacity = (int)refrDetails.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString());
		this.height = (int)refrDetails.get(SearchCriteria.Refrigerator.HEIGHT.toString());
		this.width = (int)refrDetails.get(SearchCriteria.Refrigerator.WIDTH.toString());
		this.overallCapacity = (double)refrDetails.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString());;
		
		}
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
		parametrs.put("POWER_CONSUMPTION", powerCon);
		parametrs.put("WEIGHT", weight);
		parametrs.put("FREEZER_CAPACITY", freezCapacity);
		parametrs.put("HEIGHT", height);
		parametrs.put("WIDTH", width);
		parametrs.put("OVERALL_CAPACITY", overallCapacity);
				
		return parametrs;
	}
	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return "Refrigerator [powerCon=" + powerCon + ", weight=" + weight + ", freezCapacity=" + freezCapacity
				+ ", height=" + height + ", width=" + width + ", overallCapacity=" + overallCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + freezCapacity;
		result = prime * result + height;
		long temp;
		temp = Double.doubleToLongBits(overallCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + powerCon;
		result = prime * result + weight;
		result = prime * result + width;
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
		Refrigerator other = (Refrigerator) obj;
		if (freezCapacity != other.freezCapacity)
			return false;
		if (height != other.height)
			return false;
		if (Double.doubleToLongBits(overallCapacity) != Double.doubleToLongBits(other.overallCapacity))
			return false;
		if (powerCon != other.powerCon)
			return false;
		if (weight != other.weight)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	
	
}
