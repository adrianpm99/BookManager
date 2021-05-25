package model.core.service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.ILendingService;
import model.core.dao.LendingDao;

@Service("LendingService")
@Lazy
public class LendingService implements ILendingService{

	@Autowired
	private LendingDao lendingDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	
	@Override
	public EntityResult lendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList);
	}

	@Override
	public EntityResult lendingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.insert(this.lendingDao, attrMap);
	}

	@Override
	public EntityResult lendingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		
		//automatic insertion of the value of the return date to today
		LocalDate today = LocalDate.now();
		attrMap.put(lendingDao.ATTR_LENDINGRETURNDATE, today);		

		return this.daoHelper.update(this.lendingDao, attrMap, keyMap);
	}

	@Override
	public EntityResult lendingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.lendingDao, keyMap);
	}

	@Override
	public EntityResult lendingDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList, LendingDao.QUERY_LENDING_DETAILS);
	}

	@Override
	public EntityResult expiredLendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.lendingDao, keyMap, attrList, LendingDao.QUERY_EXPIRED_LENDING);
	}

	@Override
	public EntityResult copiesFromLendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.lendingDao, keyMap, attrList, LendingDao.QUERY_COPIES_FROM_LENDING);
	}
	
	
}
