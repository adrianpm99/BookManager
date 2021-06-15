package model.core.dao;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Lazy
@Repository(value = "UserDao")
@ConfigurationFile(
	configurationFile = "dao/UserDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")
public class UserDao extends OntimizeJdbcDaoSupport {

	
	public static final String USER_ = "user_";
	public static final String SCHEMA        = "db_schema";
	public static final String CREATION_DATE = "user_creation_date";
	public static final String DOWN_DATE     = "user_down_date";
	public static final String CUSTOMER_ID = "customerid";
	public static final String QUERY_DATA_FROM_USER = "dataFromUser";

}
