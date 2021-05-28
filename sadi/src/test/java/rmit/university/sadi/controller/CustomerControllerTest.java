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
import rmit.university.sadi.entity.Customer;
import rmit.university.sadi.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerControllerTest extends AbstractTest {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerModelAssembler assembler;

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void getCustomersList() throws Exception {
        String uri = "/customers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<Customer>> customers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(customers.stream().count() > 1);

    }
    @Test
    public void createCustomer() throws Exception {
        String uri = "/customers";
        Customer customer = new Customer();
        customer.setId(88L);
        customer.setName("John");
        customer.setPhone("097864536");
        customer.setEmail("s234@rmit.edu.vn");
        customer.setFax("0989786709");
        customer.setAddress("172 Nguyen van lin");
        customer.setContactPerson("mike");
        List<EntityModel<Customer>> customers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(customer);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void updateCustomer() throws Exception {
        String uri = "/customers/2";
        //Remember to check for the id to see the id exist or not!
        Customer customer = new Customer();
        customer.setName("Jennie");
        String inputJson = super.mapToJson(customer);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
    @Test
    public void deleteCustomer() throws Exception {
        String uri = "/customers/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }


}