package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Repository("BookDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/BookDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class BookDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_BOOKID = "BOOKID";
	public static final String ATTR_BOOKTITLE = "BOOKTITLE";
	public static final String ATTR_BOOKDESCRIPTION = "BOOKDESCRIPTION";
	public static final String ATTR_BOOKAUTHOR = "BOOKAUTHOR";
	public static final String ATTR_BOOKPAGENUMBER = "BOOKPAGENUMBER";
	public static final String ATTR_BOOKISBN = "BOOKISBN";
	public static final String ATTR_BOOKEDITORIAL = "BOOKEDITORIAL";
	public static final String ATTR_BOOKEDITION = "BOOKEDITION";
	public static final String ATTR_BOOKPUBLICATIONYEAR = "BOOKPUBLICATIONYEAR";

	

}
