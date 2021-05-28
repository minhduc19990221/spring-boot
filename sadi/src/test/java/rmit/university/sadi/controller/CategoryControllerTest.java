package rmit.university.sadi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rmit.university.sadi.entity.Category;
import rmit.university.sadi.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private  CategoryRepository categoryRepository;
    private  CategoryModelAssembler categoryModelAssembler;
    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setUp(){
        MockMvcBuilders.webAppContextSetup(context).build();
    }
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void all() {
        CategoryController categoryController=new CategoryController(categoryRepository,categoryModelAssembler);
        Category category1=new Category("phone");
        category1.setId(1L);
        Category category2=new Category("phone");
        category2.setId(2L);

        // save() method of CategoryRepository
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryModelAssembler.toModel(category1);
        categoryModelAssembler.toModel(category2);
//        CollectionModel<EntityModel<Category>> createdCategoryAsMono = categoryController.all();
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);

        assertNotEquals(categoryList,categoryController.all());

    }

    @Test
    void newCategory() {
    }

    @Test
    void one() {
    }

    @Test
    void identifier() {
    }

    @Test
    void replaceCategory() {
    }

    @Test
    void deleteCategory() {
    }
}