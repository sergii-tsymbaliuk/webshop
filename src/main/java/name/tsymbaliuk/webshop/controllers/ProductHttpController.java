package name.tsymbaliuk.webshop.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import name.tsymbaliuk.webshop.dao.ProductDAO;

@Controller
@RequestMapping("/")
public class ProductHttpController {
	@Autowired
	ProductDAO productDAO;
	Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(path="/products", method = RequestMethod.GET)
	public ModelAndView printProducts() {
		log.info("printHello");
		
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
        }
        
        ModelAndView model = new ModelAndView("hello");
		model.addObject("msg", "hello world");
		
	    return model;
	}
	
	@RequestMapping(path="/hello*", method = RequestMethod.GET)
	public String printHello() {
		log.info("printHello");
		
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
        }
	
	    return "hello";
	}	
/* 	@RequestMapping(method = RequestMethod.GET)
	public String printHello(@RequestParam Long id, ModelMap model) {
		model.addAttribute(productDAO.findOne(id));
	    return model;
	} */	
}
