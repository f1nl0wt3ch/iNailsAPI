package mobile.api.iNails.domain;

import java.util.List;

public class RequestOrderImpl implements RequestOrder {
     private List<Integer> services;
     private Time time;
     private Customer customer;
     private String orderDate;
	public RequestOrderImpl(List<Integer> services, Time time, Customer customer, String orderDate) {
		super();
		this.services = services;
		this.time = time;
		this.customer = customer;
		this.orderDate = orderDate;
	}
	public RequestOrderImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Integer> getServices() {
		return services;
	}
	public void setServices(List<Integer> services) {
		this.services = services;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
     
	
}
