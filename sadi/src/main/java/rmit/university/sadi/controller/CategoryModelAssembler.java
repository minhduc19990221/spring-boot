package rmit.university.sadi.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import rmit.university.sadi.entity.Category;

@Component
public class CategoryModelAssembler implements RepresentationModelAssembler<Category, EntityModel<Category>>{
    @Override
    public EntityModel<Category> toModel(Category category) {

        return EntityModel.of(category, //
                linkTo(methodOn(CategoryController.class).one(category.getId())).withSelfRel(),
                linkTo(methodOn(CategoryController.class).all()).withRel("categories"));
    }
}
