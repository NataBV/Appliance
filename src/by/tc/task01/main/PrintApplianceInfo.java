package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static String print(Appliance appliance) {
		String toResultAppliance = (appliance.getClassName() + " : " 
    		    + appliance.getParametrs().toString().replace("{", "").replace("}", "").replace("," , ""));
    return toResultAppliance;
	}
	
	public static String printList(List<Appliance> appliances) {
		String toResultList = "";
		for(Appliance app: appliances) {
			toResultList += PrintApplianceInfo.print(app) + "\n";		
		}
			
		return toResultList;
	}

}
