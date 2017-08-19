package mobile.api.iNails.domain;

import java.util.List;

public interface RequestOrder {
	public List<Integer> getServices();
	public void setServices(List<Integer> services);
	public Time getTime();
	public void setTime(Time time);
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public String getOrderDate();
	public void setOrderDate(String orderDate);
}
