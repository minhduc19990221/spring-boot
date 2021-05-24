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
import rmit.university.sadi.entity.Staff;
import rmit.university.sadi.exception.StaffNotFoundException;
import rmit.university.sadi.repository.StaffRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class StaffController {
    private final StaffRepository repository;
    private final StaffModelAssembler assembler;
    StaffController(StaffRepository repository, StaffModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/staffs")
    CollectionModel<EntityModel<Staff>> all() {

        List<EntityModel<Staff>> staffs = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(staffs, linkTo(methodOn(StaffController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/staffs")
    ResponseEntity<?> newStaff(@RequestBody Staff newStaff) {

        EntityModel<Staff> entityModel = assembler.toModel(repository.save(newStaff));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/staffs/{id}")
    EntityModel<Staff> one(@PathVariable Long id) {

        Staff staff = repository.findById(id) //
                .orElseThrow(() -> new StaffNotFoundException(id));

        return assembler.toModel(staff);
    }

    @PutMapping("/staffs/{id}")
    ResponseEntity<?> replaceStaff(@RequestBody Staff newStaff, @PathVariable Long id) {

        Staff updatedStaff = repository.findById(id) //
                .map(staff -> {
                    staff.setName(newStaff.getName());
                    staff.setRole(newStaff.getRole());
                    return repository.save(staff);
                }) //
                .orElseGet(() -> {
                    newStaff.setId(id);
                    return repository.save(newStaff);
                });

        EntityModel<Staff> entityModel = assembler.toModel(updatedStaff);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/staffs/{id}")
    ResponseEntity<?> deleteStaff(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
