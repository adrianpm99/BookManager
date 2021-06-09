package ws.core.rest;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.server.rest.ORestController;

import api.core.service.IPermissionService;

@RestController
@RequestMapping("/permissions")
@ComponentScan(basePackageClasses = { IPermissionService.class })
public class PermissionRestController extends ORestController<IPermissionService>{
	
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping(
			value = "/get",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityResult permissionsGet() {
		String permissionStr = permissionService.getUserPermissions();
		Hashtable<String, Object> permissionHT = new Hashtable<>();
		permissionHT.put("permission", permissionStr);
		EntityResult er = new EntityResult();
		er.addRecord(permissionHT);
		er.setCode(EntityResult.OPERATION_SUCCESSFUL);
		return er;
		
	}
	

	@Override
	public IPermissionService getService() {
		return this.permissionService;
	}

}
