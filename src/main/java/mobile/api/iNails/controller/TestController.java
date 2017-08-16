package mobile.api.iNails.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mobile.api.iNails.dao.CategoryDao;
import mobile.api.iNails.dao.ServiceDao;
import mobile.api.iNails.domain.Category;
import mobile.api.iNails.domain.Service;

@Controller
public class TestController {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ServiceDao serviceDao;
	
	@RequestMapping(value="test",method= RequestMethod.GET)
	public String test(){
		List<Category> list = categoryDao.findAllCategories();
		for(Category cate : list){
		System.out.println("Categories "+ cate.getName());
		}
		return "test";
	}
	
	@RequestMapping(value="service",method= RequestMethod.GET)
	public String service(){
		List<Integer> cateIdList = Arrays.asList(1,2,3);
		List<Service> allService = serviceDao.findServicesByCategory(cateIdList);
		for(int i=0; i< allService.size();i++){
		   System.out.println(i+". "+allService.get(i).getName());
		}
		return "service";
	}

}
