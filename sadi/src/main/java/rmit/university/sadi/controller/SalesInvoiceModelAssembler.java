package rmit.university.sadi.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import rmit.university.sadi.entity.Product;
import rmit.university.sadi.entity.SalesInvoice;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class SalesInvoiceModelAssembler implements RepresentationModelAssembler<SalesInvoice, EntityModel<SalesInvoice>> {
    @Override
    public EntityModel<SalesInvoice> toModel(SalesInvoice salesInvoice) {

        return EntityModel.of(salesInvoice,
                linkTo(methodOn(ProductController.class).one(salesInvoice.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("saleInvoices"));
    }
}
