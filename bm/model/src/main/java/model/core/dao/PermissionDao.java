package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("PermissionDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/PermissionDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class PermissionDao extends OntimizeJdbcDaoSupport{
	
	public static final String ATTR_ID_ROLENAME = "ID_ROLENAME";
	public static final String ATTR_ROLENAME = "ROLENAME";
	public static final String ATTR_XMLCLIENTPERMISSION = "XMLCLIENTEPERMISSION";
	public static final String ATTR_JSONCLIENTPERMISSION = "JSONCLIENTPERMISSION";
	public static final String QUERY_CLIENT_PERMISSIONS = "clientPermissions";


}
