package rmit.university.sadi.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void getId() {
        Category category=new Category("phone");
        category.setId(1L);
        assertEquals(1L ,category.getId());
        assertNotEquals(2L,category.getName());
    }

    @Test
    void setId() {
        Category category=new Category("phone");
        category.setId(1L);
        assertEquals(1L ,category.getId());
        assertNotEquals(2L,category.getName());
    }

    @Test
    void getName() {
        Category category=new Category("phone");
        assertEquals("phone",category.getName());
        assertNotEquals("laptop",category.getName());
    }

    @Test
    void setName() {
        Category category=new Category();
        category.setName("phone");
        assertEquals("phone",category.getName());
        assertNotEquals("bonjour",category.getName());
    }

    @Test
    void testEquals() {
        Category category1=new Category("laptop");
        category1.setId(1L);
        Category category2= new Category("phone");
        category2.setId((1L));
        Category category3=new Category("laptop");
        category3.setId(1L);
        assertEquals(true,category1.equals(category3));
        assertNotEquals(true,category1.equals(category2));
    }

    @Test
    void testHashCode() {
        Category category1=new Category("laptop");
        category1.setId(1L);
        assertEquals(-1109984838,category1.hashCode());
        assertNotEquals(12313,category1.hashCode());
    }

    @Test
    void testToString() {
        Category category1=new Category("laptop");
        category1.setId(1L);
        assertEquals("Category{id=1, name='laptop'}",category1.toString());
        assertNotEquals("hello", category1.toString());
    }
}