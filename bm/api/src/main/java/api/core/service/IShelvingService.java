package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IShelvingService {
	
	//Shelving
	
	public EntityResult shelvingQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult shelvingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult shelvingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult shelvingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}
