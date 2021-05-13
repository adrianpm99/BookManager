package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Repository("ShelvingDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/ShelvingDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ShelvingDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_ID = "SHELVINGID";
	public static final String ATTR_PUBLICNUMBER = "SHELVINGPUBLICNUMBER";

}