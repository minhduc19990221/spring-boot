package rmit.university.sadi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
