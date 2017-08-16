package mobile.api.iNails.domain;

import java.sql.Date;

public class OrderImpl implements Order{
   private int orderID;
   private CustomerImpl customer;
   private ArtistImpl artist;
   private StatusImpl status;
   private Date orderDate;
public OrderImpl() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderImpl(int orderID, CustomerImpl customer, ArtistImpl artist, StatusImpl status,
		Date orderDate) {
	super();
	this.orderID = orderID;
	this.customer = customer;
	this.artist = artist;
	this.status = status;
	this.orderDate = orderDate;
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
public ArtistImpl getArtist() {
	return artist;
}
public void setArtist(ArtistImpl artist) {
	this.artist = artist;
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

   
   
} 
