package com.example.ggb.entyties;

import jakarta.persistence.*;

@Entity
public class Podrazd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;

    public Podrazd() {
    }

    public Podrazd(Long id , String name, String address, Filial filial) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.filial = filial;
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

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }
}
