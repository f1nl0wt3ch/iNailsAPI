package mobile.api.iNails.domain;

public interface Service {
	public int getServiceID();

	public void setServiceID(int serviceID);

	public String getName();

	public void setName(String name);

	public CategoryImpl getCategory();

	public void setCategory(CategoryImpl category);

	public double getTime();

	public void setTime(double time);

	public double getPrice();

	public void setPrice(double price);

}
