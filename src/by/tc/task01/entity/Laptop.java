package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Laptop implements Appliance{
	// add variables, hash, equals and toString
	
	public Laptop(Map<String, Object> laptopDetails) { 
		
	}
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
				
		return parametrs;
	}
	
	/*@Override
	public String toLine() {
		String result = this.getClass().getSimpleName() + " : " + this.parametrs.toString().replace("{", "").replace("}", "") ;
		System.out.println(result);
		return result;
	}*/
	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
}
