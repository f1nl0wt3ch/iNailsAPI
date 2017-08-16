package mobile.api.iNails.domain;

import java.sql.Date;

public class CustomerImpl implements Customer {
	private int customerID;
	private String name;
	private Date birthday;
    private String address;
    private String email;
    private String phone;
	public CustomerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerImpl(int customerID, String name, Date birthday, String address, String email, String phone) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
}
