package rmit.university.sadi.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category {
    private @Id @GeneratedValue @Column Long id;
    private @Column String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
//    private Collection<Product> product =new ArrayList<Product>();

    public Category(String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Collection<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(Collection<Product> product) {
//        this.product = product;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
