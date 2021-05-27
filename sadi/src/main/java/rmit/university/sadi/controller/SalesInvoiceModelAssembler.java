package rmit.university.sadi.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import rmit.university.sadi.entity.SalesInvoice;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SalesInvoiceModelAssembler implements RepresentationModelAssembler<SalesInvoice, EntityModel<SalesInvoice>> {
    @Override
    public EntityModel<SalesInvoice> toModel(SalesInvoice salesInvoice) {

        return EntityModel.of(salesInvoice,
                linkTo(methodOn(SalesInvoiceController.class).one(salesInvoice.getId())).withSelfRel(),
                linkTo(methodOn(SalesInvoiceController.class).identifier(salesInvoice.getDate())).withSelfRel(),
                linkTo(methodOn(SalesInvoiceController.class).all()).withRel("saleInvoices"));
    }
}
