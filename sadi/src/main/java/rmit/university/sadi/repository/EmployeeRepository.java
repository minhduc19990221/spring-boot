package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
