package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ProductDAO;

@Controller
@RequestMapping("/")
public class ProductHttpController  {
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello() {
	    return "hello";
	}
	
/* 	@RequestMapping(method = RequestMethod.GET)
	public String printHello(@RequestParam Long id, ModelMap model) {
		model.addAttribute(productDAO.findOne(id));
	    return model;
	} */	
}
