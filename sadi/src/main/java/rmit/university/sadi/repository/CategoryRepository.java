package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
