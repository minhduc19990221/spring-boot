package rmit.university.sadi.statistic;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rmit.university.sadi.entity.InventoryDeliveryNote;
import rmit.university.sadi.entity.InventoryReceivingNote;
import rmit.university.sadi.repository.InventoryDeliveryNoteRepository;
import rmit.university.sadi.repository.InventoryReceivingNoteRepository;

@RestController
public class NoteController {
    private final InventoryDeliveryNoteRepository inventoryDeliveryNoteRepository;
    private final InventoryReceivingNoteRepository inventoryReceivingNoteRepository;

    public NoteController(InventoryDeliveryNoteRepository inventoryDeliveryNoteRepository, InventoryReceivingNoteRepository inventoryReceivingNoteRepository) {
        this.inventoryDeliveryNoteRepository = inventoryDeliveryNoteRepository;
        this.inventoryReceivingNoteRepository = inventoryReceivingNoteRepository;
    }

    @GetMapping("/warehouse/{start}/{end}")
    public void getWarehouse(@PathVariable String start, @PathVariable String end){
        InventoryReceivingNote inventoryReceivingNote = inventoryReceivingNoteRepository.findAll().stream()
                .filter(inventoryReceivingNote1 -> start.equals(inventoryReceivingNote1.getDate()))
                .findAny()
                .orElse(null);
        InventoryDeliveryNote inventoryDeliveryNote = inventoryDeliveryNoteRepository.findAll().stream()
                .filter(inventoryDeliveryNote1 -> end.equals(inventoryDeliveryNote1.getDate()))
                .findAny()
                .orElse(null);
        System.out.println("Date: " + start + end);
        System.out.println("Name      |      Received   |   Delivery |    Balance");
        System.out.println(inventoryDeliveryNote.getId() + inventoryReceivingNote.getName());

    }
}
