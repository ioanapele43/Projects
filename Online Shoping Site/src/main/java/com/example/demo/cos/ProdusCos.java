package com.example.demo.cos;

import com.example.demo.produse.Produs;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;


@Entity
@Table(name = "cart")
public class ProdusCos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 55)
    private String name;

    @Column(name = "category", nullable = false, length = 55)
    private String category;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity_stock")
    private int quantityStock;

    @Column(name = "image", nullable = false, length = 100)
    private String image;

    @Column(name = "quantity_cart")
    private int quantityCart;
    @Column(name="email", length = 45)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }
}
