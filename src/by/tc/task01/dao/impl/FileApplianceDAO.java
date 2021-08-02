package by.tc.task01.dao.impl;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class FileApplianceDAO implements ApplianceDAO{
	
	@Override // TODO variables titles!! change structure?
	public List<Appliance> find(Criteria criteria) throws DAOException {
		List<Appliance> resultOfFind = new ArrayList<Appliance>();
		
		try{
			BufferedReader bReader = new BufferedReader(new FileReader
			("/home/artem/workspace2/layered-arch-01/src/resources/appliances_db.txt"));
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
		      			resultOfFind.add(tmpResult); //TODO need new idea!?
		    		} 
		    	}		                 
		    }
		    
		    bReader.close();
		}
		 catch(IOException e){		             
			 throw new DAOException(e);
		} 
		
		return resultOfFind;
	}

	
	@Override
	public void add(Appliance appliance) throws DAOException {
		// TODO body with reusing compare
		
	}
	

	@Override // TODO replace file and tmpFile with validation, check variables titles
	public void remove(Appliance appliance) throws DAOException {
		Criteria criteria = new Criteria(appliance.getClassName(), appliance.getParametrs());

		try{
			BufferedReader bReader = new BufferedReader(new FileReader
			("/home/artem/workspace2/layered-arch-01/src/resources/appliances_db.txt"));
		    String textLine;
		    
		    // TODO check if not created
		    File tmpFile = new File ("/home/artem/workspace2/layered-arch-01/src/resources/appTempFile.txt");
    		if (tmpFile.createNewFile()) {
    	        System.out.println("File created: " + tmpFile.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    		BufferedWriter bWriter = new BufferedWriter(new FileWriter(tmpFile));
    		
		    
		    while((textLine = bReader.readLine()) != null){	    	
		    	boolean allCriteriasMapped = compareAppliances(textLine,  criteria);
		    	//System.out.println(allCriteriasMapped);
		    	if (!allCriteriasMapped) {
		    		bWriter.write(textLine + "\n");	
		    	} 
		    }
		    bWriter.close();
			bReader.close();
		}
		 catch(IOException e){		             
			 throw new DAOException(e);
		}
		finally { // add
			
		}
	} 
	
	//compare line from text and criteria
	private boolean compareAppliances(String textLine, Criteria criteria) {
		    	boolean allCriteriasMapped = false;
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
	    		
					Set setFromFileDetails = details.entrySet();
					Set setFromCriterias = criteria.getCriterias().entrySet();
					Iterator iteratorForCriteriasSet = setFromCriterias.iterator();
	    		
					allCriteriasMapped = true;
					while (iteratorForCriteriasSet.hasNext()) {
						if (!(setFromFileDetails.contains(iteratorForCriteriasSet.next()))) {
							allCriteriasMapped = false;
							break;
						}
					}
				}
				return allCriteriasMapped;
			}
		
}


//you may add your own new classes