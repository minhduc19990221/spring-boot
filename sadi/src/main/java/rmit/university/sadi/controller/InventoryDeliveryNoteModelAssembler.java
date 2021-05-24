package rmit.university.sadi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import rmit.university.sadi.entity.InventoryDeliveryNote;


@Component
public class InventoryDeliveryNoteModelAssembler implements RepresentationModelAssembler<InventoryDeliveryNote, EntityModel<InventoryDeliveryNote>> {
    @Override
    public EntityModel<InventoryDeliveryNote> toModel(InventoryDeliveryNote inventoryDeliveryNote) {

        return EntityModel.of(inventoryDeliveryNote, //
                linkTo(methodOn(EmployeeController.class).one(inventoryDeliveryNote.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("inventories"));
    }
}
