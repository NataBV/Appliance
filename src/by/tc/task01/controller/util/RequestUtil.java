package by.tc.task01.controller.util;

import by.tc.task01.entity.criteria.Criteria;

public class RequestUtil {
	
	private static final int APPLIANE_TYPE = 1;
	private static final String FIND_IN_ALL_PARAM = "all";
	
	private RequestUtil() {}
	
	public static Criteria create(String request) {
		String[] params = request.split("\\s+");
		Criteria criteria = new Criteria(request);


		String applianceType = params[APPLIANE_TYPE].split("=")[1];
		if (!FIND_IN_ALL_PARAM.equals(applianceType)) {
			criteria.setGroupSearchName(applianceType);
		}

		for (int i = 2; i < params.length; i++) {
			String[] applianceParam = params[i].split("=");
			criteria.add(applianceParam[0], applianceParam[1]);
		}
		
		return criteria;
	}


}
