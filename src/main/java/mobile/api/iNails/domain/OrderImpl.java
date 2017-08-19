package mobile.api.iNails.domain;

import java.sql.Date;

public class OrderImpl implements Order{
   private int orderID;
   private CustomerImpl customer;
   private StatusImpl status;
   private Date orderDate;
   private Time timeReservation;
   
public OrderImpl() {
	super();
	// TODO Auto-generated constructor stub
}



public OrderImpl(int orderID, CustomerImpl customer, StatusImpl status, Date orderDate, Time timeReservation) {
	super();
	this.orderID = orderID;
	this.customer = customer;
	this.status = status;
	this.orderDate = orderDate;
	this.timeReservation = timeReservation;
}



public int getOrderID() {
	return orderID;
}

public void setOrderID(int orderID) {
	this.orderID = orderID;
}

public CustomerImpl getCustomer() {
	return customer;
}

public void setCustomer(CustomerImpl customer) {
	this.customer = customer;
}

public StatusImpl getStatus() {
	return status;
}

public void setStatus(StatusImpl status) {
	this.status = status;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

public Time getTimeReservation() {
	return timeReservation;
}

public void setTimeReservation(Time timeReservation) {
	this.timeReservation = timeReservation;
}


   
} 
