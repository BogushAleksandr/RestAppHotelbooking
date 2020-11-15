package hotel.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_room")
    private String categoryName;

    public Category() {

    }

    public Category(String name) {
        this.categoryName = name;
    }

    public Category(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return String.format("Category [id = '%d', name = '%s']", id, categoryName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }
}
