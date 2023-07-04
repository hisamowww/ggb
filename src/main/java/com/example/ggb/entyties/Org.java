package com.example.ggb.entyties;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Org {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true, length = 100)
    private String name;
    @Column(name = "address", length = 100)
    private String address;

    @OneToMany(mappedBy = "org", cascade = CascadeType.ALL)
    private List<Filial> filials = new ArrayList<>();
    public Org() {
    }


    public Org(String name) {
        this.name = name;
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

    public List<Filial> getFilials() {
        return filials;
    }

    public void setFilials(List<Filial> filials) {
        this.filials = filials;
    }
}
