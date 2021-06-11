package model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.security.PermissionsProviderSecured;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

import api.core.service.ICopyService;
import model.core.dao.CopyDao;

@Service("CopyService")
@Lazy
public class CopyService implements ICopyService{
	
	@Autowired
	private CopyDao copyDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult copyQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyDao, keyMap, attrList);
	}

	@SuppressWarnings("static-access")
	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult copyInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		double copyCode = Math.round(Math.random() * 100000);
		attrMap.put(copyDao.ATTR_CODE, copyCode);
		
		return this.daoHelper.insert(this.copyDao, attrMap);
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult copyUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.copyDao, attrMap, keyMap);
	}

	@Override
	@Secured({ PermissionsProviderSecured.SECURED })
	public EntityResult copyDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.copyDao, keyMap);
	}

	@Override
	public EntityResult copiesAvailableQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyDao, keyMap, attrList, CopyDao.QUERY_COPIES_AVAILABLE);
	}

	@Override
	public EntityResult copiesWithShelvingQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.copyDao, keyMap, attrList, CopyDao.QUERY_COPIES_WITH_SHELVING);

	}
	
}
