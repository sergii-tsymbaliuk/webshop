package name.tsymbaliuk.webshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import name.tsymbaliuk.webshop.entities.Product;

@Component
public interface ProductDAO extends JpaRepository<Product, Long> {

}
