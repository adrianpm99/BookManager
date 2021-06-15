package model.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.IReservationService;
import model.core.dao.CopyDao;
import model.core.dao.CopyShelvingDao;
import model.core.dao.ReservationDao;
import model.core.dao.UserDao;

@Service("ReservationService")
@Lazy
public class ReservationService implements IReservationService {

	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Autowired
	private CopyDao copyDao;
	@Autowired
	private CopyShelvingDao copyShelvingDao;
	@Autowired
	private CopyShelvingService copyShelvingService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	

	@Override
	public EntityResult reservationQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.reservationDao, keyMap, attrList);
	}

	@SuppressWarnings("static-access")
	@Override
	public EntityResult reservationInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		EntityResult entityResult=null;
		EntityResult query;
		data.put(reservationDao.ATTR_BOOKID, attrMap.get(reservationDao.ATTR_BOOKID));
	    attr.add(copyDao.ATTR_ID);
	    query = this.reservationCheckAvaliableCopies(data, attr);
	    if(query.isEmpty()) {
	    	entityResult =  this.daoHelper.insert(this.reservationDao, attrMap);
	    }
		return entityResult;
	}

	@Override
	public EntityResult reservationUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.reservationDao, attrMap, keyMap);
	}

	@SuppressWarnings("static-access")
	@Override
	public EntityResult reservationDetailDelete(Map<String, Object> keyMap) 
			throws OntimizeJEERuntimeException {
		Map<String, Object> data = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		Map<String, Object> data2 = new HashMap<String, Object>();
		Map<String, Object> attrMap2 = new HashMap<String, Object>();
		EntityResult query;

		//get copyid and copyshelvingid from copyshelving
		data.put(reservationDao.ATTR_RESERVATIONID, keyMap.get(reservationDao.ATTR_RESERVATIONID));
		attr.add(copyShelvingDao.ATTR_COPYID);
		attr.add(copyShelvingDao.ATTR_COPYSHELVINGID);
		query = this.reservationQueryCopyShelving(data, attr);
		
		//get the value of COPYSHELVINGID to use in the update query
		@SuppressWarnings("unchecked")
		Vector<Integer> vector = (Vector<Integer>) query.get(CopyShelvingDao.ATTR_COPYSHELVINGID);
		Integer copyShelvingId = vector.elementAt(0);
	
		//the update query
		attrMap2.put(copyShelvingDao.ATTR_COPYSHELVINGID, copyShelvingId);
		data2.put(copyShelvingDao.ATTR_SHELVINGID, 1);
		this.copyShelvingService.copyShelvingUpdate(data2, attrMap2);
		
		return this.daoHelper.delete(this.reservationDao, keyMap);
		
			
	}

	@Override
	public EntityResult reservationDetailQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, model.core.dao.ReservationDao.QUERY_RESERVATION_DETAILS);
	
	}

	@Override
	public EntityResult reservationCheckAvaliableCopies(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, ReservationDao.QUERY_AVALIABLE_BOOK_COPIES);
	}
	
	@Override
	public EntityResult reservationAvailableQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, model.core.dao.ReservationDao.QUERY_RESERVATION_AVAILABLE);

	}

	@Override
	public EntityResult expiredReservationQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, ReservationDao.QUERY_EXPIRED_RESERVATION);
		
	}
	
	public EntityResult reservationQueryCopyShelving(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, ReservationDao.QUERY__RESERVATION_COPY_SHELVING);
	}
	
	@Override
	public EntityResult reservationCurrentQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, model.core.dao.ReservationDao.QUERY_RESERVATION_CURRENT);
		
	}
	
	public EntityResult customerReservationsQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException{
		
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, ReservationDao.QUERY_CUSTOMER_RESERVATIONS);
	}
	
	public EntityResult customerAvailableReservationsQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException{
		return this.daoHelper.query(this.reservationDao, keyMap, attrList, ReservationDao.QUERY_CUSTOMER_AVAILABLE_RESERVATIONS);
	}
	
	public EntityResult reservationAvailableOnlyForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException{
		Map<String, Object> key = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		String userLogin = userService.getUserLogin();
		
		//get customerid
		key.put(userDao.USER_, userLogin);
		attr = Arrays.asList(userDao.CUSTOMER_ID);
		EntityResult userRes = this.userService.userDataQuery(key, attr);
		Integer customerId = (Integer) userRes.getRecordValues(0).get(userDao.CUSTOMER_ID);
		
		//get reservations availables filter by customer id
		key.clear();
		key.put(reservationDao.ATTR_CUSTOMERID, customerId);
		EntityResult reservationRes = this.customerAvailableReservationsQuery(key, attrList);
		
		return reservationRes;
	}
	
	public EntityResult reservationOnlyForUserLoginQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException{
		Map<String, Object> key = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		String userLogin = userService.getUserLogin();
		
		//get customerid
		key.put(userDao.USER_, userLogin);
		attr = Arrays.asList(userDao.CUSTOMER_ID);
		EntityResult userRes = this.userService.userDataQuery(key, attr);
		Integer customerId = (Integer) userRes.getRecordValues(0).get(userDao.CUSTOMER_ID);
		
		//get reservations filter by customer id
		key.clear();
		key.put(reservationDao.ATTR_CUSTOMERID, customerId);
		EntityResult reservationRes = this.customerReservationsQuery(key, attrList);
		
		return reservationRes;
	}

}
