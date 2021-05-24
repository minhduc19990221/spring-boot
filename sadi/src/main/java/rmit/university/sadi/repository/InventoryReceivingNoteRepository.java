package rmit.university.sadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmit.university.sadi.entity.InventoryReceivingNote;

public interface InventoryReceivingNoteRepository extends JpaRepository<InventoryReceivingNote, Long> {
}
