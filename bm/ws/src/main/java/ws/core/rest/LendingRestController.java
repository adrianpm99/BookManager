package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.ILendingService;

@RestController
@RequestMapping("/lendings")
@ComponentScan(basePackageClasses = { ILendingService.class })
public class LendingRestController extends ORestController<ILendingService>{

	@Autowired
	private ILendingService lendingService;
	
	@Override
	public ILendingService getService() {
		return this.lendingService;
	}

}
