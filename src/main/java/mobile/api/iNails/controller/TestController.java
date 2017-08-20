package mobile.api.iNails.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mobile.api.iNails.dao.CategoryDao;
import mobile.api.iNails.dao.OrderDao;
import mobile.api.iNails.dao.ServiceDao;
import mobile.api.iNails.dao.TimeDao;
import mobile.api.iNails.domain.Artist;
import mobile.api.iNails.domain.ArtistImpl;
import mobile.api.iNails.domain.Category;
import mobile.api.iNails.domain.Invoice;
import mobile.api.iNails.domain.InvoiceImpl;
import mobile.api.iNails.domain.Service;
import mobile.api.iNails.domain.Time;
import mobile.api.iNails.domain.TimeImpl;

@Controller
public class TestController {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ServiceDao serviceDao;
	@Autowired
	private TimeDao timeDao;
	@Autowired
	private OrderDao orderDao;
	
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
	
	@RequestMapping(value="time", method = RequestMethod.GET)
	public String time(){
		Time time = new TimeImpl();
		Artist artist = new ArtistImpl();
		Date date = new Date(0);
		
		artist.setArtistID(2);
		time.setTimeID(12);
		time.setTime("16:00");
		time.setArtist(artist);
		time.setDate(date);
		timeDao.createTime(time);
		System.out.println("Time id "+ timeDao.getLastInsert());
		return "time";
	}
	
	@RequestMapping(value="invoice", method = RequestMethod.GET)
	public String testInvoice(){
		Invoice invoice = new InvoiceImpl();
		invoice = orderDao.findInvoiceByOrderNumber(1);
		System.out.println(invoice.toString());
		return "test invoice";
	}

}
