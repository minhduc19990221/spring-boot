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
import rmit.university.sadi.entity.Customer;
import rmit.university.sadi.entity.InventoryDeliveryNote;
import rmit.university.sadi.exception.InventoryDeliveryNoteNotFoundException;
import rmit.university.sadi.repository.InventoryDeliveryNoteRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class InventoryDeliveryController {

    private final InventoryDeliveryNoteRepository repository;
    private final InventoryDeliveryNoteModelAssembler assembler;
    InventoryDeliveryController(InventoryDeliveryNoteRepository repository, InventoryDeliveryNoteModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/inventories")
    CollectionModel<EntityModel<InventoryDeliveryNote>> all() {

        List<EntityModel<InventoryDeliveryNote>> inventorys = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(inventorys, linkTo(methodOn(InventoryDeliveryController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/inventories")
    ResponseEntity<?> newInventoryDeliveryNote(@RequestBody InventoryDeliveryNote newInventoryDeliveryNote) {

        EntityModel<InventoryDeliveryNote> entityModel = assembler.toModel(repository.save(newInventoryDeliveryNote));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/inventories/{id}")
    EntityModel<InventoryDeliveryNote> one(@PathVariable Long id) {

        InventoryDeliveryNote inventory = repository.findById(id) //
                .orElseThrow(() -> new InventoryDeliveryNoteNotFoundException(id));

        return assembler.toModel(inventory);
    }
    @GetMapping("/inventories/date/{date}")
    EntityModel<InventoryDeliveryNote> identifier(@PathVariable String date) {

        InventoryDeliveryNote inventoryDeliveryNote = repository.findAll().stream()
                .filter(note -> date.equals(note.getDate()))
                .findAny()
                .orElse(null);

        assert inventoryDeliveryNote != null;
        return assembler.toModel(inventoryDeliveryNote);
    }

    @PutMapping("/inventories/{id}")
    ResponseEntity<?> replaceInventoryDeliveryNote(@RequestBody InventoryDeliveryNote newInventoryDeliveryNote, @PathVariable Long id) {

        InventoryDeliveryNote updatedInventoryDeliveryNote = repository.findById(id) //
                .map(inventory -> {
                    inventory.setDate(newInventoryDeliveryNote.getDate());
                    inventory.setInventoryDeliveryNoteDetails(newInventoryDeliveryNote.getInventoryDeliveryNoteDetails());
                    inventory.setStaff(newInventoryDeliveryNote.getStaff());
                    return repository.save(inventory);
                }) //
                .orElseGet(() -> {
                    newInventoryDeliveryNote.setId(id);
                    return repository.save(newInventoryDeliveryNote);
                });

        EntityModel<InventoryDeliveryNote> entityModel = assembler.toModel(updatedInventoryDeliveryNote);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/inventories/{id}")
    ResponseEntity<?> deleteInventoryDeliveryNote(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
