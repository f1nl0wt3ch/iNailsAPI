package mobile.api.iNails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobile.api.iNails.dao.CategoryDao;
import mobile.api.iNails.domain.Category;

@RestController
@RequestMapping("/rest/api/")
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value="categories", method= RequestMethod.GET)
	public ResponseEntity<List<Category>> findAllCategory(){
		List<Category> categories = categoryDao.findAllCategories();
		return (categories.isEmpty())? new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

}
