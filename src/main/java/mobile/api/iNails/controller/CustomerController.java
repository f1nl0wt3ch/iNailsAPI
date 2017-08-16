package mobile.api.iNails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobile.api.iNails.dao.CustomerDao;
import mobile.api.iNails.domain.CustomerImpl;

@RestController
@RequestMapping("rest/api/")
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;
    
    @RequestMapping(value="customer", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> createCustomer(@RequestBody CustomerImpl customer){
    	if(customerDao.isCustomerExist(customer.getEmail(), customer.getPhone()) == null | customerDao.createCustomer(customer) != 0)
            return new ResponseEntity<>(HttpStatus.CREATED);
    	    return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }
}
