import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
//@ImportResource("classpath:/database.xml")
@EnableJpaRepositories("dao")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("controllers")
public class AppConfig {

//	@Bean
//	public EntityManager entityManager() {
//		return entityManagerFactory().createEntityManager();
//	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("persistenseUnit_Derby");
	}	

	@Bean
	public PlatformTransactionManager transactionManager() {
	
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	}	
	
	@Bean
	public App app(){
		return new App();
	}
}
