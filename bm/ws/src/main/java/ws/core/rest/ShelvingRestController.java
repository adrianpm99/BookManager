package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.IShelvingService;

@RestController
@RequestMapping("/shelvings")
@ComponentScan(basePackageClasses = { IShelvingService.class })
public class ShelvingRestController extends ORestController<IShelvingService>{

		@Autowired
		private IShelvingService ShelvingService;

		@Override
		public IShelvingService getService() {
			return this.ShelvingService;
		}

}
