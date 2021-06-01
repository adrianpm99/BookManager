package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("CopyShelvingDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CopyShelvingDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CopyShelvingDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_COPYSHELVINGID = "COPYSHELVINGID";
	public static final String ATTR_SHELVINGID = "SHELVINGID";
	public static final String ATTR_COPYID = "COPYID";

}
