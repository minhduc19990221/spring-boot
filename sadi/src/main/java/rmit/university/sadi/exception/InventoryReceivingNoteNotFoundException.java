package rmit.university.sadi.exception;

public class InventoryReceivingNoteNotFoundException extends RuntimeException {
    public InventoryReceivingNoteNotFoundException(Long id){super("receiving note not found: "+ id);}
}
