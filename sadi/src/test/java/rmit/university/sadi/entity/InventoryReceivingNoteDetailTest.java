package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class InventoryReceivingNoteDetailTest {
    @Mock
    private int id;
    private InventoryReceivingNote inventoryReceivingNote;
    private Product product;
    private int quantity;

    @Test
    void getId() {
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail= new InventoryReceivingNoteDetail();
        inventoryReceivingNoteDetail.setId(1);
        assertEquals(1,inventoryReceivingNoteDetail.getId());
        assertNotEquals(2,inventoryReceivingNoteDetail.getId());
    }

    @Test
    void setId() {
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail= new InventoryReceivingNoteDetail();
        inventoryReceivingNoteDetail.setId(1);
        assertEquals(1,inventoryReceivingNoteDetail.getId());
        assertNotEquals(2,inventoryReceivingNoteDetail.getId());
    }

    @Test
    void getInventoryReceivingNote() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail=new InventoryReceivingNoteDetail();

        inventoryReceivingNote.setId(1L);
        inventoryReceivingNote.setName("Duc");
        inventoryReceivingNote.setDate("20/05/2020");

        inventoryReceivingNoteDetail.setInventoryReceivingNote(inventoryReceivingNote);
        assertEquals(inventoryReceivingNote,inventoryReceivingNoteDetail.getInventoryReceivingNote());


    }

    @Test
    void setInventoryReceivingNote() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        InventoryReceivingNote inventoryReceivingNote=new InventoryReceivingNote();
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail=new InventoryReceivingNoteDetail();

        inventoryReceivingNote.setId(1L);
        inventoryReceivingNote.setName("Duc");
        inventoryReceivingNote.setDate("20/05/2020");

        inventoryReceivingNoteDetail.setInventoryReceivingNote(inventoryReceivingNote);
        assertEquals(inventoryReceivingNote,inventoryReceivingNoteDetail.getInventoryReceivingNote());

    }

    @Test
    void getProduct() {
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail= new InventoryReceivingNoteDetail();

        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        Category category2=new Category("phone");
        category2.setId(1L);
        Product product2=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category2,120);

        inventoryReceivingNoteDetail.setProduct(product);
        assertEquals(product2,inventoryReceivingNoteDetail.getProduct());

    }

    @Test
    void setProduct() {
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail= new InventoryReceivingNoteDetail();

        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        Category category2=new Category("phone");
        category2.setId(1L);
        Product product2=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category2,120);

        Category category3=new Category("phone");
        category3.setId(2L);
        Product product3=new Product("iphone11","version12","iphone","Apple","rose gold", category3,120);

        inventoryReceivingNoteDetail.setProduct(product);
        assertEquals(product2,inventoryReceivingNoteDetail.getProduct());
        assertNotEquals(product3,inventoryReceivingNoteDetail.getProduct());

    }

    @Test
    void getQuantity() {
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail= new InventoryReceivingNoteDetail();
        inventoryReceivingNoteDetail.setQuantity(12);
        assertEquals(12,inventoryReceivingNoteDetail.getQuantity());

    }

    @Test
    void setQuantity() {
        InventoryReceivingNoteDetail inventoryReceivingNoteDetail= new InventoryReceivingNoteDetail();
        inventoryReceivingNoteDetail.setQuantity(12);
        assertEquals(12,inventoryReceivingNoteDetail.getQuantity());
    }
}