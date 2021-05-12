package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ICopyService {

	// COPY
	public EntityResult copyQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult copyInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult copyUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult copyDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}
