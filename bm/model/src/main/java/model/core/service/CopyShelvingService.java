package model.core.service;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.ICopyShelvingService;
import model.core.dao.CopyShelvingDao;

@Service("CopyShelvingService")
@Lazy
public class CopyShelvingService implements ICopyShelvingService {
	
	@Autowired
	private CopyShelvingDao copyShelvingDao;
	
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	
	
	@Override
	public EntityResult copyShelvingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyShelvingDao, keyMap, attrList);

	}
	
	@Override
	public EntityResult copyShelvingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.copyShelvingDao, attrMap);

	}

	@Override
	public EntityResult copyShelvingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.copyShelvingDao, attrMap, keyMap);

	}

	@Override
	public EntityResult copyShelvingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.copyShelvingDao, keyMap);

	}
	
}