package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ICustomerService
{
	// CUSTOMER
	public EntityResult customerQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult customerInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult customerUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult customerDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult customerForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException;
}//ICustomerService