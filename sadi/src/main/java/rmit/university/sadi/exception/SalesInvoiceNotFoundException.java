package rmit.university.sadi.exception;

public class SalesInvoiceNotFoundException extends RuntimeException {
    public SalesInvoiceNotFoundException(Long id){super("Invoices not found: " + id);}
}
