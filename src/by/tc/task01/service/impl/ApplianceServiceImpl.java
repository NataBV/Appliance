package by.tc.task01.service.impl;



import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) throws ServiceException {
		if (!Validator.criteriaValidator(criteria)) { 
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<Appliance> appliances;
		try {
			appliances = applianceDAO.find(criteria);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		
		return appliances;
	}
	
	@Override
	public void remove(Criteria criteriaToRemove) throws ServiceException {
		if (!Validator.criteriaValidator(criteriaToRemove)) { 
			return;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		try {
			applianceDAO.remove(criteriaToRemove);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}
	
	@Override
	public void add(Criteria criteriaToAdd) throws ServiceException {
		if (!Validator.criteriaValidator(criteriaToAdd)) { 
			return;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		try {
			applianceDAO.add(criteriaToAdd);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	
	}
	
}

