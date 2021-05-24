package rmit.university.sadi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import rmit.university.sadi.entity.Staff;

@Component
class StaffModelAssembler implements RepresentationModelAssembler<Staff, EntityModel<Staff>> {

    @Override
    public EntityModel<Staff> toModel(Staff staff) {

        return EntityModel.of(staff, //
                linkTo(methodOn(StaffController.class).one(staff.getId())).withSelfRel(),
                linkTo(methodOn(StaffController.class).all()).withRel("employees"));
    }
}
