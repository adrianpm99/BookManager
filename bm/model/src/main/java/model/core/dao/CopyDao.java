package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Repository("CopyDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CopyDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CopyDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_ID = "COPYID";
	public static final String ATTR_BOOKID = "BOOKID";
	public static final String ATTR_NOTES = "COPYNOTES";
	public static final String QUERY_COPIES_AVAILABLE = "copiesAvailable";

}