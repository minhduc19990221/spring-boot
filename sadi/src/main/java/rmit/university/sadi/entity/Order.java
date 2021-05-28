package rmit.university.sadi.entity;
import rmit.university.sadi.repository.Status;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Customer_Order")
public class Order {

    private @Id @GeneratedValue @Column Long id;
    private @ManyToOne Staff staff;
    private @ManyToOne Provider provider;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private OrderDetails orderDetailsList;

    private @Column String description;
    private @Column Status status;

    public Order() {}

    public Order(Staff staff, Provider provider, OrderDetails orderDetailsList, String description, Status status) {
        this.staff = staff;
        this.provider = provider;
        this.orderDetailsList = orderDetailsList;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Order))
            return false;
        Order order = (Order) o;
        return Objects.equals(this.id, order.id) && Objects.equals(this.description, order.description)
                && this.status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.description, this.status);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + this.id + ", description='" + this.description + '\'' + ", status=" + this.status + '}';
    }
}
