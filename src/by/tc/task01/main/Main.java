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

	public static void main(String[] args) throws ServiceException {
		
		FrontController controller = new FrontController();
		
		String request;
		String response;
		
		
		request = "find type=oven CAPACITY=33 HEIGHT=40.0";
	
		response = controller.doAction(request);
		
		System.out.println(response);
		
	}
		
		
		
		/*List<Appliance> appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 33);

		appliance = service.find(criteriaOven);

		//PrintApplianceInfo.print(appliance); // TODO add print
		System.out.println(appliance.size() + appliance.toString());

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 200);
		criteriaOven.add(Oven.DEPTH.toString(), 300);

		appliance = service.find(criteriaOven);

		//PrintApplianceInfo.print(appliance); // TODO add print
		System.out.println(appliance.size());

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

		appliance = service.find(criteriaOven);// find(Object...obj)

		//PrintApplianceInfo.print(appliance); // TODO add print
		System.out.println(appliance.size());
		
		/////////////////////////////////////////////
		//TODO check class calling?
		Appliance ovenToRemove = new by.tc.task01.entity.Oven(1500, 12, 33, 60, 45, 68);
		System.out.println(ovenToRemove.getParametrs().toString());
		service.remove(ovenToRemove);

	}*/

}
