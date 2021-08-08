package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class VacuumCleaner implements Appliance{
	
	int powerCon, motorSpeedReg, cleanWidth;
	String filterType, bagType, wandType;
	
	public VacuumCleaner(int powerCon, int motorSpeedReg, int cleanWidth,
			String filterType, String bagType, String wandType) {

		this.powerCon = powerCon;
		this.motorSpeedReg = motorSpeedReg;
		this.cleanWidth = cleanWidth;
		this.filterType = filterType;
		this.bagType = bagType;
		this.wandType = wandType;
		
	}

	public VacuumCleaner(Map<String, Object> vCleanerDetails) {
		
		this.powerCon = (int)vCleanerDetails.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString());
		this.motorSpeedReg = (int)vCleanerDetails.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString());
		this.cleanWidth = (int)vCleanerDetails.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString());
		this.filterType = (String)vCleanerDetails.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString());
		this.bagType = (String)vCleanerDetails.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString());
		this.wandType = (String)vCleanerDetails.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
		
	}
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
		parametrs.put("POWER_CONSUMPTION", powerCon);
		parametrs.put("MOTOR_SPEED_REGULATION", motorSpeedReg);
		parametrs.put("CLEANING_WIDTH", cleanWidth);
		parametrs.put("FILTER_TYPE", filterType);
		parametrs.put("BAG_TYPE", bagType);
		parametrs.put("WAND_TYPE", wandType);
				
		return parametrs;
	}

	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return "VacuumCleaner [powerCon=" + powerCon + ", motorSpeedReg="
				+ motorSpeedReg + ", cleanWidth=" + cleanWidth + ", filterType="
				+ filterType + ", bagType=" + bagType + ", wandType=" + wandType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bagType == null) ? 0 : bagType.hashCode());
		result = prime * result + cleanWidth;
		result = prime * result + ((filterType == null) ? 0 : filterType.hashCode());
		result = prime * result + motorSpeedReg;
		result = prime * result + powerCon;
		result = prime * result + ((wandType == null) ? 0 : wandType.hashCode());
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
		VacuumCleaner other = (VacuumCleaner) obj;
		if (bagType == null) {
			if (other.bagType != null)
				return false;
		} else if (!bagType.equals(other.bagType))
			return false;
		if (cleanWidth != other.cleanWidth)
			return false;
		if (filterType == null) {
			if (other.filterType != null)
				return false;
		} else if (!filterType.equals(other.filterType))
			return false;
		if (motorSpeedReg != other.motorSpeedReg)
			return false;
		if (powerCon != other.powerCon)
			return false;
		if (wandType == null) {
			if (other.wandType != null)
				return false;
		} else if (!wandType.equals(other.wandType))
			return false;
		return true;
	}
	
	
}
