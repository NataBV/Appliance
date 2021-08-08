package by.tc.task01.service.validation;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.criteria.SearchCriteria.Oven;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		// you may add your own code here
		boolean found = true;
		SearchCriteria.Oven[] ovenEnums = SearchCriteria.Oven.values();
		Set<String> criteriaKeys = criteria.getCriterias().keySet();
		
		Iterator<String> iteratorOfKeys = criteriaKeys.iterator();
		while (iteratorOfKeys.hasNext()){
			found = false;
			String iteratorKeyElement = iteratorOfKeys.next();
			for(int i = 0; i < ovenEnums.length; i++) {
				if(iteratorKeyElement.equals(ovenEnums[i].name()));{
					found = true;
				}	
			} if (found == false) {
				return found;
			}
		}
		return found;
	}
	
	public static boolean criteriaValidator(Appliance appliance) {
		// you may add your own code here
		
		return true;
	}

}

//you may add your own new classes