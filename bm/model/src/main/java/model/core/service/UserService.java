package model.core.service;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import api.core.service.IUserService;
import model.core.dao.CustomerDao;
import model.core.dao.UserDao;
import model.core.dao.UserRoleDao;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.security.PermissionsProviderSecured;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;


@Lazy
@Service("UserService")
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserRoleDao userRoleDao;
	

	public void loginQuery(Map<?, ?> key, List<?> attr) {
	}

	//Sample to permission
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userQuery(Map<?, ?> keyMap, List<?> attrList) {
		return this.daoHelper.query(userDao, keyMap, attrList);
	}
	
	@SuppressWarnings("static-access")
	public EntityResult userInsert(Map<String, Object> attrMap)
	{
		//Get the name of the new customer which will be added to user table 
		String userName= (String) attrMap.get("USER_");
		Map<String, Object> attr= new HashMap<>();
		attr.put(customerDao.ATTR_CUSTOMERNAME, "");
		
		//Add a new empty customer to customer table
		EntityResult customerInsert= this.customerService.customerInsert(attr);
		//Get the id generated for the new customer in the customer table
		Integer customerId= (Integer) customerInsert.get(customerDao.ATTR_CUSTOMERID);
		attrMap.put(customerDao.ATTR_CUSTOMERID, customerId);
		attr.clear();
		
		//Add data of the role to the map
		attr.put(userRoleDao.ID_ROLE_NAME, 1);
		attr.put(userRoleDao.USER_, userName);
		
		//Insert data into user table
		EntityResult userInsert= this.daoHelper.insert(userDao, attrMap);
		
		//Insert data into user_role table
		EntityResult userRoleInsert= this.userRoleService.userRoleInsert(attr);
		
		return userInsert;
	}
	
	
	public EntityResult userUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
		return this.daoHelper.update(userDao, attrMap, keyMap);
	}
	
	
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userDelete(Map<?, ?> keyMap) {
		Map<Object, Object> attrMap = new HashMap<>();
		attrMap.put("user_down_date", new Timestamp(Calendar.getInstance().getTimeInMillis()));
		return this.daoHelper.update(this.userDao, attrMap, keyMap);
	}
	@Override
	public EntityResult userDataQuery(Map<?, ?> keyMap, List<?> attrList) {
		return this.daoHelper.query(this.userDao, keyMap, attrList,userDao.QUERY_DATA_FROM_USER);
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
