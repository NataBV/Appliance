package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.*;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;

public class DAOImplInspector {

	public static void main(String[] args) {
		/*Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);
		
		ApplianceDAO appDAO = new FileApplianceDAO();
		
		List<Appliance> apps = appDAO.find(criteriaTabletPC); 
		
		System.out.println(apps.size());
		
		Appliance ovenToRemove = new Oven(1500, 12, 33, 60, 45, 68);
		System.out.println(ovenToRemove.getParametrs().toString());
		appDAO.remove(ovenToRemove);*/
		
		
	}

}
