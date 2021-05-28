package rmit.university.sadi.controller;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rmit.university.sadi.AbstractTest;
import rmit.university.sadi.entity.InventoryDeliveryNote;
import rmit.university.sadi.entity.Staff;
import rmit.university.sadi.repository.InventoryDeliveryNoteRepository;

import java.util.List;
import java.util.stream.Collectors;

class InventoryDeliveryControllerTest extends AbstractTest{
    @Autowired
    private InventoryDeliveryNoteRepository repository;

    @Autowired
    private InventoryDeliveryNoteModelAssembler assembler;

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void getInventoryDeliveryNotesList() throws Exception {
        String uri = "/inventories";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<InventoryDeliveryNote>> inventorys = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(inventorys.stream().count() > 1);

    }
    @Test
    public void createInventoryDeliveryNote() throws Exception {
        String uri = "/inventories";
        InventoryDeliveryNote inventoryDeliveryNote = new InventoryDeliveryNote();
        inventoryDeliveryNote.setId(88L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        inventoryDeliveryNote.setStaff(staff);
        inventoryDeliveryNote.setDate("25/05/2020");;
        List<EntityModel<InventoryDeliveryNote>> inventorys = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(inventoryDeliveryNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void updateInventoryDeliveryNote() throws Exception {
        String uri = "/inventories/2";
        //Remember to check for the id to see the id exist or not!
        InventoryDeliveryNote inventoryDeliveryNote = new InventoryDeliveryNote();
        inventoryDeliveryNote.setDate("13/09/2020");
        String inputJson = super.mapToJson(inventoryDeliveryNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void deleteInventoryDeliveryNote() throws Exception {
        String uri = "/inventories/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }


}