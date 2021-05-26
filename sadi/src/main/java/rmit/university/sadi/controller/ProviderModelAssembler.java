package rmit.university.sadi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import rmit.university.sadi.entity.Provider;

@Component
public class ProviderModelAssembler implements RepresentationModelAssembler<Provider,EntityModel<Provider>> {
    @Override
    public EntityModel<Provider> toModel(Provider provider) {

        return EntityModel.of(provider, //
                linkTo(methodOn(ProviderController.class).one(provider.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).identifier(provider.getName())).withSelfRel(),
                linkTo(methodOn(ProviderController.class).all()).withRel("providers"));
    }
}
