package rmit.university.sadi.entity;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import rmit.university.sadi.repository.Status;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getId() {
        Order order=new Order();
        order.setId(1L);
        assertEquals(1L,order.getId());
        assertNotEquals(2L,order.getId());

    }

    @Test
    void getDescription() {
        Order order=new Order("MacBook", Status.COMPLETED);
        assertEquals("MacBook",order.getDescription());
        assertNotEquals("Xmas",order.getDescription());
    }

    @Test
    void getStatus() {
        Order order=new Order("MacBook", Status.COMPLETED);
        assertEquals(Status.COMPLETED,order.getStatus());
        assertNotEquals(Status.CANCELLED,order.getStatus());
    }

    @Test
    void setId() {
        Order order=new Order();
        order.setId(1L);
        assertEquals(1L,order.getId());
        assertNotEquals(2L,order.getId());
    }

    @Test
    void setDescription() {
        Order order=new Order();
        order.setDescription("MacBook");
        assertEquals("MacBook",order.getDescription());
        assertNotEquals("Xmas",order.getDescription());
    }

    @Test
    void setStatus() {
        Order order=new Order();
        order.setStatus(Status.IN_PROGRESS);
        assertEquals(Status.IN_PROGRESS,order.getStatus());
        assertNotEquals(Status.CANCELLED,order.getStatus());
    }

    @Test
    void testEquals() {
        Order order1=new Order("MacBook", Status.COMPLETED);
        Order order2=new Order("MacBook", Status.COMPLETED);
        Order order3=new Order("phone", Status.CANCELLED);
        assertEquals(true,order1.equals(order2));
        assertEquals(false,order1.equals(order3));
    }

    @Test
    void testHashCode() {
        Order order=new Order("MacBook", Status.COMPLETED);
        assertEquals(468909439,order.hashCode());
        assertNotEquals("468909439",order.hashCode());

    }

    @Test
    void testToString() {
        Order order=new Order("MacBook", Status.COMPLETED);
        assertEquals("Order{id=null, description='MacBook', status=COMPLETED}",order.toString());
        assertNotEquals("hello",order.toString());
    }
}