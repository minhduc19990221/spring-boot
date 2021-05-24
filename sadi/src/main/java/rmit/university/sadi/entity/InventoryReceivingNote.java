package rmit.university.sadi.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventoryReceivingNote")
public class InventoryReceivingNote {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String date;
    @Column
    private String name;//person who makes the note
    @OneToMany(mappedBy = "inventoryReceivingNote", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryReceivingNoteDetail> inventoryReceivingNoteDetails;

    public List<InventoryReceivingNoteDetail> getInventoryReceivingNoteDetails() {
        return inventoryReceivingNoteDetails;
    }

    public void setInventoryReceivingNoteDetails(List<InventoryReceivingNoteDetail> inventoryReceivingNoteDetails) {
        this.inventoryReceivingNoteDetails = inventoryReceivingNoteDetails;
    }

    public InventoryReceivingNote() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

