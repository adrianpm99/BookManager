package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Repository("ReservationDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/ReservationDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ReservationDao extends OntimizeJdbcDaoSupport {

	public static final String ATTR_RESERVATIONID = "RESERVATIONID";
	public static final String ATTR_BOOKID = "BOOKID";
	public static final String ATTR_CUSTOMERID = "CUSTOMERID";
	public static final String ATTR_COPYID = "COPYID";
	public static final String ATTR_BOOKTITLE = "BOOKTITLE";
	public static final String ATTR_RESERVATIONDEADLINE = "RESERVATIONDEADLINE";
	public static final String QUERY_RESERVATION_DETAILS = "details";
	public static final String QUERY_AVALIABLE_BOOK_COPIES= "check_avaliable_book_copies"; 
	public static final String QUERY_RESERVATION_AVAILABLE = "reservationsAvailable";
	public static final String QUERY_EXPIRED_RESERVATION = "expiredReservation";
	public static final String QUERY__RESERVATION_COPY_SHELVING = "reservationCopyShelving";
	public static final String QUERY_RESERVATION_CURRENT = "reservationCurrent";
	public static final String QUERY_CUSTOMER_PENDING_RESERVATIONS = "customerPendingReservations";
	public static final String QUERY_CUSTOMER_AVAILABLE_RESERVATIONS = "customerAvailableReservations";
}