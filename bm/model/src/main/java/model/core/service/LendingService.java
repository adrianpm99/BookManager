package model.core.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.security.PermissionsProviderSecured;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.ILendingService;
import model.core.dao.LendingDao;
import model.core.dao.UserDao;

@Service("LendingService")
@Lazy
public class LendingService implements ILendingService{

	@Autowired
	private LendingDao lendingDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	
	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult lendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList);
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult lendingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.insert(this.lendingDao, attrMap);
	}

	@SuppressWarnings("static-access")
	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult lendingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		
		//automatic insertion of the value of the return date to today
		LocalDate today = LocalDate.now();
		attrMap.put(lendingDao.ATTR_LENDINGRETURNDATE, today);		

		return this.daoHelper.update(this.lendingDao, attrMap, keyMap);
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult lendingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.lendingDao, keyMap);
	}

	@Override
	public EntityResult lendingDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList, LendingDao.QUERY_LENDING_DETAILS);
	}

	@Override
	public EntityResult expiredLendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.lendingDao, keyMap, attrList, LendingDao.QUERY_EXPIRED_LENDING);
	}

	@Override
	public EntityResult copiesFromLendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList, LendingDao.QUERY_COPIES_FROM_LENDING);
	}
	
	public EntityResult lendingsInProgressQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList,lendingDao.QUERY_LENDINGS_IN_PROGRESS);
	}
	
	@Override
	public EntityResult lendingsForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		Map<String, Object> key = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		String userLogin = getUserLogin();
		
		//get customerid
		key.put(userDao.USER_, userLogin);
		attr = Arrays.asList(userDao.CUSTOMER_ID);
		EntityResult userRes = this.userService.userDataQuery(key, attr);
		Integer customerId = (Integer) userRes.getRecordValues(0).get(userDao.CUSTOMER_ID);
		
		//get lendings filter by customer id
		key.clear();
		key.put(lendingDao.ATTR_CUSTOMER, customerId);
		EntityResult lendingRes = this.lendingQuery(key, attrList);
		
		return lendingRes;
		
	}
	
	public EntityResult lendingsInProgressForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		Map<String, Object> key = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		String userLogin = getUserLogin();
		
		//get customerid
		key.put(userDao.USER_, userLogin);
		attr = Arrays.asList(userDao.CUSTOMER_ID);
		EntityResult userRes = this.userService.userDataQuery(key, attr);
		Integer customerId = (Integer) userRes.getRecordValues(0).get(userDao.CUSTOMER_ID);
		
		//get lendings filter by customer id
		key.clear();
		key.put(lendingDao.ATTR_CUSTOMER, customerId);
		EntityResult lendingRes = this.lendingsInProgressQuery(key, attrList);
		
		return lendingRes;
	}
	
	//method to getUserLogin
	public String getUserLogin() {
		
		//get user name
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserInformation userInfo = (UserInformation) authentication.getPrincipal();
		String userLogin = userInfo.getLogin();
		
		return userLogin;
	}
	
}
