package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getId() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        customer.setId(1L);
        assertEquals(1L,customer.getId());
        assertNotEquals(2L,customer.getId());
    }

    @Test
    void setId() {

        Customer customer=new Customer();
        customer.setId(2L);
        assertEquals(2L,customer.getId());
        assertNotEquals(1L,customer.getId());
    }

    @Test
    void getName() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("John",customer.getName());
        assertNotEquals("john",customer.getName());
    }

    @Test
    void setName() {

        Customer customer=new Customer();
        customer.setName("John");
        assertEquals("John",customer.getName());
        assertNotEquals("john",customer.getName());
    }

    @Test
    void getAddress() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("23 Nguyen Van Linh",customer.getAddress());
        assertNotEquals("25 Nguyen Van Linh",customer.getAddress());
    }

    @Test
    void setAddress() {

        Customer customer=new Customer();
        customer.setAddress("23 Nguyen Van Linh");
        assertEquals("23 Nguyen Van Linh",customer.getAddress());
        assertNotEquals("25 Nguyen Van Linh",customer.getAddress());
    }

    @Test
    void getPhone() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("089765645434",customer.getPhone());
        assertNotEquals("08976564543",customer.getPhone());

    }

    @Test
    void setPhone() {

        Customer customer=new Customer();
        customer.setPhone("089765645434");
        assertEquals("089765645434",customer.getPhone());
        assertNotEquals("08976564543",customer.getPhone());
    }

    @Test
    void getFax() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("87676564564",customer.getFax());
        assertNotEquals("8767656456",customer.getFax());
    }

    @Test
    void setFax() {

        Customer customer=new Customer();
        customer.setFax("87676564564");
        assertEquals("87676564564",customer.getFax());
        assertNotEquals("8767656456",customer.getFax());
    }

    @Test
    void getEmail() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("John@gmail.com",customer.getEmail());
        assertNotEquals("john@gmail.com",customer.getEmail());
    }

    @Test
    void setEmail() {

        Customer customer=new Customer();
        customer.setEmail("John@gmail.com");
        assertEquals("John@gmail.com",customer.getEmail());
        assertNotEquals("john@gmail.com",customer.getEmail());
    }

    @Test
    void getContactPerson() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("Mike",customer.getContactPerson());
        assertNotEquals("Lan",customer.getContactPerson());
    }

    @Test
    void setContactPerson() {

        Customer customer=new Customer();
        customer.setContactPerson("Mike");
        assertEquals("Mike",customer.getContactPerson());
        assertNotEquals("Lan",customer.getContactPerson());
    }

    @Test
    void testToString() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("Customer{id=null, name='John', address='23 Nguyen Van Linh', phone='089765645434', fax='87676564564', email='John@gmail.com', contactPerson='Mike'}",customer.toString());
        assertNotEquals("hello",customer.toString());

    }

    @Test
    void testEquals() {

        Customer customer1= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        Customer customer2= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        Customer customer3= new Customer("Mike","23 Nguyen Van Linh","089765645764","87676564564","Mike@gmail.com","Mike");
        assertEquals(true,customer1.equals(customer2));
        assertEquals(false,customer1.equals(customer3));
    }

    @Test
    void testHashCode() {

        Customer customer= new Customer("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals(-637692272,customer.hashCode());
        assertNotEquals(-637692223,customer.hashCode());
        assertNotEquals("-637692272",customer.hashCode());
    }
}