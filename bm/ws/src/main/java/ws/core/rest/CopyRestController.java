package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.ICopyService;

@RestController
@RequestMapping("/copys")
@ComponentScan(basePackageClasses = { ICopyService.class })
public class CopyRestController extends ORestController<ICopyService>{

		@Autowired
		private ICopyService copyService;

		@Override
		public ICopyService getService() {
			return this.copyService;
		}

}
