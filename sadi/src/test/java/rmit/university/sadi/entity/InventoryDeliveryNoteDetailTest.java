package rmit.university.sadi.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDeliveryNoteDetailTest {
    @Mock
    private int id;
    private InventoryDeliveryNote inventoryDeliveryNote;
    private Product product;
    private int quantity;

    @Test
    void getId() {
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();
        inventoryDeliveryNoteDetail.setId(1);
        assertEquals(1,inventoryDeliveryNoteDetail.getId());
        assertNotEquals(2,inventoryDeliveryNoteDetail.getId());

    }

    @Test
    void setId() {
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();
        inventoryDeliveryNoteDetail.setId(1);
        assertEquals(1,inventoryDeliveryNoteDetail.getId());
        assertNotEquals(2,inventoryDeliveryNoteDetail.getId());
    }

    @Test
    void getInventoryDeliveryNote() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");

        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();

        inventoryDeliveryNote.setId(1L);
        inventoryDeliveryNote.setStaff(staff);
        inventoryDeliveryNote.setDate("20/05/2020");

        inventoryDeliveryNoteDetail.setInventoryDeliveryNote(inventoryDeliveryNote);
        assertEquals(inventoryDeliveryNote,inventoryDeliveryNoteDetail.getInventoryDeliveryNote());


    }

    @Test
    void setInventoryDeliveryNote() {
        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);
        Staff staff=new Staff("Duc","Cao","Seller","0978647637","ducsocute@gmail.com","172 Nguyen Van Linh");

        InventoryDeliveryNote inventoryDeliveryNote=new InventoryDeliveryNote();
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();

        inventoryDeliveryNote.setId(1L);
        inventoryDeliveryNote.setStaff(staff);
        inventoryDeliveryNote.setDate("20/05/2020");

        inventoryDeliveryNoteDetail.setInventoryDeliveryNote(inventoryDeliveryNote);
        assertEquals(inventoryDeliveryNote,inventoryDeliveryNoteDetail.getInventoryDeliveryNote());

    }

    @Test
    void getProduct() {
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();

        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        Category category2=new Category("phone");
        category2.setId(1L);
        Product product2=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category2,120);

        inventoryDeliveryNoteDetail.setProduct(product);
        assertEquals(product2,inventoryDeliveryNoteDetail.getProduct());
    }

    @Test
    void setProduct() {
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();

        Category category=new Category("phone");
        category.setId(1L);
        Product product=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category,120);

        Category category2=new Category("phone");
        category2.setId(1L);
        Product product2=new Product("iphone11 pro max","version12","iphone","Apple","rose gold", category2,120);

        inventoryDeliveryNoteDetail.setProduct(product);
        assertEquals(product2,inventoryDeliveryNoteDetail.getProduct());
    }

    @Test
    void getQuantity() {
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();
        inventoryDeliveryNoteDetail.setQuantity(12);
        assertEquals(12,inventoryDeliveryNoteDetail.getQuantity());

    }

    @Test
    void setQuantity() {
        InventoryDeliveryNoteDetail inventoryDeliveryNoteDetail= new InventoryDeliveryNoteDetail();
        inventoryDeliveryNoteDetail.setQuantity(12);
        assertEquals(12,inventoryDeliveryNoteDetail.getQuantity());
    }
}