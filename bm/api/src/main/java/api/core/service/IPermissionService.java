package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IPermissionService {
	
	public EntityResult permissionQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult getQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public String getUserPermissions();

}
