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

import rmit.university.sadi.entity.Category;
import rmit.university.sadi.entity.Staff;
import rmit.university.sadi.repository.StaffRepository;

import java.util.List;
import java.util.stream.Collectors;

class StaffControllerTest extends AbstractTest  {
    @Autowired
    private StaffRepository repository;

    @Autowired
    private StaffModelAssembler assembler;

//    @Override
    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void getStaffsList() throws Exception {
        String uri = "/staffs";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<Staff>> staffs = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(staffs.stream().count() > 1);

    }
    @Test
    public void createStaff() throws Exception {
        String uri = "/staffs";
        Staff staff = new Staff();
        staff.setId(88L);
        staff.setName("Mike");
        staff.setRole("manager");
        staff.setPhone("09787676");
        staff.setEmail("s123@rmit.edu.vn");
        staff.setAddress("172 nguyen van linh");
        List<EntityModel<Staff>> staffs = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(staff);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void updateStaff() throws Exception {
        String uri = "/staffs/2";
        //Remember to check for the id to see the id exist or not!
        Staff staff = new Staff();
        staff.setName("Nano");
        String inputJson = super.mapToJson(staff);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void deleteStaff() throws Exception {
        String uri = "/staffs/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }

}