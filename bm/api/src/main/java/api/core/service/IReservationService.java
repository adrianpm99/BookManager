package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IReservationService {

	// RESERVATION
	public EntityResult reservationQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult reservationInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
	public EntityResult reservationUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult reservationDetailDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
	public EntityResult reservationDetailQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult reservationCheckAvaliableCopies(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult reservationAvailableQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult expiredReservationQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
	public EntityResult reservationCurrentQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
}
