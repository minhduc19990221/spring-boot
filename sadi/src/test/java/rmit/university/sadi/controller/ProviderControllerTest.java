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
import rmit.university.sadi.entity.Provider;
import rmit.university.sadi.repository.ProviderRepository;

import java.util.List;
import java.util.stream.Collectors;


public class ProviderControllerTest extends AbstractTest {
    @Autowired
    private ProviderRepository repository;

    @Autowired
    private ProviderModelAssembler assembler;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProviderList() throws Exception {
        String uri = "/providers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<EntityModel<Provider>> providers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        assertTrue(providers.stream().count() > 1);

    }

    @Test
    public void createProvider() throws Exception {
        String uri = "/providers";
        Provider provider = new Provider();
        provider.setName("AIA");
        List<EntityModel<Provider>> providers = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        String inputJson = super.mapToJson(provider);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

    @Test
    public void updateProvider() throws Exception {
        String uri = "/providers/2";
        //Remember to check for the id to see the id exist or not!
        Provider provider=new Provider();
        provider.setName("Apple");
        String inputJson = super.mapToJson(provider);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

    @Test
    public void deleteProvider() throws Exception {
        String uri = "/providers/4";
        //Remember to change the id above to make this test success!
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
    }


}