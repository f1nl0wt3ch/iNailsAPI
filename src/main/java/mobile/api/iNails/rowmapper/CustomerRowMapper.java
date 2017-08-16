package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.Customer;
import mobile.api.iNails.domain.CustomerImpl;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int row) throws SQLException {
		Customer customer = new CustomerImpl();
		customer.setCustomerID(rs.getInt("CustomerID"));
		customer.setName(rs.getString("Name"));
		customer.setBirthday(rs.getDate("Birthday"));
		customer.setAddress(rs.getString("Address"));
		customer.setEmail(rs.getString("Email"));
		customer.setPhone(rs.getString("Phone"));
		return customer;
	}

}
