package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ICopyLendingService {
	// COPYLENDING
	public EntityResult copyLendingQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult copyLendingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult copyLendingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult copyLendingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}
