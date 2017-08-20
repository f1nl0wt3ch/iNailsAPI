package mobile.api.iNails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mobile.api.iNails.dao.ServiceDao;
import mobile.api.iNails.domain.Service;

@RestController
@RequestMapping("/rest/api/")
public class ServiceController {
	
	@Autowired
	private ServiceDao serviceDao;
	
	@CrossOrigin
	@RequestMapping(value="categories/{categoryID}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Service>> listAllServices(@PathVariable("categoryID") Integer categoryID){
    	List<Service> services = serviceDao.findServicesByCategory(categoryID);
    	return (services.size() == 0)? new ResponseEntity<List<Service>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Service>>(services, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(value="categories/services", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Service>> listAllServicesByChoosenCategory(@RequestParam("categoryid") List<Integer> categoryIDs){
    	List<Service> serviceList = serviceDao.findServicesByCategory(categoryIDs);
    	return (serviceList.size() == 0)? new ResponseEntity<List<Service>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Service>>(serviceList, HttpStatus.OK);
    }


}
