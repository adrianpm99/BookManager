package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ILendingService {
	//Lending
	public EntityResult lendingQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult lendingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult lendingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult lendingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult lendingDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult expiredLendingQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
}
