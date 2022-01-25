package com.example.demo.produse;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 55)
    private String name;

    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @Column(name = "category", nullable = false, length = 55)
    private String category;
    @Column(name = "subcategory", nullable = false, length =55)
    private String subcategory;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description", nullable = false, length = 5000)
    private String description;

    @Column(name = "provider", nullable = false, length = 20)
    private String provider;

    @Column(name = "image1", nullable = false, length = 100)
    private String image1;
    @Column(name = "image2", nullable = false, length = 100)
    private String image2;
    @Column(name = "image3", nullable = false, length = 100)
    private String image3;

    // getters and setters are not shown


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCategory() {
        return category;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}