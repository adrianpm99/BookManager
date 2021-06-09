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

import api.core.service.IBookService;
import model.core.dao.BookDao;

@Service("BookService")
@Lazy
public class BookService implements IBookService {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Override
	public EntityResult bookQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.bookDao, keyMap, attrList);
	}
	@Secured({ PermissionsProviderSecured.SECURED })
	@Override
	public EntityResult bookInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.bookDao, attrMap);
	}
	@Secured({ PermissionsProviderSecured.SECURED })
	@Override
	public EntityResult bookUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.bookDao, attrMap, keyMap);
	}
	@Secured({ PermissionsProviderSecured.SECURED })
	@Override
	public EntityResult bookDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.bookDao, keyMap);
	}

}
