package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import rmit.university.sadi.controller.CategoryModelAssembler;
import rmit.university.sadi.repository.CategoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDeliveryNoteTest {
    @Mock
    private Long id;
    private String date;
    private Staff staff;

    @Test
    void getInventoryDeliveryNoteDetails() {
//        Category category=new Category("phone");
//        category.setId(1L);
//        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
//
//        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail=new InventoryDeliveryNoteDetail();
//
//        inventoryDeliveryNoteDetail.setId(12);
//        inventoryDeliveryNoteDetail.setProduct(product);
//        inventoryDeliveryNoteDetail.setQuantity(12);

        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
//        List<InventoryDeliveryNoteDetail> inventoryDeliveryNoteDetails = new List<InventoryDeliveryNoteDetail>();
//        List<InventoryDeliveryNoteDetail> inventoryDeliveryNoteDetails=null;
//       inventoryDeliveryNoteDetails.add(inventoryDeliveryNoteDetail);
//        inventoryDeliveryNote.setInventoryDeliveryNoteDetails(inventoryDeliveryNoteDetails);
//        assertEquals("hello",inventoryDeliveryNote.getInventoryDeliveryNoteDetails());
    }

    @Test
    void setInventoryDeliveryNoteDetails() {
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
    }

    @Test
    void getId() {
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        inventoryDeliveryNote.setId(1L);
        assertEquals(1L,inventoryDeliveryNote.getId());
        assertNotEquals(2L,inventoryDeliveryNote.getId());
    }

    @Test
    void setId() {
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        inventoryDeliveryNote.setId(1L);
        assertEquals(1L,inventoryDeliveryNote.getId());
        assertNotEquals(2L,inventoryDeliveryNote.getId());
    }

    @Test
    void getDate() {
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        inventoryDeliveryNote.setDate("25/05/2020");
        assertEquals("25/05/2020",inventoryDeliveryNote.getDate());
        assertNotEquals("26/05/2020",inventoryDeliveryNote.getDate());
    }

    @Test
    void setDate() {
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        inventoryDeliveryNote.setDate("25/05/2020");
        assertEquals("25/05/2020",inventoryDeliveryNote.getDate());
        assertNotEquals("26/05/2020",inventoryDeliveryNote.getDate());
    }

    @Test
    void getStaff() {
        Staff staff1=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        staff1.setId(1L);
        Staff staff2=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        staff2.setId(1L);
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        inventoryDeliveryNote.setStaff(staff1);
        assertEquals(staff2,inventoryDeliveryNote.getStaff());
    }

    @Test
    void setStaff() {
        Staff staff1=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        staff1.setId(1L);
        Staff staff2=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");
        staff2.setId(1L);
        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        inventoryDeliveryNote.setStaff(staff1);
        assertEquals(staff2,inventoryDeliveryNote.getStaff());
    }
}