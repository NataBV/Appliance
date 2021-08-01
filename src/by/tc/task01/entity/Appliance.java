package by.tc.task01.entity;

import java.util.*;

import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;

public class Appliance {//???????
	Map<String, Object> parametrs;
	
	public Appliance() { 
		parametrs = new HashMap<String, Object>();
	}
	public Appliance(Map<String, Object> parametrs) {
		this.parametrs = parametrs;
	}
	
	public Map<String, Object> getParametrs() {
		return this.parametrs;
	}
	
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	/*public String toLine() {
		String result = this.getClass().getSimpleName() + " : " + this.parametrs.toString().replace("{", "").replace("}", "") ;
		System.out.println(result);
		return result;
	}*/
}
