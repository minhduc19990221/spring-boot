package rmit.university.sadi.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventoryReceivingNoteDetail")
public class InventoryReceivingNoteDetail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
//    @JsonIgnore
    private InventoryReceivingNote inventoryReceivingNote;
    @ManyToOne
    private Product product;
    @Column
    private int quantity;

    public InventoryReceivingNoteDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryReceivingNote getInventoryReceivingNote() {
        return inventoryReceivingNote;
    }

    public void setInventoryReceivingNote(InventoryReceivingNote inventoryReceivingNote) {
        this.inventoryReceivingNote = inventoryReceivingNote;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
