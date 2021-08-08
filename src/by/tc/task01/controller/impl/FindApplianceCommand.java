package by.tc.task01.controller.impl;

import java.util.List;

import by.tc.task01.controller.Command;
import by.tc.task01.controller.util.RequestUtil;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class FindApplianceCommand implements Command {
	
	private static final int APPLIANE_TYPE = 1;
	private static final String FIND_IN_ALL_PARAM = "all";

	@Override
	public String execute(String request) {

		
		Criteria criteria = RequestUtil.create(request);

		String response;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		try {
			List<Appliance> result = service.find(criteria);
			int i = result.size();
			if (result.size() > 0) {
				response = "OK - " + result.toString();
			}else {
				response = "Sorry - But we don't have what you want.";
			}
		} catch (ServiceException e) {
			// log
			response = "Sorry!!! Error.";
		}

		return response;
	}


}
