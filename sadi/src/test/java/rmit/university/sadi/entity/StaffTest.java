package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    void getName() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals("Duc Cao",staff.getName());
        assertNotEquals("Cao Duc",staff.getName());
    }

    @Test
    void setName() {
        Staff staff=new Staff();
        staff.setName("Duc Cao");
        assertEquals("Duc Cao",staff.getName());
        assertNotEquals("Cao Duc",staff.getName());
    }

    @Test
    void getId() {
        Staff staff=new Staff();
        staff.setId(1L);
        assertEquals(1L,staff.getId());
        assertNotEquals(2L,staff.getId());
    }

    @Test
    void setId() {
        Staff staff=new Staff();
        staff.setId(1L);
        assertEquals(1L,staff.getId());
        assertNotEquals(2L,staff.getId());
    }

    @Test
    void getFirstName() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals("Duc",staff.getFirstName());
        assertNotEquals("Cao",staff.getFirstName());
    }

    @Test
    void getLastName() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertNotEquals("Duc",staff.getLastName());
        assertEquals("Cao",staff.getLastName());
    }

    @Test
    void getRole() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertNotEquals("ChairMan",staff.getRole());
        assertEquals("Seller",staff.getRole());
    }

    @Test
    void setRole() {
        Staff staff= new Staff();
        staff.setRole("Seller");
        assertNotEquals("ChairMan",staff.getRole());
        assertEquals("Seller",staff.getRole());
    }

    @Test
    void getPhone() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals("0978647637",staff.getPhone());
        assertNotEquals("097864763",staff.getPhone());
    }

    @Test
    void setPhone() {
        Staff staff= new Staff();
        staff.setPhone("0978647637");
        assertEquals("0978647637",staff.getPhone());
        assertNotEquals("097864763",staff.getPhone());
    }

    @Test
    void getEmail() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals("ducsocute@gmail.com",staff.getEmail());
        assertNotEquals("anhsocute@gmail.com",staff.getEmail());
    }

    @Test
    void setEmail() {
        Staff staff= new Staff();
        staff.setEmail("ducsocute@gmail.com");
        assertEquals("ducsocute@gmail.com",staff.getEmail());
        assertNotEquals("anhsocute@gmail.com",staff.getEmail());
    }

    @Test
    void getAddress() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals("172 Nguyen Van Linh",staff.getAddress());
        assertNotEquals("17 Nguyen Van Linh",staff.getAddress());
    }

    @Test
    void setAddress() {
        Staff staff= new Staff();
        staff.setAddress("172 Nguyen Van Linh");
        assertEquals("172 Nguyen Van Linh",staff.getAddress());
        assertNotEquals("17 Nguyen Van Linh",staff.getAddress());
    }

    @Test
    void testEquals() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Staff staff1=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Staff staff2=new Staff("Anh","Cao","Chairman","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals(true,staff.equals(staff1));
        assertEquals(false,staff.equals(staff2));

    }

    @Test
    void testHashCode() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Staff staff1=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        Staff staff2=new Staff("Anh","Cao","Chairman","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals(staff.hashCode(),staff1.hashCode());
        assertNotEquals(staff.hashCode(),staff2.hashCode());

    }

    @Test
    void testToString() {
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        assertEquals("Staff{id=null, firstName='Duc', lastName='Cao', role='Seller', phone='0978647637', email='ducsocute@gmail.com', address='172 Nguyen Van Linh'}",staff.toString());
        assertNotEquals("Staff{id=null, firstName='Anh', lastName='Cao', role='Seller', phone='0978647637', email='ducsocute@gmail.com', address='172 Nguyen Van Linh'}",staff.toString());
    }
}