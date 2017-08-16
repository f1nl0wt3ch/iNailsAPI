package mobile.api.iNails.domain;

public class ServiceImpl implements Service {
     private int serviceID;
     private String name;
     private CategoryImpl category;
     private double time;
     private double price;
	public ServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceImpl(int serviceID, String name, CategoryImpl category, double time, double price) {
		super();
		this.serviceID = serviceID;
		this.name = name;
		this.category = category;
		this.time = time;
		this.price = price;
	}
	public int getServiceID() {
		return serviceID;
	}
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryImpl getCategory() {
		return category;
	}
	public void setCategory(CategoryImpl category) {
		this.category = category;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
     
     
}
