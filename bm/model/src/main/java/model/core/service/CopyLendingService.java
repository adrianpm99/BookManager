package model.core.service;

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

import api.core.service.ICopyLendingService;
import model.core.dao.CopyLendingDao;

@Service("CopyLendingService")
@Lazy
public class CopyLendingService implements ICopyLendingService {
	
	@Autowired
	private CopyLendingDao copyLendingDao;
	
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	@Override
	public EntityResult copylendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyLendingDao, keyMap, attrList);
	}

	@SuppressWarnings("static-access")
	@Override
	public EntityResult copylendingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> data2 = new HashMap<String, Object>();
		List<String> attr = new ArrayList<String>();
		EntityResult entityResult=null;
		EntityResult query;
		data.put(copyLendingDao.ATTR_COPYID, attrMap.get(copyLendingDao.ATTR_COPYID));
		data2.put(copyLendingDao.ATTR_LENDINGID, attrMap.get(copyLendingDao.ATTR_LENDINGID));
	    attr.add(copyLendingDao.ATTR_COPYID);
	    query = this.copyFromLendingReturnDateNullQuery(data, attr);
	    int copiesNumber = this.copylendingQuery(data2, attr).calculateRecordNumber();
	    if(copiesNumber>= 3) {
	    	entityResult = null;
	    }else if(query.isEmpty()) {
	    	entityResult =  this.daoHelper.insert(this.copyLendingDao, attrMap);
	    }
		return entityResult;
	}

	@Override
	public EntityResult copylendingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityResult copylendingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public EntityResult copyFromLendingReturnDateNullQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyLendingDao, keyMap, attrList, copyLendingDao.QUERY_COPY_FROM_LENDING_RETURNDATE_NULL);
	}

}
