package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByQuantity(int quantity);
}
