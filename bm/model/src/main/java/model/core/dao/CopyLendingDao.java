package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("CopyLendingDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CopyLendingDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CopyLendingDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_COPYLENDINGID = "COPYLENDINGID";
	public static final String ATTR_COPYID = "COPYID";
	public static final String ATTR_LENDINGID = "LENDINGID";
	public static final String QUERY_LAST_COPY_FROM_LENDING_RETURNDATE_NULL = "lastCopyFromLendingReturnDateNull";

}
