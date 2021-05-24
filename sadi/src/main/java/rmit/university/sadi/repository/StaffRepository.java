package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
