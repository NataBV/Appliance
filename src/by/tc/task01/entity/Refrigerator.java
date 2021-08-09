package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Refrigerator implements Appliance{
	
	String powerCon, weight, freezCapacity, height, width, overallCapacity;
	


	public Refrigerator(String powerCon, String weight, String freezCapacity,
			String height, String width, String overallCapacity) {

		this.powerCon = powerCon;
		this.weight = weight;
		this.freezCapacity = freezCapacity;
		this.height = height;
		this.width = width;
		this.overallCapacity = overallCapacity;
		
	}

	public Refrigerator(Map<String, Object> refrDetails) { 
		
		this.powerCon = (String)refrDetails.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString());
		this.weight = (String)refrDetails.get(SearchCriteria.Refrigerator.WEIGHT.toString());
		this.freezCapacity = (String)refrDetails.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString());
		this.height = (String)refrDetails.get(SearchCriteria.Refrigerator.HEIGHT.toString());
		this.width = (String)refrDetails.get(SearchCriteria.Refrigerator.WIDTH.toString());
		this.overallCapacity = (String)refrDetails.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString());;
		
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
		result = prime * result + ((freezCapacity == null) ? 0 : freezCapacity.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((overallCapacity == null) ? 0 : overallCapacity.hashCode());
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
		Refrigerator other = (Refrigerator) obj;
		if (freezCapacity == null) {
			if (other.freezCapacity != null)
				return false;
		} else if (!freezCapacity.equals(other.freezCapacity))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (overallCapacity == null) {
			if (other.overallCapacity != null)
				return false;
		} else if (!overallCapacity.equals(other.overallCapacity))
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
	
	
}
