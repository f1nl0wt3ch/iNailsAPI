package mobile.api.iNails.domain;

public interface Invoice {
	public Order getOrder();
	public void setOrder(Order order);
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public Artist getArtist();
	public void setArtist(Artist artist);
	public String getServices();
	public void setServices(String services);
	public double getTotalPayment();
	public void setTotalPayment(double totalPayment);
	public int getDuration();
	public void setDuration(int duration);
	public Status getStatus();
	public void setStatus(Status status);
	public Time getTimeReservation();
	public void setTimeReservation(Time timeReservation);
    
}
