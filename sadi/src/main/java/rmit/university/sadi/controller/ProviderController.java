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
import rmit.university.sadi.entity.Provider;
import rmit.university.sadi.exception.ProviderNotFoundException;
import rmit.university.sadi.repository.ProviderRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProviderController {
    private final ProviderRepository repository;
    private final ProviderModelAssembler assembler;
    ProviderController(ProviderRepository repository, ProviderModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/providers")
    CollectionModel<EntityModel<Provider>> all() {

        List<EntityModel<Provider>> providers = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(providers, linkTo(methodOn(ProviderController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/providers")
    ResponseEntity<?> newProvider(@RequestBody Provider newProvider) {

        EntityModel<Provider> entityModel = assembler.toModel(repository.save(newProvider));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/providers/{id}")
    EntityModel<Provider> one(@PathVariable Long id) {

        Provider provider = repository.findById(id) //
                .orElseThrow(() -> new ProviderNotFoundException(id));

        return assembler.toModel(provider);
    }

    @PutMapping("/providers/{id}")
    ResponseEntity<?> replaceProvider(@RequestBody Provider newProvider, @PathVariable Long id) {

        Provider updatedProvider = repository.findById(id) //
                .map(provider -> {
                    provider.setName(newProvider.getName());
                    provider.setAddress(newProvider.getAddress());
                    provider.setContactPerson(newProvider.getContactPerson());
                    provider.setEmail(newProvider.getEmail());
                    provider.setFax(newProvider.getFax());
                    provider.setPhone(newProvider.getPhone());
                    return repository.save(provider);
                }) //
                .orElseGet(() -> {
                    newProvider.setId(id);
                    return repository.save(newProvider);
                });

        EntityModel<Provider> entityModel = assembler.toModel(updatedProvider);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/providers/{id}")
    ResponseEntity<?> deleteProvider(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
