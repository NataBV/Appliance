package by.tc.task01.dao.impl;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
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
		    	if (!textLine.equals("")) {
		    		Criteria criteriaFromFile = createCriteriaFromLine(textLine);
			    	
			    	 if (criteriaFromFile.getGroupSearchName().equalsIgnoreCase(criteria.getGroupSearchName())) {
			    		 
			    		Set criteriaFromFileSet = criteriaFromFile.getCriterias().entrySet();
			    		Set criteriaSet = criteria.getCriterias().entrySet();
			    		Iterator criteriaSetIterator = criteriaSet.iterator();
			    		
			    		boolean allCriterias = true;
			    		while (criteriaSetIterator.hasNext()) {
			    			if (!(criteriaFromFileSet.contains(criteriaSetIterator.next()))) {
				     			allCriterias = false;
				     			break;
			    			}
			    		} 
			    		System.out.println(allCriterias);
			    		if (allCriterias) {
			    			Appliance tmpResult = new AppliancesProvider(criteriaFromFile).createAppliance();  
			      			resultOfFind.add(tmpResult); 
			    		} 
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

	
	@Override //TODO delete old file and rename new
	public boolean add(Appliance appliance) throws DAOException {
		boolean added = true;
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
		    	if (!textLine.equals("")) {
		    		boolean allCriteriasMapped = compareAppliances(textLine,  criteria);
			    	//System.out.println(allCriteriasMapped);
			    	if (!allCriteriasMapped) {
			    		bWriter.write(textLine + "\n");	
			    	}else {
			    		added = false;
			    	}
		    	} else {
		    		bWriter.write(textLine + "\n");
		    	}
		    	 
		    }
		    bWriter.write(textLine + "\n"); //textLine must be appliance.toLine();
		    
		    bWriter.close();
			bReader.close();
		}
		 catch(IOException e){		             
			 throw new DAOException(e);
		}
		finally { // add
			
		}
		return added;
	} 
		
	

	@Override // TODO replace file and tmpFile with validation
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
		    	if (!textLine.equals("")) {
		    		boolean allCriteriasMapped = compareAppliances(textLine,  criteria);
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
		 catch(IOException e){		             
			 throw new DAOException(e);
		}
		finally { // add
			
		}
	} 
	
	//compare line from text and criteria
	private boolean compareAppliances(String textLine, Criteria criteria) {
		    	boolean allCriteriasMapped = false;
		    	
		    	Criteria criteriaFromFile = createCriteriaFromLine(textLine);
		    	if (criteriaFromFile.getGroupSearchName().equals(criteria.getGroupSearchName())) {
				    		
					Set setFromFileDetails = criteriaFromFile.getCriterias().entrySet();
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
	
	private Criteria createCriteriaFromLine(String textLine) {
		
		String[] titleAndDetails = textLine.split(" : ");
		Criteria criteriaFromFile = new Criteria(titleAndDetails[0]);
		
		
		String[] arrOfDetails = titleAndDetails[1].split(", "); 
		for(String entiry: arrOfDetails) {
			String[] detElement = entiry.split("=");
			criteriaFromFile.add(detElement[0].trim(), detElement[1].trim());
			/*
			 * try { int num = Integer.parseInt(detElement[1].trim());
			 * criteriaFromFile.add(detElement[0].trim(), num); }
			 * catch(NumberFormatException e) { try { double num2 =
			 * Double.parseDouble(detElement[1].trim());
			 * criteriaFromFile.add(detElement[0].trim(), num2); }
			 * catch(NumberFormatException ex) { criteriaFromFile.add(detElement[0].trim(),
			 * detElement[1].trim()); } }
			 */
		}

		return criteriaFromFile;
	}
		
}


//you may add your own new classes