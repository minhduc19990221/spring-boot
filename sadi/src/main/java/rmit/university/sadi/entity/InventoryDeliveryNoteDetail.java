package rmit.university.sadi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "inventoryDeliveryNoteDetail")
public
class InventoryDeliveryNoteDetail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
//    @JsonIgnore
    private InventoryDeliveryNote inventoryDeliveryNote;
    @ManyToOne
    private Product product;
    @Column
    private int quantity;

    public InventoryDeliveryNoteDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryDeliveryNote getInventoryDeliveryNote() {
        return inventoryDeliveryNote;
    }

    public void setInventoryDeliveryNote(InventoryDeliveryNote inventoryDeliveryNote) {
        this.inventoryDeliveryNote = inventoryDeliveryNote;
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
