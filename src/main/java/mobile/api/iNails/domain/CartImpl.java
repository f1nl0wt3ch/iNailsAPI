package mobile.api.iNails.domain;

public class CartImpl implements Cart{
    private OrderImpl order;
    private ServiceImpl service;
    
	public CartImpl(OrderImpl order, ServiceImpl service) {
		super();
		this.order = order;
		this.service = service;
	}
	public CartImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderImpl getOrder() {
		return order;
	}
	public void setOrder(OrderImpl order) {
		this.order = order;
	}
	public ServiceImpl getService() {
		return service;
	}
	public void setService(ServiceImpl service) {
		this.service = service;
	}
 
    
}
