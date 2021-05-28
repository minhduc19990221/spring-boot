package rmit.university.sadi.statistic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rmit.university.sadi.entity.SalesInvoice;
import rmit.university.sadi.repository.SalesInvoiceRepository;


@RestController
public class RevenueController {
    public RevenueController( SalesInvoiceRepository salesInvoiceRepository) {

        this.salesInvoiceRepository = salesInvoiceRepository;
    }

    private final SalesInvoiceRepository salesInvoiceRepository;

    @GetMapping("/revenueStaff/{start}/{end}/{staff}")
    public double CalculateRevenue(@PathVariable String start, @PathVariable String end, @PathVariable String staff){
        SalesInvoice salesInvoiceStart = salesInvoiceRepository.findAll().stream()
                .filter(salesInvoice1 -> start.equals(salesInvoice1.getDate()))
                .filter(salesInvoice -> staff.equals(salesInvoice.getStaff().getFirstName()))
                .findAny()
                .orElse(null);
        SalesInvoice salesInvoiceEnd = salesInvoiceRepository.findAll().stream()
                .filter(salesInvoice1 -> end.equals(salesInvoice1.getDate()))
                .filter(salesInvoice -> staff.equals(salesInvoice.getStaff().getFirstName()))
                .findAny()
                .orElse(null);

        return salesInvoiceStart.getPrice()*salesInvoiceStart.getQuantity() + salesInvoiceEnd.getPrice()*salesInvoiceEnd.getQuantity();
    }

    @GetMapping("/revenueCustomer/{start}/{end}/{customer}")
    public double CalculateRevenueByCustomer(@PathVariable String start, @PathVariable String end, @PathVariable String customer){
        SalesInvoice salesInvoiceStart = salesInvoiceRepository.findAll().stream()
                .filter(salesInvoice1 -> start.equals(salesInvoice1.getDate()))
                .filter(salesInvoice -> customer.equals(salesInvoice.getStaff().getFirstName()))
                .findAny()
                .orElse(null);
        SalesInvoice salesInvoiceEnd = salesInvoiceRepository.findAll().stream()
                .filter(salesInvoice1 -> end.equals(salesInvoice1.getDate()))
                .filter(salesInvoice -> customer.equals(salesInvoice.getStaff().getFirstName()))
                .findAny()
                .orElse(null);

        return salesInvoiceStart.getPrice()*salesInvoiceStart.getQuantity() + salesInvoiceEnd.getPrice()*salesInvoiceEnd.getQuantity();
    }
}
