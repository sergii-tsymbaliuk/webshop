import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.ProductDAO;
import entities.Product;

/**
 *
 */
public class App 
{
	@Autowired
	ProductDAO productDAO;
	
    public static void main( String[] args )
    {
		AnnotationConfigApplicationContext applicationContext;
		
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		
		App app = applicationContext.getBean(App.class);
		app.run();
    }
    
    public void run(){
    	Product p = new Product();
    	p.setName("TestName");
    	productDAO.save(p);
 
    	
    	List<Product> prods = productDAO.findAll();
    	prods.forEach(e->{System.out.println(e);});
 
    	for(int i=0; i<100; i++){
    		p = new Product();
    		p.setName("Prod"+i);
    		productDAO.save(p);
		}
    	
    	prods = productDAO.findAll();
    	prods.forEach(e->{System.out.println(e);});   	
    }
}
