package mobile.api.iNails.domain;

public interface Cart {
	public OrderImpl getOrder();
	public void setOrder(OrderImpl order);
	public ServiceImpl getService();
	public void setService(ServiceImpl service);
 
}
