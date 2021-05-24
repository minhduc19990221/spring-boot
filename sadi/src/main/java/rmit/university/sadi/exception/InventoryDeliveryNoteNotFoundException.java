package rmit.university.sadi.exception;

import rmit.university.sadi.entity.InventoryDeliveryNote;

public class InventoryDeliveryNoteNotFoundException extends RuntimeException {
    public InventoryDeliveryNoteNotFoundException(Long id){super("Could not find delivery note: " + id);}
}
