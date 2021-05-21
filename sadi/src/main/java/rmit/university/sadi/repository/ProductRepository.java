package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
