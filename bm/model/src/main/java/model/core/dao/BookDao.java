package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Repository("BookDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/BookDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class BookDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_ID = "ID";
	public static final String ATTR_TITLE = "TITLE";
	public static final String ATTR_DESCRIPTION = "DESCRIPTION";
	public static final String ATTR_AUTHOR = "AUTHOR";
	public static final String ATTR_PAGENUMBER = "PAGENUMBER";
	public static final String ATTR_ISBN = "ISBN";
	public static final String ATTR_EDITORIAL = "EDITORIAL";
	public static final String ATTR_EDITION = "EDITION";
	public static final String ATTR_BOOKPUBLICATIONYEAR = "BOOKPUBLICATIONYEAR";

	

}
