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
import rmit.university.sadi.entity.Product;
import rmit.university.sadi.repository.CategoryRepository;
import rmit.university.sadi.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

class ProductControllerTest extends AbstractTest  {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductModelAssembler assembler;

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }
    @Test
    public void getProductsList() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<Product>> products = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(products.stream().count() > 1);

    }
    @Test
    public void createProduct() throws Exception {
        String uri = "/products";
        Category category=new Category("phone");
        Product product = new Product();
        product.setId(88L);
        product.setNameProduct("Phone");
        product.setCategory(category);
        product.setDescription("gold");
        product.setBrand("apple");
        product.setModel("ver12");
        product.setCompany("apple");
        product.setPrice(120);
        List<EntityModel<Product>> products = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void updateProduct() throws Exception {
        String uri = "/products/2";
        //Remember to check for the id to see the id exist or not!
        Product product = new Product();
        product.setPrice(100);
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }
    @Test
    public void deleteProduct() throws Exception {
        String uri = "/products/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }
}