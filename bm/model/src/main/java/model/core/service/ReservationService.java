package model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.IReservationService;
import model.core.dao.ReservationDao;

@Service("ReservationService")
@Lazy
public class ReservationService implements IReservationService {

	@Autowired
	private ReservationDao ReservationDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Override
	public EntityResult reservationQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.ReservationDao, keyMap, attrList);
	}

	@Override
	public EntityResult reservationInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.ReservationDao, attrMap);
	}

	@Override
	public EntityResult reservationUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.ReservationDao, attrMap, keyMap);
	}

	@Override
	public EntityResult reservationDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.ReservationDao, keyMap);
	}

}
