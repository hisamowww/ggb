package com.example.ggb.entyties;

import jakarta.persistence.*;

@Entity
public class Contragent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contragentCategory_id", nullable = false)
    private ContragentCategory contragentCategory;

    public Contragent() {
    }

    public Contragent(Long id, String name, String address, ContragentCategory contragentCategory) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contragentCategory = contragentCategory;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ContragentCategory getContragentCategory() {
        return contragentCategory;
    }

    public void setContragentCategory(ContragentCategory contragentCategory) {
        this.contragentCategory = contragentCategory;
    }
}
