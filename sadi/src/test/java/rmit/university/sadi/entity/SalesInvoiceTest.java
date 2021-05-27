package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesInvoiceTest {

    @Test
    void getId() {
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setId(1L);
        assertEquals(1L,salesInvoice.getId());
        assertNotEquals(2L,salesInvoice.getId());
    }

    @Test
    void setId() {
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setId(1L);
        assertEquals(1L,salesInvoice.getId());
        assertNotEquals(2L,salesInvoice.getId());
    }

    @Test
    void getDate() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);

        assertEquals("20/5/2020",salesInvoice.getDate());
        assertNotEquals("25/5/2020",salesInvoice.getDate());
    }

    @Test
    void setDate() {
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setDate("20/5/2020");

        assertEquals("20/5/2020",salesInvoice.getDate());
        assertNotEquals("25/5/2020",salesInvoice.getDate());

    }

    @Test
    void getStaff() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);

        assertEquals(staff,salesInvoice.getStaff());
        assertNotEquals("Staff{id=1, firstName='Duc', lastName='Cao', role='Seller', phone='0978647637', email='ducsocute@gmail.com', address='172 Nguyen Van Linh'}",salesInvoice.getDate());
    }

    @Test
    void setStaff() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");

        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setStaff(staff);

        assertEquals(staff,salesInvoice.getStaff());
        assertNotEquals("Staff{id=1, firstName='Duc', lastName='Cao', role='Seller', phone='0978647637', email='ducsocute@gmail.com', address='172 Nguyen Van Linh'}",salesInvoice.getDate());
    }

    @Test
    void getCustomer() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);

        assertEquals(customer,salesInvoice.getCustomer());
        assertNotEquals("Customer{id=1, name='John', address='23 Nguyen Van Linh', phone='089765645434', fax='87676564564', email='John@gmail.com', contactPerson='Mike'}",salesInvoice.getDate());

    }

    @Test
    void setCustomer() {
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setCustomer(customer);
        assertEquals(customer,salesInvoice.getCustomer());
        assertNotEquals("Customer{id=1, name='John', address='23 Nguyen Van Linh', phone='089765645434', fax='87676564564', email='John@gmail.com', contactPerson='Mike'}",salesInvoice.getDate());

    }

    @Test
    void getProduct() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);

        assertEquals(product,salesInvoice.getProduct());
        assertNotEquals("Product{id=null, nameProduct='iphone11 pro max', model='version12', brand='iphone', company='Apple', description='rose gold', category='Category{id=1, name='phone'}', price=120}",salesInvoice.getProduct());

    }

    @Test
    void setProduct() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setProduct(product);
        assertEquals(product,salesInvoice.getProduct());
        assertNotEquals("Product{id=null, nameProduct='iphone11 pro max', model='version12', brand='iphone', company='Apple', description='rose gold', category='Category{id=1, name='phone'}', price=120}",salesInvoice.getProduct());

    }

    @Test
    void getQuantity() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);

        assertEquals(10,salesInvoice.getQuantity());
        assertNotEquals(11,salesInvoice.getQuantity());
    }

    @Test
    void setQuantity() {
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setQuantity(12);
        assertEquals(12,salesInvoice.getQuantity());
        assertNotEquals(11,salesInvoice.getQuantity());
    }

    @Test
    void getPrice() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);
        assertEquals(150,salesInvoice.getPrice());
        assertNotEquals(11,salesInvoice.getPrice());
    }

    @Test
    void setPrice() {
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setPrice(12);
        assertEquals(12,salesInvoice.getPrice());
        assertNotEquals(11,salesInvoice.getPrice());
    }

    @Test
    void getTotalValue() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);
        assertEquals(1500,salesInvoice.getTotalValue());
        assertNotEquals(11,salesInvoice.getTotalValue());
    }

    @Test
    void setTotalValue() {
        SalesInvoice salesInvoice=new SalesInvoice();
        salesInvoice.setTotalValue(12);
        assertEquals(12,salesInvoice.getTotalValue());
        assertNotEquals(11,salesInvoice.getTotalValue());
    }

    @Test
    void testEquals() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);
        SalesInvoice salesInvoice1=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);
        SalesInvoice salesInvoice2=new SalesInvoice("20/5/2020",staff,customer,product,50,150,7500);

        assertEquals(true,salesInvoice.equals(salesInvoice1));
        assertEquals(false,salesInvoice.equals(salesInvoice2));
    }

    @Test
    void testHashCode() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);
        SalesInvoice salesInvoice1=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);
        SalesInvoice salesInvoice2=new SalesInvoice("20/5/2020",staff,customer,product,50,150,7500);

        assertEquals(salesInvoice.hashCode(),salesInvoice1.hashCode());
        assertNotEquals(salesInvoice.hashCode(),salesInvoice2.hashCode());
    }

    @Test
    void testToString() {
        Category category=new Category("phone");
        category.setId(1L);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        SalesInvoice salesInvoice=new SalesInvoice("20/5/2020",staff,customer,product,10,150,1500);

        assertEquals("SalesInvoice{id=null, date='20/5/2020', staff=Staff{id=null, firstName='Duc', lastName='Cao', role='Seller', phone='0978647637', email='ducsocute@gmail.com', address='172 Nguyen Van Linh'}, customer=Customer{id=null, name='John', address='23 Nguyen Van Linh', phone='089765645434', fax='87676564564', email='John@gmail.com', contactPerson='Mike'}, product=Product{id=null, nameProduct='iphone11 pro max', model='version12', brand='iphone', company='Apple', description='rose gold', category='Category{id=1, name='phone'}', price=120}, quantity=10, price=150.0, totalValue=1500.0}",salesInvoice.toString());
    assertNotEquals("SalesInvoice{id=1, date='20/5/2020', staff=Staff{id=null, firstName='Duc', lastName='Cao', role='Seller', phone='0978647637', email='ducsocute@gmail.com', address='172 Nguyen Van Linh'}, customer=Customer{id=null, name='John', address='23 Nguyen Van Linh', phone='089765645434', fax='87676564564', email='John@gmail.com', contactPerson='Mike'}, product=Product{id=null, nameProduct='iphone11 pro max', model='version12', brand='iphone', company='Apple', description='rose gold', category='Category{id=1, name='phone'}', price=120}, quantity=10, price=150.0, totalValue=1500.0}",salesInvoice.toString());
    }
}