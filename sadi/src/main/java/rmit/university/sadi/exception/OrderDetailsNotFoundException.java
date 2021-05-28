package rmit.university.sadi.exception;

public class OrderDetailsNotFoundException extends RuntimeException {
    public OrderDetailsNotFoundException(Long id){super("details not found: " + id);}
}
