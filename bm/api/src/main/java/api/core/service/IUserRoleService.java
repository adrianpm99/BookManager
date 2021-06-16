package api.core.service;

import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IUserRoleService 
{
	public EntityResult userRoleInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
}
