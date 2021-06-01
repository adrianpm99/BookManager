package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.ICopyShelvingService;

@RestController
@RequestMapping("/copyshelvings")
@ComponentScan(basePackageClasses = { ICopyShelvingService.class })
public class CopyShelvingRestController extends ORestController<ICopyShelvingService> {

	@Autowired
	private ICopyShelvingService copyShelvingService;

	@Override
	public ICopyShelvingService getService() {
		return this.copyShelvingService;
	}

}
