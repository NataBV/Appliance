package by.tc.task01.main;


import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.tc.task01.controller.FrontController;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class Main { 
	/* TODO  create code to delete old and replace created files ,
	 * change line that added (possibly change row), improve creation of response,
	 *  ? add possibility to find from all, check code convention, layers */

	public static void main(String[] args) throws ServiceException {
		
		FrontController controller = new FrontController();
		
		String request;
		String response;
		
		
		request = "find type=oven CAPACITY=33"; // HEIGHT=40.0";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "remove type=oven CAPACITY=33 HEIGHT=40.0";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "add type=oven CAPACITY=33 POWER_CONSUMPTION=1500 WIDTH=68.0 WEIGHT=12 HEIGHT=45.0 DEPTH=60";
		response = controller.doAction(request);
		System.out.println(response);
		
	}
		
		
	

}
