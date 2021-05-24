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
import rmit.university.sadi.entity.Category;
import rmit.university.sadi.exception.CategoryNotFoundException;
import rmit.university.sadi.repository.CategoryRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CategoryController {
    private final CategoryRepository repository;
    private final CategoryModelAssembler assembler;

    public CategoryController(CategoryRepository repository, CategoryModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/categories")
    CollectionModel<EntityModel<Category>> all() {
        List<EntityModel<Category>> categories = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(categories, linkTo(methodOn(CategoryController.class).all()).withSelfRel());
    }

    @PostMapping("/categories")
    ResponseEntity<?> newCategory(@RequestBody Category newCategory) {

        EntityModel<Category> entityModel = assembler.toModel(repository.save(newCategory));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }// Single item

    @GetMapping("/categories/{id}")
    EntityModel<Category> one(@PathVariable Long id) {

        Category category = repository.findById(id) //
                .orElseThrow(() -> new CategoryNotFoundException(id));

        return assembler.toModel(category);
    }
    //Search API for category
    @GetMapping("/categories/name/{name}")
    EntityModel<Category> identifier(@PathVariable String name) {

        Category categories = repository.findAll().stream()
                .filter(category -> name.equals(category.getName()))
                .findAny()
                .orElse(null);

        assert categories != null;
        return assembler.toModel(categories);
    }

    @PutMapping("/categories/{id}")
    ResponseEntity<?> replaceCategory(@RequestBody Category newCategory, @PathVariable Long id) {

        Category updatedCategory = repository.findById(id) //
                .map(category -> {
                    category.setName(newCategory.getName());
                    return repository.save(category);
                }) //
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return repository.save(newCategory);
                });

        EntityModel<Category> entityModel = assembler.toModel(updatedCategory);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/categories/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
