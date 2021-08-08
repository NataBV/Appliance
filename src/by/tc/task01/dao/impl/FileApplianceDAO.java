package by.tc.task01.dao.impl;

import java.io.*;
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
	public void add(Criteria criteria) throws DAOException {
		boolean needToAdd = true; 
		try{
			BufferedReader bReader = new BufferedReader(new FileReader
			("/home/artem/workspace2/layered-arch-01/src/resources/appliances_db.txt"));
		    String textLine;
		    
		    // TODO check if not created
		    File tmpFile = new File ("/home/artem/workspace2/layered-arch-01/src/resources/appTempFileToAdd.txt");
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
			    	}else {
			    		needToAdd = false;
			    	}
		    	} else {
		    		bWriter.write(textLine + "\n");
		    	}
		    	 
		    }
		    if (needToAdd) {
		    	bWriter.write(criteria.getGroupSearchName() + " : " 
		    		    + criteria.getCriterias().toString().replace("{", "").replace("}", ""));
		    }else {
		    	throw new DAOException("Record already exists.");
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
		
	

	@Override // TODO replace file and tmpFile with validation
	public void remove(Criteria criteria) throws DAOException {
		//Criteria criteria = new Criteria(appliance.getClassName(), appliance.getParametrs());
		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		try{
			bReader = new BufferedReader(new FileReader
			("/home/artem/workspace2/layered-arch-01/src/resources/appliances_db.txt"));
		    String textLine;
		    
		    // TODO check if not created
		    File tmpFile = new File ("/home/artem/workspace2/layered-arch-01/src/resources/appTempFile.txt");
    		if (tmpFile.createNewFile()) {
    	        System.out.println("File created: " + tmpFile.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    		bWriter = new BufferedWriter(new FileWriter(tmpFile));
    		
    		boolean removed = false;
		    while((textLine = bReader.readLine()) != null){
		    	if (!textLine.equals("")) {
		    		boolean allCriteriasMapped = compareAppliances(textLine,  criteria);
			    	if (!allCriteriasMapped) {
			    		bWriter.write(textLine + "\n");	
			    	} else {
			    		removed = true;
			    	}
		    	} else {
		    		bWriter.write(textLine + "\n");
		    	}
		    	 
		    }
			if(!removed) {
				throw new DAOException("Criteria to remove not found.");
			}
		}
		 catch(IOException e){		             
			 throw new DAOException(e);
		}
		finally {
			try {
			    bWriter.close();
				bReader.close();
			}
			catch(IOException e){		             
				throw new DAOException(e);
			}			
		}
	} 
	
	//compare line from text and criteria
	private boolean compareAppliances(String textLine, Criteria criteria) {
		    	boolean allCriteriasMapped = false;
		    	
		    	Criteria criteriaFromFile = createCriteriaFromLine(textLine);
		    	if (criteriaFromFile.getGroupSearchName().equalsIgnoreCase(criteria.getGroupSearchName())) {
				    		
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
			
		}

		return criteriaFromFile;
	}
		
}


//you may add your own new classes