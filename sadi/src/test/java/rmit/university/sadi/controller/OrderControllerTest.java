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
import rmit.university.sadi.entity.Order;
import rmit.university.sadi.repository.CategoryRepository;
import rmit.university.sadi.repository.OrderRepository;
import rmit.university.sadi.repository.Status;

import java.util.List;
import java.util.stream.Collectors;

class OrderControllerTest extends AbstractTest {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderModelAssembler assembler;

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void getCategoriesList() throws Exception {
        String uri = "/orders";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<Order>> orders = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(orders.stream().count() > 1);

    }
    @Test
    public void createOrder() throws Exception {
        String uri = "/orders";
        Order order = new Order();
        order.setId(88L);
        order.setStatus(Status.COMPLETED);
        order.setDescription("MacBook");
        List<EntityModel<Order>> orders = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(order);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void updateOrder() throws Exception {
        String uri = "/orders/2";
        //Remember to check for the id to see the id exist or not!
        Order order = new Order();
        order.setStatus(Status.CANCELLED);
        String inputJson = super.mapToJson(order);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
}