package by.tc.task01.dao.impl;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.dao.ApplianceNames;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

public class AppProvider {
	
	private Appliance appliance;
	
	public AppProvider(Criteria criteriaFromFile) {
		
		String objectName = criteriaFromFile.getSearchName().toUpperCase();
		Map<String, Object> appDetails = criteriaFromFile.getCriterias();
		
		switch (objectName) {
		  case "LAPTOP":
			appliance = new Laptop(appDetails);
		    break;
		  case "OVEN":
			appliance = new Oven(appDetails);
		    break;
		  case "REFREGERATOR":
			appliance = new Refrigerator(appDetails);
		    break;
		  case "SPEAKERS":
			appliance = new Speakers(appDetails);
		    break;
		  case "TABLETPC":
			appliance = new TabletPC(appDetails);
		    break;
		  case "VACUUMCLEANER":
			appliance = new VacuumCleaner(appDetails);
		    break;
		}
	}
	
	public Appliance createAppliance() {
		return appliance;
	}	

}
