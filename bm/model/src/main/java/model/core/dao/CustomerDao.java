package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("CustomerDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CustomerDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CustomerDao extends OntimizeJdbcDaoSupport
{
	public static final String ATTR_CUSTOMERID = "CUSTOMERID";
	public static final String ATTR_CUSTOMERNAME = "CUSTOMERNAME";
	public static final String ATTR_CUSTOMERSURNAME = "CUSTOMERSURNAME";
	public static final String ATTR_CUSTOMERDNI = "CUSTOMERDNI";
	public static final String ATTR_CUSTOMERADDRESS = "CUSTOMERADDRESS";
	public static final String ATTR_CUSTOMERTLF = "CUSTOMERTLF";
	public static final String ATTR_CUSTOMEREMAIL = "CUSTOMEREMAIL";
	
}//CustomerDao