package rmit.university.sadi.exception;

public class StaffNotFoundException extends RuntimeException{
    public StaffNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
