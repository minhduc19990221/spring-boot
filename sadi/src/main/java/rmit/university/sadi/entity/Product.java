package rmit.university.sadi.entity;
import org.hibernate.annotations.Cascade;

import java.util.Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

//    private Category category;

    //@Inject
    public Product(String nameProduct, String model, String brand, String company, String description, Category category, int price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.model = model;
        this.brand = brand;
        this.company = company;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    private @Id @GeneratedValue Long id;
    private String nameProduct;
    private String model;
    private String brand;
    private String company;
    private String description;
    private int price;


    @ManyToOne
//    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Category category;

    Product(){}


    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, model, brand, company, description, category, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id)
                && Objects.equals(this.nameProduct, product.nameProduct)
                && Objects.equals(this.model, product.model)
                && Objects.equals(this.brand, product.brand)
                && Objects.equals(this.company, product.company)
                && Objects.equals(this.description, product.description)
                && Objects.equals(this.category, product.category)
                && Objects.equals(this.price, product.price)
                ;
    }
}
