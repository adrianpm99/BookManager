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
import model.core.dao.UserDao;

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

	public void loginQuery(Map<?, ?> key, List<?> attr) {
	}

	//Sample to permission
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userQuery(Map<?, ?> keyMap, List<?> attrList) {
		return this.daoHelper.query(userDao, keyMap, attrList);
	}
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userInsert(Map<?, ?> attrMap) {
		return this.daoHelper.insert(userDao, attrMap);
	}
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userUpdate(Map<?, ?> attrMap, Map<?, ?> keyMap) {
		return this.daoHelper.update(userDao, attrMap, keyMap);
	}
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult userDelete(Map<?, ?> keyMap) {
		Map<Object, Object> attrMap = new HashMap<>();
		attrMap.put("user_down_date", new Timestamp(Calendar.getInstance().getTimeInMillis()));
		return this.daoHelper.update(this.userDao, attrMap, keyMap);
	}
	
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
