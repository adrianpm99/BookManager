package model.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.security.PermissionsProviderSecured;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.ICustomerService;
import model.core.dao.CustomerDao;
import model.core.dao.UserDao;


@Service("CustomerService")
@Lazy
public class CustomerService implements ICustomerService
{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult customerQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.customerDao, keyMap, attrList);
	}

	@Override
	public EntityResult customerInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.customerDao, attrMap);
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult customerUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.customerDao, attrMap, keyMap);
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult customerDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.customerDao, keyMap);
	}
	
	@Override
	public EntityResult customerForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		Map<String, Object> key = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		String userLogin = userService.getUserLogin();
		
		//get customerid
		key.put(userDao.USER_, userLogin);
		attr = Arrays.asList(userDao.CUSTOMER_ID);
		EntityResult userRes = this.userService.userDataQuery(key, attr);
		Integer customerId = (Integer) userRes.getRecordValues(0).get(userDao.CUSTOMER_ID);
		
		//get customerid filter by customer id
		key.clear();
		key.put(customerDao.ATTR_CUSTOMERID, customerId);
		EntityResult customerRes = this.customerQuery(key, attrList);
		
		return customerRes;
		
	}
	
}//CustomerService