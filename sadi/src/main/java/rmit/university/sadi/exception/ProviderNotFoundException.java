package rmit.university.sadi.exception;

public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(Long id){super("Not found the provider " + id);}
}
