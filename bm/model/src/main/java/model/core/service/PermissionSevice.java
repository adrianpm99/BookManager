package model.core.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.IPermissionService;
import model.core.dao.PermissionDao;
import model.core.dao.UserRoleDao;


@Service("PermissionService")
@Lazy
public class PermissionSevice implements IPermissionService {
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired 
	private UserRoleDao userRoleDao;
	
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	@Override
	public EntityResult permissionQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.permissionDao, keyMap, attrList);
		
	}
	

	@Override
	public EntityResult getQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		EntityResult entityResult = this.daoHelper.query(this.permissionDao, keyMap, attrList, PermissionDao.QUERY_CLIENT_PERMISSIONS);
		System.out.println(entityResult.toString());
		return entityResult;
		
	}
	
	@SuppressWarnings("static-access")
	@Override
	public String getUserPermissions() {
		try {
			// get user name
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserInformation userInfo = (UserInformation) authentication.getPrincipal();
			String userLogin = userInfo.getLogin();
			// get role id
			Map<String, Object> key = new HashMap<>();
			List<String> attr;
			key.put(userRoleDao.USER_, userLogin);
			attr = Arrays.asList(permissionDao.ATTR_ID_ROLENAME);
			EntityResult userRoleRes = getQuery(key, attr);
			Integer roleId = (Integer) userRoleRes.getRecordValues(0).get(permissionDao.ATTR_ID_ROLENAME);
			// get role permission
			key.clear();
			key.put(permissionDao.ATTR_ID_ROLENAME, roleId);
			attr = Arrays.asList(permissionDao.ATTR_JSONCLIENTPERMISSION);
			EntityResult roleRes = getQuery(key, attr);
			String permission = (String) roleRes.getRecordValues(0).get(permissionDao.ATTR_JSONCLIENTPERMISSION);
			return permission;

		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}

}
