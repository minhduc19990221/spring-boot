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
import rmit.university.sadi.entity.InventoryReceivingNote;
import rmit.university.sadi.exception.InventoryReceivingNoteNotFoundException;
import rmit.university.sadi.repository.InventoryReceivingNoteRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class InventoryReceivingController {
    private final InventoryReceivingNoteRepository repository;
    private final InventoryReceivingNoteModelAssembler assembler;
    InventoryReceivingController(InventoryReceivingNoteRepository repository, InventoryReceivingNoteModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/receivers")
    CollectionModel<EntityModel<InventoryReceivingNote>> all() {

        List<EntityModel<InventoryReceivingNote>> receivers = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(receivers, linkTo(methodOn(InventoryReceivingController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/receivers")
    ResponseEntity<?> newInventoryReceivingNote(@RequestBody InventoryReceivingNote newInventoryReceivingNote) {

        EntityModel<InventoryReceivingNote> entityModel = assembler.toModel(repository.save(newInventoryReceivingNote));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/receivers/{id}")
    EntityModel<InventoryReceivingNote> one(@PathVariable Long id) {

        InventoryReceivingNote receiver = repository.findById(id) //
                .orElseThrow(() -> new InventoryReceivingNoteNotFoundException(id));

        return assembler.toModel(receiver);
    }

    @PutMapping("/receivers/{id}")
    ResponseEntity<?> replaceInventoryReceivingNote(@RequestBody InventoryReceivingNote newInventoryReceivingNote, @PathVariable Long id) {

        InventoryReceivingNote updatedInventoryReceivingNote = repository.findById(id) //
                .map(receiver -> {
                    receiver.setDate(newInventoryReceivingNote.getDate());
                    receiver.setInventoryReceivingNoteDetails(newInventoryReceivingNote.getInventoryReceivingNoteDetails());
                    receiver.setName(newInventoryReceivingNote.getName());
                    return repository.save(receiver);
                }) //
                .orElseGet(() -> {
                    newInventoryReceivingNote.setId(id);
                    return repository.save(newInventoryReceivingNote);
                });

        EntityModel<InventoryReceivingNote> entityModel = assembler.toModel(updatedInventoryReceivingNote);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/receivers/{id}")
    ResponseEntity<?> deleteInventoryReceivingNote(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
