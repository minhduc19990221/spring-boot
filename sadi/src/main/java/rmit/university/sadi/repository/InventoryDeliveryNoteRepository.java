package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.InventoryDeliveryNote;

public interface InventoryDeliveryNoteRepository extends JpaRepository<InventoryDeliveryNote, Long> {
}
