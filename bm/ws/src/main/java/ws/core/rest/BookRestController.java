package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.IBookService;

@RestController
@RequestMapping("/books")
@ComponentScan(basePackageClasses = { IBookService.class })
public class BookRestController extends ORestController<IBookService> {

	@Autowired
	private IBookService bookService;

	@Override
	public IBookService getService() {
		return this.bookService;
	}

}
