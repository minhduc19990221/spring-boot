package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryReceivingNoteTest {
    @Mock
    private Long id;
    private String date;
    private String name;//person who makes the note


    @Test
    void getInventoryReceivingNoteDetails() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail=new InventoryReceivingNoteDetail();

        inventoryReceivingNoteDetail.setId(12);
        inventoryReceivingNoteDetail.setProduct(product);
        inventoryReceivingNoteDetail.setQuantity(12);

        ArrayList<InventoryReceivingNoteDetail> inventoryReceivingNoteDetails = new ArrayList<>();
        inventoryReceivingNoteDetails.add(inventoryReceivingNoteDetail);
        inventoryReceivingNote.setInventoryReceivingNoteDetails(inventoryReceivingNoteDetails);


        assertEquals(inventoryReceivingNoteDetail,inventoryReceivingNote.getInventoryReceivingNoteDetails().get(0));

    }

    @Test
    void setInventoryReceivingNoteDetails() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail=new InventoryReceivingNoteDetail();

        inventoryReceivingNoteDetail.setId(12);
        inventoryReceivingNoteDetail.setProduct(product);
        inventoryReceivingNoteDetail.setQuantity(12);

        ArrayList<InventoryReceivingNoteDetail> inventoryReceivingNoteDetails = new ArrayList<>();
        inventoryReceivingNoteDetails.add(inventoryReceivingNoteDetail);
        inventoryReceivingNote.setInventoryReceivingNoteDetails(inventoryReceivingNoteDetails);


        assertEquals(inventoryReceivingNoteDetail,inventoryReceivingNote.getInventoryReceivingNoteDetails().get(0));

    }

    @Test
    void getId() {
        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        inventoryReceivingNote.setId(1L);
        assertEquals(1L,inventoryReceivingNote.getId());
        assertNotEquals(2L,inventoryReceivingNote.getId());
    }

    @Test
    void setId() {
        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        inventoryReceivingNote.setId(1L);
        assertEquals(1L,inventoryReceivingNote.getId());
        assertNotEquals(2L,inventoryReceivingNote.getId());
    }

    @Test
    void getDate() {
        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        inventoryReceivingNote.setDate("25/05/2020");
        assertEquals("25/05/2020",inventoryReceivingNote.getDate());
        assertNotEquals("26/05/2020",inventoryReceivingNote.getDate());
    }

    @Test
    void setDate() {
        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        inventoryReceivingNote.setDate("25/05/2020");
        assertEquals("25/05/2020",inventoryReceivingNote.getDate());
        assertNotEquals("26/05/2020",inventoryReceivingNote.getDate());
    }

    @Test
    void getName() {
        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        inventoryReceivingNote.setName("Phuong");
        assertEquals("Phuong",inventoryReceivingNote.getName());
        assertNotEquals("Duc",inventoryReceivingNote.getName());
    }

    @Test
    void setName() {
        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        inventoryReceivingNote.setName("Phuong");
        assertEquals("Phuong",inventoryReceivingNote.getName());
        assertNotEquals("Duc",inventoryReceivingNote.getName());
    }
}