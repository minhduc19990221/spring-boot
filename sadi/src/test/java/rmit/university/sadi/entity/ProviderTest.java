package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {

    @Test
    void getId() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        provider.setId(1L);
        assertEquals(1L,provider.getId());
        assertNotEquals(2L,provider.getId());

    }

    @Test
    void setId() {
        Provider provider=new Provider();
        provider.setId(2L);
        assertEquals(2L,provider.getId());
        assertNotEquals(1L,provider.getId());
    }

    @Test
    void getName() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("John",provider.getName());
        assertNotEquals("john",provider.getName());
    }

    @Test
    void setName() {
        Provider provider=new Provider();
        provider.setName("John");
        assertEquals("John",provider.getName());
        assertNotEquals("john",provider.getName());
    }

    @Test
    void getAddress() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("23 Nguyen Van Linh",provider.getAddress());
        assertNotEquals("25 Nguyen Van Linh",provider.getAddress());
    }

    @Test
    void setAddress() {
        Provider provider=new Provider();
        provider.setAddress("23 Nguyen Van Linh");
        assertEquals("23 Nguyen Van Linh",provider.getAddress());
        assertNotEquals("25 Nguyen Van Linh",provider.getAddress());
    }

    @Test
    void getPhone() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("089765645434",provider.getPhone());
        assertNotEquals("08976564543",provider.getPhone());
    }

    @Test
    void setPhone() {
        Provider provider=new Provider();
        provider.setPhone("089765645434");
        assertEquals("089765645434",provider.getPhone());
        assertNotEquals("08976564543",provider.getPhone());
    }

    @Test
    void getFax() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("87676564564",provider.getFax());
        assertNotEquals("8767656456",provider.getFax());
    }

    @Test
    void setFax() {
        Provider provider=new Provider();
        provider.setFax("87676564564");
        assertEquals("87676564564",provider.getFax());
        assertNotEquals("8767656456",provider.getFax());
    }

    @Test
    void getEmail() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("John@gmail.com",provider.getEmail());
        assertNotEquals("john@gmail.com",provider.getEmail());
    }

    @Test
    void setEmail() {
        Provider provider=new Provider();
        provider.setEmail("John@gmail.com");
        assertEquals("John@gmail.com",provider.getEmail());
        assertNotEquals("john@gmail.com",provider.getEmail());
    }

    @Test
    void getContactPerson() {

        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("Mike",provider.getContactPerson());
        assertNotEquals("Lan",provider.getContactPerson());
    }

    @Test
    void setContactPerson() {
        Provider provider=new Provider();
        provider.setContactPerson("Mike");
        assertEquals("Mike",provider.getContactPerson());
        assertNotEquals("Lan",provider.getContactPerson());
    }

    @Test
    void testEquals() {
        Provider provider1= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        Provider provider2= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        Provider provider3= new Provider("Mike","23 Nguyen Van Linh","089765645764","87676564564","Mike@gmail.com","Mike");
        provider1.setId(1L);
        provider2.setId(1L);
        provider3.setId(2L);
        assertEquals(true,provider1.equals(provider2));
        assertEquals(false,provider1.equals(provider3));
    }

    @Test
    void testHashCode() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals(-637692272,provider.hashCode());
        assertNotEquals(-637692223,provider.hashCode());
        assertNotEquals("-637692272",provider.hashCode());
    }

    @Test
    void testToString() {
        Provider provider= new Provider("John","23 Nguyen Van Linh","089765645434","87676564564","John@gmail.com","Mike");
        assertEquals("Provider{id=null, name='John', address='23 Nguyen Van Linh', phone='089765645434', fax='87676564564', email='John@gmail.com', contactPerson='Mike'}",provider.toString());
        assertNotEquals("hello",provider.toString());

    }
}