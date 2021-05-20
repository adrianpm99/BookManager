package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("LendingDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/LendingDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class LendingDao extends OntimizeJdbcDaoSupport {
	
		public static final String ATTR_LENDINGID = "LENDINGID";
		public static final String ATTR_CUSTOMER = "CUSTOMERID";
		public static final String ATTR_LENDINGDATE = "LENDINGDATE";
		public static final String ATTR_LENDINGDEADLINE = "LENDINGDEADLINE";
		public static final String ATTR_LENDINGRETURNDATE = "LENDINGRETURNDATE";
		public static final String ATTR_LENDINGNOTES = "LENDINGNOTES";
		public static final String QUERY_LENDING_DETAILS = "details";
		public static final String QUERY_EXPIRED_LENDING = "expiredLending";
}
