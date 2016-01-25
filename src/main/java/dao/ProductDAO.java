package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {

}
