package by.tc.task01.dao.impl;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.dao.ApplianceNames;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

public class AppliancesProvider {
	
	private Map<ApplianceNames, Appliance> appliances = new HashMap<>();
	
	public AppliancesProvider(Map<String, Object> appDetails) {
		appliances.put(ApplianceNames.LAPTOP, new Laptop(appDetails));
		appliances.put(ApplianceNames.OVEN, new Oven(appDetails));
		appliances.put(ApplianceNames.REFREGERATOR, new Refrigerator(appDetails));
		appliances.put(ApplianceNames.SPEAKERS, new Speakers(appDetails));
		appliances.put(ApplianceNames.TABLETPC, new TabletPC(appDetails));
		appliances.put(ApplianceNames.VACUUMCLEANER, new VacuumCleaner(appDetails));		
		
	}
	
	public Appliance createAppliance(Criteria criteriaFromFile) {
		String appNameToCreate = criteriaFromFile.getGroupSearchName().toUpperCase();
		ApplianceNames name = ApplianceNames.valueOf(appNameToCreate);
		Appliance createdApp = appliances.get(name);
		
		return createdApp;
	}	

}
