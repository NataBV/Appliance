package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private String groupSearchName;
	public Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public Criteria(String groupSearchName,Map<String, Object> criteria) {
		this.groupSearchName = groupSearchName;
		this.criteria = criteria;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}
	
	public void setGroupSearchName(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
	
	public void add(String searchCriteria, String value) {
		criteria.put(searchCriteria, value.toLowerCase());
	}
	
	// you may add your own code here
	
	public Map<String, Object> getCriterias() {
		return criteria;
	
	}

}
