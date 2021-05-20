package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
