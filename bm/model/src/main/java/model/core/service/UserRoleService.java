package model.core.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.IUserRoleService;
import model.core.dao.UserRoleDao;

@Service("UserRoleService")
@Lazy
public class UserRoleService implements IUserRoleService
{
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public EntityResult userRoleInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException
	{
		return this.daoHelper.insert(this.userRoleDao, attrMap);
	}
}