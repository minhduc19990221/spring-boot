package rmit.university.sadi.controller;

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
import rmit.university.sadi.entity.SalesInvoice;
import rmit.university.sadi.entity.Staff;
import rmit.university.sadi.repository.SalesInvoiceRepository;

import java.util.List;
import java.util.stream.Collectors;


public class SalesInvoiceControllerTest extends AbstractTest {
    @Autowired
    private SalesInvoiceRepository repository;

    @Autowired
    private SalesInvoiceModelAssembler assembler;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getSalesInvoicesList() throws Exception {
        String uri = "/SalesInvoices";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<SalesInvoice>> salesInvoices = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(salesInvoices.stream().count() > 1);

    }

    @Test
    public void createSalesInvoice() throws Exception {
        String uri = "/saleInvoices";
        SalesInvoice salesInvoice = new SalesInvoice();
        Customer cus = new Customer("Mark", "341 Nanoko", "098867712", "2197301", "mark@gmail.com", "Peter");
        salesInvoice.setId(88L);
        salesInvoice.setCustomer(cus);
        List<EntityModel<SalesInvoice>> salesInvoices = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(salesInvoices);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

    @Test
    public void updateSalesInvoice() throws Exception {
        String uri = "/salesInvoices/2";
        //Remember to check for the id to see the id exist or not!
        SalesInvoice salesInvoice = new SalesInvoice();
        Customer cus = new Customer("Mark", "341 Nanoko", "098867712", "2197301", "mark@gmail.com", "Peter");
        salesInvoice.setCustomer(cus);
        String inputJson = super.mapToJson(salesInvoice);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

    @Test
    public void deleteSalesInvoice() throws Exception {
        String uri = "/salesInvoices/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }


}