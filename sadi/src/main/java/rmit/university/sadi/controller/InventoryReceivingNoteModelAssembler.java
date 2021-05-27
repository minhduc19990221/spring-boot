package rmit.university.sadi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import rmit.university.sadi.entity.InventoryReceivingNote;


@Component
public class InventoryReceivingNoteModelAssembler implements RepresentationModelAssembler<InventoryReceivingNote, EntityModel<InventoryReceivingNote>> {
    @Override
    public EntityModel<InventoryReceivingNote> toModel(InventoryReceivingNote inventoryReceivingNote) {

        return EntityModel.of(inventoryReceivingNote, //
                linkTo(methodOn(InventoryReceivingController.class).one(inventoryReceivingNote.getId())).withSelfRel(),
                linkTo(methodOn(InventoryReceivingController.class).identifier(inventoryReceivingNote.getDate())).withSelfRel(),
                linkTo(methodOn(InventoryReceivingController.class).all()).withRel("receivers"));
    }
}
