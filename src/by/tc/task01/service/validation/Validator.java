package by.tc.task01.service.validation;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.criteria.SearchCriteria.Oven;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {

		boolean valid = true;
		Object[] appEnums = null; 
		Set<String> criteriaKeys = criteria.getCriterias().keySet();
		
		switch (criteria.getSearchName().toUpperCase()) {
		  case "LAPTOP":
			appEnums = SearchCriteria.Laptop.values();
		    break;
		  case "OVEN":
			appEnums = SearchCriteria.Oven.values();
		    break;
		  case "REFREGERATOR":
			appEnums  = SearchCriteria.Refrigerator.values();
		    break;
		  case "SPEAKERS":
			appEnums  = SearchCriteria.Speakers.values();
		    break;
		  case "TABLETPC":
			appEnums  = SearchCriteria.TabletPC.values();
		    break;
		  case "VACUUMCLEANER":
			appEnums  = SearchCriteria.VacuumCleaner.values();
		    break;
		}
		
		Iterator<String> iteratorOfCriteriaKeys = criteriaKeys.iterator();
		while (iteratorOfCriteriaKeys.hasNext()){
			valid = false;
			String iteratorKeyElement = iteratorOfCriteriaKeys.next();
			for(int i = 0; i < appEnums.length; i++) {
				if(iteratorKeyElement.equals(appEnums[i].toString())){
					valid = true;
				}	
			} 
			if (valid == false) {
				return valid;
			}
		}
		return valid;
	}
	
	public static boolean criteriaValidator(Appliance appliance) {
		// you may add your own code here
		
		return true;
	}

}

//you may add your own new classes