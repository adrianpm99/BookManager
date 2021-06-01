package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ICopyShelvingService {
	// COPYSHELVING
	public EntityResult copyShelvingQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult copyShelvingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult copyShelvingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult copyShelvingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;	
}
