package com.example.ggb.entyties;

import jakarta.persistence.*;

@Entity
public class Sotrud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "org_id", nullable = false)
    private Org org;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "podrazd_id", nullable = false)
    private Podrazd podrazd;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;


    public Sotrud() {
    }

    public Sotrud(Long id, String firstName, String secondName, String lastName, String email, Org org, Filial filial, Podrazd podrazd, Post post) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.email = email;
        this.org = org;
        this.filial = filial;
        this.podrazd = podrazd;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Podrazd getPodrazd() {
        return podrazd;
    }

    public void setPodrazd(Podrazd podrazd) {
        this.podrazd = podrazd;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
