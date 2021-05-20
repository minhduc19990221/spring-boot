package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
