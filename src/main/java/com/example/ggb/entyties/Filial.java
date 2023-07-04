package com.example.ggb.entyties;

import jakarta.persistence.*;

@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "org_id", nullable = false)
    private Org org;

    public Filial() {
    }

    public Filial(Long id, String name, String address, Org org) {
        this.name = name;
        this.address = address;
        this.org = org;
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

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }
}
