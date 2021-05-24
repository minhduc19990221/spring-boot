package rmit.university.sadi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventoryDeliveryNote")
public class InventoryDeliveryNote {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String date;
    @ManyToOne
    private Employee staff;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }
}
