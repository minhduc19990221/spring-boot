package rmit.university.sadi.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rmit.university.sadi.entity.SalesInvoice;
import rmit.university.sadi.exception.SalesInvoiceNotFoundException;
import rmit.university.sadi.repository.SalesInvoiceRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SalesInvoiceController {
    private final SalesInvoiceRepository repository;
    private final SalesInvoiceModelAssembler assembler;

    public SalesInvoiceController(SalesInvoiceRepository repository, SalesInvoiceModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/saleInvoices")
    CollectionModel<EntityModel<SalesInvoice>> all() {
        List<EntityModel<SalesInvoice>> saleInvoices = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(saleInvoices, linkTo(methodOn(SalesInvoiceController.class).all()).withSelfRel());
    }

    @PostMapping("/saleInvoices")
    ResponseEntity<?> newSalesInvoice(@RequestBody SalesInvoice newSalesInvoice) {

        EntityModel<SalesInvoice> entityModel = assembler.toModel(repository.save(newSalesInvoice));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/saleInvoices/{id}")
    EntityModel<SalesInvoice> one(@PathVariable Long id) {

        SalesInvoice saleInvoice = repository.findById(id) //
                .orElseThrow(() -> new SalesInvoiceNotFoundException(id));

        return assembler.toModel(saleInvoice);
    }

    @GetMapping("/saleInvoices/date/{date}")
    EntityModel<SalesInvoice> identifier(@PathVariable String date) {

        SalesInvoice saleInvoice = repository.findAll().stream()
                .filter(salesInvoice -> date.equals(salesInvoice.getDate()))
                .findAny()
                .orElse(null);

        assert saleInvoice != null;
        return assembler.toModel(saleInvoice);
    }

    @PutMapping("/saleInvoices/{id}")
    ResponseEntity<?> replaceSalesInvoice(@RequestBody SalesInvoice newSalesInvoice, @PathVariable Long id) {

        SalesInvoice updatedSalesInvoice = repository.findById(id) //
                .map(saleInvoice -> {
                    saleInvoice.setCustomer(saleInvoice.getCustomer());
                    saleInvoice.setDate(saleInvoice.getDate());
                    saleInvoice.setPrice(saleInvoice.getPrice());
                    saleInvoice.setProduct(saleInvoice.getProduct());
                    saleInvoice.setQuantity(saleInvoice.getQuantity());
                    saleInvoice.setStaff(saleInvoice.getStaff());
                    saleInvoice.setTotalValue(saleInvoice.getTotalValue());
                    return repository.save(saleInvoice);
                }) //
                .orElseGet(() -> {
                    newSalesInvoice.setId(id);
                    return repository.save(newSalesInvoice);
                });

        EntityModel<SalesInvoice> entityModel = assembler.toModel(updatedSalesInvoice);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/saleInvoices/{id}")
    ResponseEntity<?> deleteSalesInvoice(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
