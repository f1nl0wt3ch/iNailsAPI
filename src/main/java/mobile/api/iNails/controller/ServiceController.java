package mobile.api.iNails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobile.api.iNails.dao.ServiceDao;
import mobile.api.iNails.domain.Service;

@RestController
@RequestMapping("/rest/api/")
public class ServiceController {
	
	@Autowired
	private ServiceDao serviceDao;
	
	@RequestMapping(value="categories/{categoryID}", method= RequestMethod.GET)
    public ResponseEntity<List<Service>> listAllServices(@PathVariable("categoryID") Integer categoryID){
    	List<Service> services = serviceDao.findServicesByCategory(categoryID);
    	return (services.size() == 0)? new ResponseEntity<List<Service>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Service>>(services, HttpStatus.OK);
    }

}
