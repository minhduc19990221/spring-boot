package rmit.university.sadi.controller;

import java.util.List;
import java.util.Optional;
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
import rmit.university.sadi.entity.OrderDetails;
import rmit.university.sadi.exception.OrderDetailsNotFoundException;
import rmit.university.sadi.repository.OrderDetailsRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class OrderDetailsController {

    private final OrderDetailsRepository repository;
    private final OrderDetailsModelAssembler assembler;
    OrderDetailsController(OrderDetailsRepository repository, OrderDetailsModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/orderDetails")
    CollectionModel<EntityModel<OrderDetails>> all() {

        List<EntityModel<OrderDetails>> orderDetails = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(orderDetails, linkTo(methodOn(OrderDetailsController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/orderDetails")
    ResponseEntity<?> newOrderDetails(@RequestBody OrderDetails newOrderDetails) {

        EntityModel<OrderDetails> entityModel = assembler.toModel(repository.save(newOrderDetails));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/orderDetails/{id}")
    EntityModel<OrderDetails> one(@PathVariable Long id) {

        OrderDetails orderDetails = repository.findById(id) //
                .orElseThrow(() -> new OrderDetailsNotFoundException(id));

        return assembler.toModel(orderDetails);
    }

    @GetMapping("/orderDetails/quantity/{quantity}")
    Optional<OrderDetails> identifier(@PathVariable int quantity) {

        Optional<OrderDetails> orderDetails = repository.findAll().stream()
                .filter(orderDetails1 -> orderDetails1.getQuantity() == quantity)
                .findAny();


        assert orderDetails != null;
        return orderDetails;
    }

    @PutMapping("/orderDetails/{id}")
    ResponseEntity<?> replaceOrderDetails(@RequestBody OrderDetails newOrderDetails, @PathVariable Long id) {

        OrderDetails updatedOrderDetails = repository.findById(id) //
                .map(orderDetails -> {
                    orderDetails.setId(newOrderDetails.getId());
                    orderDetails.setPrice(newOrderDetails.getPrice());
                    orderDetails.setProduct(newOrderDetails.getProduct());
                    orderDetails.setQuantity(newOrderDetails.getQuantity());
                    return repository.save(orderDetails);
                }) //
                .orElseGet(() -> {
                    newOrderDetails.setId(id);
                    return repository.save(newOrderDetails);
                });

        EntityModel<OrderDetails> entityModel = assembler.toModel(updatedOrderDetails);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/orderDetails/{id}")
    ResponseEntity<?> deleteOrderDetails(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
