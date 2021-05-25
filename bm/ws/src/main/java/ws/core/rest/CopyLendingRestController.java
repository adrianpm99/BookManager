package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.ICopyLendingService;

@RestController
@RequestMapping("/copylendings")
@ComponentScan(basePackageClasses = { ICopyLendingService.class })
public class CopyLendingRestController extends ORestController<ICopyLendingService> {

	@Autowired
	private ICopyLendingService copyLendingService;

	@Override
	public ICopyLendingService getService() {
		return this.copyLendingService;
	}

}
