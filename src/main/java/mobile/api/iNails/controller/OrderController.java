package mobile.api.iNails.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobile.api.iNails.dao.CustomerDao;
import mobile.api.iNails.dao.OrderDao;
import mobile.api.iNails.dao.TimeDao;
import mobile.api.iNails.domain.CustomerImpl;
import mobile.api.iNails.domain.Invoice;
import mobile.api.iNails.domain.Order;
import mobile.api.iNails.domain.OrderImpl;
import mobile.api.iNails.domain.RequestOrderImpl;
import mobile.api.iNails.domain.StatusImpl;
import mobile.api.iNails.domain.Time;
import mobile.api.iNails.domain.TimeImpl;

@RestController
@RequestMapping(value="/rest/api/")
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private TimeDao timeDao;
	
	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
	
	final static String[] ERRORS = {
			"This customer is exsist",
			"Something went wrong, please try again"
	};
	
	@CrossOrigin
	@RequestMapping(value="invoices/{orderID}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invoice> findInvoiceByOrderNumber(@PathVariable("orderID") Integer orderID){
		Invoice invoice = orderDao.findInvoiceByOrderNumber(orderID);
		return (invoice == null)? new ResponseEntity<Invoice>(HttpStatus.NO_CONTENT) : new ResponseEntity<Invoice>(invoice,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value="", method= RequestMethod.POST)
	public ResponseEntity<String> receiveNewOrder(@RequestBody RequestOrderImpl requestOrder) throws ParseException{
		String email = requestOrder.getCustomer().getEmail();
		String phone = requestOrder.getCustomer().getPhone();
		if(customerDao.isCustomerExist(email, phone) == null){
			//Insert new time
			Time timeReservation = requestOrder.getTime();
			timeDao.createTime(timeReservation);
			//Insert new Customer
			customerDao.createCustomer(requestOrder.getCustomer());
			
			StatusImpl status = new StatusImpl();
			status.setStatusID(2);
			Time time = new TimeImpl();
			time.setTimeID(timeDao.getLastInsert());
			
			CustomerImpl customer = new CustomerImpl();
			customer.setCustomerID(customerDao.getLastInsert());
			
			Date orderDate = (Date) simple.parse(requestOrder.getOrderDate());
			
			Order order = new OrderImpl();
		    order.setCustomer(customer);
		    order.setOrderDate(orderDate);
		    order.setStatus(status);
		    order.setTimeReservation(time);
		    
		    return (orderDao.createOrder(order) == 0)? new ResponseEntity<String>(ERRORS[1], HttpStatus.CONFLICT) : new ResponseEntity<String>(orderDao.getLastInsert()+"", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(ERRORS[0], HttpStatus.CONFLICT);
	}

}
