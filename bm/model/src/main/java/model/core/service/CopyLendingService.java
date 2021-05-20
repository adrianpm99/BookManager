package model.core.service;

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
	public EntityResult copyLendingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyLendingDao, keyMap, attrList);
	}

	@Override
	public EntityResult copyLendingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.copyLendingDao, attrMap);
	}

	@Override
	public EntityResult copyLendingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityResult copyLendingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
