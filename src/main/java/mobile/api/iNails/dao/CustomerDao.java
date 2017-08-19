package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Customer;

@Service
public interface CustomerDao {
    public List<Customer> findAllCustomers();
    public Customer findCustomer(int customerID);
    public Customer isCustomerExist(String email, String phone);
    public int createCustomer(Customer customer);
    public int updateCustomer(Customer customer);
    public int deleteCustomer(int customerID);
    public int getLastInsert();
}
