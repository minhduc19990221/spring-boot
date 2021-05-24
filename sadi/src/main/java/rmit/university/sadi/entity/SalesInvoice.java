package rmit.university.sadi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "salesInvoice")
public class SalesInvoice {
    //id, date, name of sales staff, customer, product, quantity, price, total value
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private String date;
    @ManyToOne
    private Employee staff;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Product product;
    @Column
    private int quantity;
    @Column
    private double price;
    @Column
    private double totalValue;

    public SalesInvoice() {
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

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesInvoice that = (SalesInvoice) o;
        return quantity == that.quantity &&
                Double.compare(that.price, price) == 0 &&
                Double.compare(that.totalValue, totalValue) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(staff, that.staff) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, staff, customer, product, quantity, price, totalValue);
    }

    @Override
    public String toString() {
        return "SalesInvoice{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", staff=" + staff +
                ", customer=" + customer +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalValue=" + totalValue +
                '}';
    }
}
