package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product product=new Product();
        product.setId(1L);
        assertEquals(1L,product.getId());
        assertNotEquals(2L,product.getId());
    }

    @Test
    void setId() {
        Product product=new Product();
        product.setId(1L);
        assertEquals(1L,product.getId());
        assertNotEquals(2L,product.getId());
    }

    @Test
    void getNameProduct() {
//        Product product= new Product("iphone11 pro max", "version12", "iphone", new Category("Apple"), "gold color 164GB", "Phone", 120);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", new Category("phone"),120);
        assertEquals("iphone11 pro max",product.getNameProduct());
        assertNotEquals("iphone10",product.getNameProduct());

    }

    @Test
    void setNameProduct() {
        Product product=new Product();
        product.setNameProduct("iphone11 pro max");
        assertEquals("iphone11 pro max",product.getNameProduct());
        assertNotEquals("iphone10",product.getNameProduct());
    }

    @Test
    void getModel() {
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", new Category("phone"),120);
        assertEquals("version12",product.getModel());
        assertNotEquals("version11",product.getModel());
    }

    @Test
    void setModel() {
        Product product=new Product();
        product.setModel("version12");
        assertEquals("version12",product.getModel());
        assertNotEquals("version11",product.getModel());
    }

    @Test
    void getBrand() {
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", new Category("phone"),120);
        assertEquals("iphone",product.getBrand());
        assertNotEquals("samsung",product.getBrand());
    }

    @Test
    void setBrand() {
        Product product=new Product();
        product.setBrand("iphone");
        assertEquals("iphone",product.getBrand());
        assertNotEquals("samsung",product.getBrand());
    }

    @Test
    void getCompany() {
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", new Category("phone"),120);
        assertEquals("Apple",product.getCompany());
        assertNotEquals("Samsung",product.getCompany());
    }

    @Test
    void setCompany() {
        Product product=new Product();
        product.setCompany("Apple");
        assertEquals("Apple",product.getCompany());
        assertNotEquals("Samsung",product.getCompany());
    }

    @Test
    void getDescription() {
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", new Category("phone"),120);
        assertEquals("rose gold",product.getDescription());
        assertNotEquals("white",product.getDescription());
    }

    @Test
    void setDescription() {
        Product product=new Product();
        product.setDescription("rose gold");
        assertEquals("rose gold",product.getDescription());
        assertNotEquals("white",product.getDescription());
    }

    @Test
    void getCategory() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        assertEquals(category,product.getCategory());
        assertNotEquals("laptop",product.getCategory());
    }

    @Test
    void setCategory() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product();
        product.setCategory(category);
        assertEquals(category,product.getCategory());
        assertNotEquals("laptop",product.getCategory());
    }

    @Test
    void getPrice() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        assertEquals(120,product.getPrice());
        assertNotEquals(124,product.getPrice());
    }

    @Test
    void setPrice() {
        Product product=new Product();
        product.setPrice(120);
        assertEquals(120,product.getPrice());
        assertNotEquals(124,product.getPrice());
    }

    @Test
    void testHashCode() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Product product1=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Product product2=new Product("iphone11 ","version12","iphone","Apple","rose gold", category,120);

        assertEquals(product.hashCode(),product1.hashCode());
        assertNotEquals(product.hashCode(),product2.hashCode());
    }

    @Test
    void testToString() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        assertEquals("Product{id=null, nameProduct='iphone11 pro max', model='version12', brand='iphone', company='Apple', description='rose gold', category='Category{id=1, name='phone'}', price=120}",product.toString());
        assertNotEquals("Product{id=null, nameProduct='iphone11', model='version10', brand='iphone', company='Apple', description='rose gold', category='Category{id=1, name='phone'}', price=120}",product.toString());

    }

    @Test
    void testEquals() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Product product1=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Product product2=new Product("iphone11","version10","iphone","Apple","rose gold", category,120);

        assertEquals(true, product.equals(product1));
        assertEquals(false, product.equals(product2));
    }
}