package by.tc.task01.dao.impl;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class FileApplianceDAO implements ApplianceDAO{
	
	@Override
	public List<Appliance> find(Criteria criteria) {
		
		List<Appliance> resultOfFind = new ArrayList<Appliance>();
		
		try(BufferedReader bReader = new BufferedReader(new FileReader
			("/home/artem/workspace2/layered-arch-01/src/resources/appliances_db.txt"))){
			
		    String textLine;
		    
		    while((textLine = bReader.readLine()) != null){	    	
		    	String[] s = textLine.split(" : ");		    	
		    	 if (s[0].equals(criteria.getGroupSearchName())) {
		    		Map<String, Object> details = new HashMap<String, Object>();
		    		String[] map = s[1].split(", ");    		
		    		for(String line: map) {
		    			String[] detElement = line.split("=");
		    			try {
		    				int num = Integer.parseInt(detElement[1].trim());
		    				details.put(detElement[0].trim(), num);
		    			} catch(NumberFormatException e) {
		    				details.put(detElement[0].trim(), detElement[1].trim());
		    			}	
		    		}
		    		Set s1 = details.entrySet();
		    		Set set = criteria.getCriterias().entrySet();
		    		Iterator s2 = set.iterator();
		    		
		    		boolean allCriterias = true;
		    		while (s2.hasNext()) {
		    			if (!(s1.contains(s2.next()))) {
			     			allCriterias = false;
			     			break;
		    			}
		    		}
		    		System.out.println(allCriterias);
		    		if (allCriterias) {
		    			Appliance tmpResult = new Appliance(details);
		      			resultOfFind.add(tmpResult); 
		    		} 
		    	}		                 
		    }
		    
		    bReader.close();
		}
		 catch(IOException ex){		             
		    System.out.println(ex.getMessage());
		} 
		
		return resultOfFind;
	}

	
	@Override
	public void add(Appliance appliance) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void remove(Appliance appliance) {
		
		Criteria criteria = new Criteria(appliance.getClassName(), appliance.getParametrs());
		
		
		try(BufferedReader bReader = new BufferedReader(new FileReader
			("/home/artem/workspace2/layered-arch-01/src/resources/appliances_db.txt"))){
			
		    String textLine;
		    
		    File tmpFile = new File ("/home/artem/workspace2/layered-arch-01/src/resources/appTempFile.txt");
    		if (tmpFile.createNewFile()) {
    	        System.out.println("File created: " + tmpFile.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    		
    		BufferedWriter bWriter = new BufferedWriter(new FileWriter(tmpFile));
    		
		    
		    while((textLine = bReader.readLine()) != null){	    	
		    	String[] s = textLine.split(" : ");		    	
		    	 if (s[0].equals(criteria.getGroupSearchName())) {
		    		Map<String, Object> details = new HashMap<String, Object>();
		    		String[] map = s[1].split(", ");    		
		    		for(String line: map) {
		    			String[] detElement = line.split("=");
		    			try {
		    				int num = Integer.parseInt(detElement[1].trim());
		    				details.put(detElement[0].trim(), num);
		    			} catch(NumberFormatException e) {
		    				details.put(detElement[0].trim(), detElement[1].trim());
		    			}	
		    		}
		    		
		    		Set s1 = details.entrySet();
		    		Set set = criteria.getCriterias().entrySet();
		    		Iterator s2 = set.iterator();
		    		
		    		boolean allCriteriasMapped = true;
		    		while (s2.hasNext()) {
		    			if (!(s1.contains(s2.next()))) {
			     			allCriteriasMapped = false;
			     			break;
		    			}
		    		}
		    		System.out.println(allCriteriasMapped);
		    		
		    		if (!allCriteriasMapped) {
		    			bWriter.write(textLine + "\n");	
		    		} 
		    	} else {
		    		bWriter.write(textLine + "\n");
		    	}
		    }
		    bWriter.close();
			bReader.close();
		}
		 catch(IOException ex){		             
		    System.out.println(ex.getMessage());
		}
	}
	
	private boolean compareAppliances(Criteria criteria) {
		
		return true;
	}
	
}


//you may add your own new classes