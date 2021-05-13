package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.server.rest.ORestController;

import api.core.service.IReservationService;

@RestController
@RequestMapping("/reservations")
@ComponentScan(basePackageClasses = { IReservationService.class })
public class ReservationRestController extends ORestController<IReservationService> {

	@Autowired
	private IReservationService reservationService;

	@Override
	public IReservationService getService() {
		return this.reservationService;
	}

}
