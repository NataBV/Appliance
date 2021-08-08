package by.tc.task01.controller.impl;

import by.tc.task01.controller.Command;
import by.tc.task01.controller.util.RequestUtil;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class AddApplianceCommand implements Command {

		@Override
		public String execute(String request) {
			Criteria criteria = RequestUtil.create(request);

			String response;

			ServiceFactory factory = ServiceFactory.getInstance();
			ApplianceService service = factory.getApplianceService();

			try {
				service.add(criteria);
				response = "OK. Appialce is added \n";
			} catch (ServiceException e) {
				// log
				response = "Sorry!!! Error. "+e.getMessage() + "\n";
			}

			return response;
		}


}
