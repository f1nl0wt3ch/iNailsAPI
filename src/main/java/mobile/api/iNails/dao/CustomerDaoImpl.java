package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mobile.api.iNails.domain.Customer;
import mobile.api.iNails.rowmapper.CustomerRowMapper;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired 
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findAllCustomers() {
		
		return null;
	}

	@Override
	public Customer findCustomer(int customerID) {
		String sql = "SELECT * FROM Customer WHERE CustomerID = :customerID";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		RowMapper<Customer> rm = new CustomerRowMapper();
		paramMap.addValue("customerID", customerID);
		try {
			Customer customer = jdbcTemplate.queryForObject(sql, paramMap, rm);
			return customer;
		} catch (DataAccessException e) {
			System.out.println("No customer found cause "+ e);
			return null;
		}
	}

	@Override
	public int createCustomer(Customer customer) {
		String sql ="INSERT INTO Customer(Name, Birthday, Address, Phone, Email) VALUES (:name,:birthday,:address,:email)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", customer.getName() );
		paramMap.addValue("birthday", customer.getBirthday() );
		paramMap.addValue("address",customer.getAddress() );
		paramMap.addValue("email",customer.getEmail() );
		
		try {
			int row = jdbcTemplate.update(sql, paramMap);
			return row;
		} catch (DataAccessException e) {
			System.out.println("Cannot create new customer cause "+e);
			return 0;
		}
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer isCustomerExist(String email, String phone) {
		String sql="SELECT * FROM Customer WHERE Email = :email OR Phone =:phone";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("email", email);
		paramMap.addValue("phone", phone);
		RowMapper<Customer> rm = new CustomerRowMapper();
		try {
			Customer customer = jdbcTemplate.queryForObject(sql, paramMap, rm);
			return customer;
		} catch (DataAccessException e) {
			System.out.println("Customer not exist cause "+ e);
			return null;
		}
	}

	@Override
	public int getLastInsert() {
		String sql = "SELECT * FROM Customer ORDER BY CustomerID DESC LIMIT 1";
		RowMapper<Customer> rm = new CustomerRowMapper();
		return jdbcTemplate.query(sql, rm).get(0).getCustomerID();
	}

}
