package rmit.university.sadi.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
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
import rmit.university.sadi.entity.Category;
import rmit.university.sadi.entity.InventoryReceivingNote;
import rmit.university.sadi.repository.InventoryReceivingNoteRepository;

import java.util.List;
import java.util.stream.Collectors;

class InventoryReceivingControllerTest extends AbstractTest  {
    @Autowired
    private InventoryReceivingNoteRepository repository;

    @Autowired
    private InventoryReceivingNoteModelAssembler assembler;

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void getInventoryReceivingNoteList() throws Exception {
        String uri = "/receivers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<InventoryReceivingNote>> receivers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(receivers.stream().count() > 1);

    }
    @Test
    public void createInventoryReceivingNote() throws Exception {
        String uri = "/receivers";
        InventoryReceivingNote inventoryReceivingNote = new InventoryReceivingNote();
        inventoryReceivingNote.setId(88L);
        inventoryReceivingNote.setName("MIke");
        inventoryReceivingNote.setDate("20/01/2020");
        List<EntityModel<InventoryReceivingNote>> receivers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(inventoryReceivingNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void updateInventoryReceivingNote() throws Exception {
        String uri = "/receivers/2";
        //Remember to check for the id to see the id exist or not!
        InventoryReceivingNote inventoryReceivingNote = new InventoryReceivingNote();
        inventoryReceivingNote.setName("Trang");
        String inputJson = super.mapToJson(inventoryReceivingNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void deleteCategory() throws Exception {
        String uri = "/receivers/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }

}