package rmit.university.sadi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventoryDeliveryNote")
public class InventoryDeliveryNote {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private String date;
    @ManyToOne
    private Staff staff;
    @OneToMany(mappedBy = "inventoryDeliveryNote", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryDeliveryNoteDetail> inventoryDeliveryNoteDetails;

    public List<InventoryDeliveryNoteDetail> getInventoryDeliveryNoteDetails() {
        return inventoryDeliveryNoteDetails;
    }

    public void setInventoryDeliveryNoteDetails(List<InventoryDeliveryNoteDetail> inventoryDeliveryNoteDetails) {
        this.inventoryDeliveryNoteDetails = inventoryDeliveryNoteDetails;
    }

    public InventoryDeliveryNote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
