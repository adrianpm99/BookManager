package model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.IShelvingService;
import model.core.dao.ShelvingDao;

@Service("ShelvingService")
@Lazy
public class ShelvingService implements IShelvingService{
	
	@Autowired
	private ShelvingDao ShelvingDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Override
	public EntityResult shelvingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.ShelvingDao, keyMap, attrList);
	}

	@Override
	public EntityResult shelvingInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {

		return this.daoHelper.insert(this.ShelvingDao, attrMap);
	}

	@Override
	public EntityResult shelvingUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {

		return this.daoHelper.update(this.ShelvingDao, attrMap, keyMap);
	}

	@Override
	public EntityResult shelvingDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {

		return this.daoHelper.delete(this.ShelvingDao, keyMap);
	}
	
}