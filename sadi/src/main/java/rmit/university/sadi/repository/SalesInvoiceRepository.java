package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.SalesInvoice;

public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long> {
}
