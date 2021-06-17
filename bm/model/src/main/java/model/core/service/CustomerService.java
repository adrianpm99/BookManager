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
import com.ontimize.jee.server.security.SecurityTools;

import api.core.service.ICustomerService;
import model.core.dao.CustomerDao;
import model.core.dao.UserDao;

@Service("CustomerService")
@Lazy
public class CustomerService implements ICustomerService {

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

	@SuppressWarnings("static-access")
	@Override
	public EntityResult customerForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		Map<String, Object> key = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		String userLogin = userService.getUserLogin();

		// get customerid
		key.put(userDao.USER_, userLogin);
		attr = Arrays.asList(userDao.CUSTOMER_ID);
		EntityResult userRes = this.userService.userDataQuery(key, attr);
		Integer customerId = (Integer) userRes.getRecordValues(0).get(userDao.CUSTOMER_ID);

		// get customerid filter by customer id
		key.clear();
		key.put(customerDao.ATTR_CUSTOMERID, customerId);
		EntityResult customerRes = this.customerUserDataQuery(key, attrList);

		return customerRes;

	}

	@SuppressWarnings("static-access")
	@Override
	public EntityResult customerUserDataQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.customerDao, keyMap, attrList, this.customerDao.QUERY_CUSTOMERUSERDATA);

	}

	@SuppressWarnings("static-access")
	@Override
	public EntityResult customerUserDataUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {

		Map<String, Object> attr = new HashMap<>();
		Map<String, Object> key = new HashMap<>();
		List<String> attrList = new ArrayList<>();
		EntityResult entityResult = null;

		// get user_
		key.put(userDao.CUSTOMER_ID, keyMap.get(customerDao.ATTR_CUSTOMERID));
		attrList = Arrays.asList(userDao.USER_);
		EntityResult userRes = this.userService.userDataQuery(key, attrList);
		String user = (String) userRes.getRecordValues(0).get(userDao.USER_);
		key.clear();

		// build the update user query
		attr.put(userDao.PASSWORD, attrMap.get(userDao.PASSWORD));
		key.put(userDao.USER_, user);

		// if receive a password make the user update
		if (attrMap.containsKey(userDao.PASSWORD)) {
			entityResult = this.userService.userUpdate(attr, key);
			//invalidate browser cache for not save user credentials
			SecurityTools.invalidateSecurityManager(this.daoHelper.getApplicationContext());
		// if receive a customer data make the customer update
		}
		if (attrMap.containsKey(customerDao.ATTR_CUSTOMERADDRESS)
				|| attrMap.containsKey(customerDao.ATTR_CUSTOMERDNI)
				|| attrMap.containsKey(customerDao.ATTR_CUSTOMEREMAIL)
				|| attrMap.containsKey(customerDao.ATTR_CUSTOMERNAME)
				|| attrMap.containsKey(customerDao.ATTR_CUSTOMERSURNAME)
				|| attrMap.containsKey(customerDao.ATTR_CUSTOMERTLF)) {
			
			entityResult = this.customerUpdate(attrMap, keyMap);
		}
		
		return entityResult;

	}

}// CustomerService