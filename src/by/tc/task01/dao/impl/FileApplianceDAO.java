package by.tc.task01.dao.impl;

import java.io.*;
import java.util.*;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;

public class FileApplianceDAO implements ApplianceDAO {
	private static final String DB_FILE = "./src/resources/appliances_db.txt";
	private static final String ADD_FILE = "./src/resources/appTempFileToAdd.txt";
	private static final String REM_FILE = "./src/resources/appTempFile.txt";

	@Override // TODO variables titles!! change structure?
	public List<Appliance> find(Criteria criteria) throws DAOException {
		List<Appliance> resultOfFind = new ArrayList<Appliance>();

		try {
			BufferedReader bReader = new BufferedReader(new FileReader(DB_FILE));
			String textLine;

			while ((textLine = bReader.readLine()) != null) {
				if (textLine.equals("")) continue;
				
				Criteria criteriaFromFile = createCriteriaFromLine(textLine);

				if (criteriaFromFile.getSearchName().equalsIgnoreCase(criteria.getSearchName())
					&& (criteriasMappedFile(criteriaFromFile, criteria))) {
					
						Appliance tmpResult = new AppProvider(criteriaFromFile).createAppliance();
						resultOfFind.add(tmpResult);
				}
			}
			bReader.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return resultOfFind;
	}

	@Override // TODO delete old file and rename new
	public void add(Criteria criteria) throws DAOException {
		boolean needToAdd = true;
		BufferedReader bReader = null;
		BufferedWriter bWriter = null;

		try {
			bReader = new BufferedReader(new FileReader(DB_FILE));
			String textLine;

			// TODO check if not created
			File tmpFile = new File(ADD_FILE);

			bWriter = new BufferedWriter(new FileWriter(tmpFile));

			while ((textLine = bReader.readLine()) != null) {
				if (!textLine.equals("")) {
					boolean allCriteriasMapped = compareAppliances(textLine, criteria);
					if (!allCriteriasMapped) {
						bWriter.write(textLine + "\n");
					} else {
						needToAdd = false;
					}
				} else {
					bWriter.write(textLine + "\n");
				}

			}
			if (needToAdd) {
				String criteriaNameCapitaliz = capitalization(criteria.getSearchName());
				bWriter.write(criteriaNameCapitaliz + " : "
						+ criteria.getCriterias().toString().replace("{", "").replace("}", ""));
			} else {
				throw new DAOException("Record already exists.");
			}

			bWriter.close();
			bReader.close();

		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				bWriter.close();
				bReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}

	}

	@Override // TODO replace file and tmpFile with validation
	public void remove(Criteria criteria) throws DAOException {

		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		try {
			bReader = new BufferedReader(new FileReader(DB_FILE));
			String textLine;

			File tmpFile = new File(REM_FILE);

			bWriter = new BufferedWriter(new FileWriter(tmpFile));

			boolean removed = false;
			while ((textLine = bReader.readLine()) != null) {
				if (!textLine.equals("")) {
					boolean allCriteriasMapped = compareAppliances(textLine, criteria);
					if (!allCriteriasMapped) {
						bWriter.write(textLine + "\n");
					} else {
						removed = true;
					}
				} else {
					bWriter.write(textLine + "\n");
				}
			}
			if (!removed) {
				throw new DAOException("Criteria to remove not found.");
			}
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			try {
				bWriter.close();
				bReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
	}

	// compare line from text and criteria
	private boolean compareAppliances(String textLine, Criteria criteria) {
		boolean allCriteriasMapped = false;
		Criteria criteriaFromFile = createCriteriaFromLine(textLine);

		if (criteriaFromFile.getSearchName().equalsIgnoreCase(criteria.getSearchName())) {
			allCriteriasMapped = criteriasMappedFile(criteriaFromFile, criteria);	
		}
		return allCriteriasMapped;
	}

	private boolean criteriasMappedFile(Criteria criteriaFromFile, Criteria criteria) {
		Set setFromFileDetails = criteriaFromFile.getCriterias().entrySet();
		Set setFromCriterias = criteria.getCriterias().entrySet();
		Iterator iteratorCritSet = setFromCriterias.iterator();

		boolean allCriteriasMapped = true;
		while (iteratorCritSet.hasNext()) {
			if (!(setFromFileDetails.contains(iteratorCritSet.next()))) {
				allCriteriasMapped = false;
				break;
			}
		}
		return allCriteriasMapped;
	}
	
	private Criteria createCriteriaFromLine(String textLine) {
		String[] titleAndDetails = textLine.split(" : ");
		Criteria criteriaFromFile = new Criteria(titleAndDetails[0]);
		String[] arrOfDetails = titleAndDetails[1].split(", ");

		for (String entiry : arrOfDetails) {
			String[] detElement = entiry.split("=");
			criteriaFromFile.add(detElement[0].trim(), detElement[1].trim());
		}
		return criteriaFromFile;
	}

	private String capitalization(String word) {
		word = word.substring(0, 1).toUpperCase() + word.substring(1);
		return word;
	}

}
