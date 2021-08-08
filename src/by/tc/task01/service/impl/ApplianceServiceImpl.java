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
		/*if (!Validator.criteriaValidator(criteria)) { //TODO body
			return null;
		}*/
		
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
	public void remove(Appliance applianceToREmove) throws ServiceException {
		if (!Validator.criteriaValidator(applianceToREmove)) { //TODO body
			return;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		try {
			applianceDAO.remove(applianceToREmove);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}
	
	@Override
	public boolean add(Appliance applianceToAdd) throws ServiceException {
		boolean result = true;
		if (!Validator.criteriaValidator(applianceToAdd)) { //TODO body
			return false;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		try {
			result = applianceDAO.add(applianceToAdd);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return result;	
	}
	
}

//you may add your own new classes
