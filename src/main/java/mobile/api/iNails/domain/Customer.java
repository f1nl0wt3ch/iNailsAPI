package mobile.api.iNails.domain;

import java.sql.Date;

public interface Customer {
	public int getCustomerID();

	public void setCustomerID(int customerID);

	public String getName();

	public void setName(String name);

	public Date getBirthday();

	public void setBirthday(Date birthday);

	public String getAddress();

	public void setAddress(String address);

	public String getEmail();

	public void setEmail(String email);

	public String getPhone();

	public void setPhone(String phone);

}
