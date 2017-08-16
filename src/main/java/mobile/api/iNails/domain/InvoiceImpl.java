package mobile.api.iNails.domain;

public class InvoiceImpl implements Invoice{
    private Order order;
    private Customer customer;
    private Artist artist;
    private String services;
    private double totalPayment;
    private int duration;
    private Status status;
	public InvoiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceImpl(Order order, Customer customer, Artist artist, String services, double totalPayment,
			int duration) {
		super();
		this.order = order;
		this.customer = customer;
		this.artist = artist;
		this.services = services;
		this.totalPayment = totalPayment;
		this.duration = duration;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}
