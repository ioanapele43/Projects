package com.example.demo.comenzi;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comenzi")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email",  length = 45)
    private String email;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "address", nullable = false, length = 20)
    private String address;
    @Column(name = "telefon", nullable = false)
    private String telefon;

    @Column(name = "totalValue", nullable = false)
    private int totalValue;
    @Column(name = "datacomanda", nullable = false)
    private Date datac;

    // getters and setters are not shown

    public Date getDatac() {
        return datac;
    }

    public void setDatac(Date datac) {
        this.datac = datac;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }
}