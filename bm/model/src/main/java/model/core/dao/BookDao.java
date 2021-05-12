package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Repository("BookDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/BookDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class BookDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_ID = "BOOKID";
	public static final String ATTR_TITLE = "BOOKTITLE";
	public static final String ATTR_DESCRIPTION = "BOOKDESCRIPTION";
	public static final String ATTR_AUTHOR = "BOOKAUTHOR";
	public static final String ATTR_PAGENUMBER = "BOOKPAGENUMBER";
	public static final String ATTR_ISBN = "BOOKISBN";
	public static final String ATTR_EDITORIAL = "BOOKEDITORIAL";
	public static final String ATTR_EDITION = "BOOKEDITION";
	public static final String ATTR_BOOKPUBLICATIONYEAR = "BOOKPUBLICATIONYEAR";

	

}
