package com.example.ggb.entyties;

import jakarta.persistence.*;

@Entity
public class Dogovor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberFilial;

    private String numberAdm;

    private String numberContragent;

    private String dateDogovor;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contragent_id", nullable = false)
    private Contragent contragent;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "org_id", nullable = false)
    private Org org;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "filial_id", nullable = false)
    private Filial filial;

    private String typeWork;

    public Dogovor() {
    }

    public Dogovor(Long id, String numberFilial, String numberAdm, String numberContragent, String dateDogovor, Contragent contragent, Org org, Filial filial, String typeWork) {
        this.id = id;
        this.numberFilial = numberFilial;
        this.numberAdm = numberAdm;
        this.numberContragent = numberContragent;
        this.dateDogovor = dateDogovor;
        this.contragent = contragent;
        this.org = org;
        this.filial = filial;
        this.typeWork = typeWork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberFilial() {
        return numberFilial;
    }

    public void setNumberFilial(String numberFilial) {
        this.numberFilial = numberFilial;
    }

    public String getNumberAdm() {
        return numberAdm;
    }

    public void setNumberAdm(String numberAdm) {
        this.numberAdm = numberAdm;
    }

    public String getNumberContragent() {
        return numberContragent;
    }

    public void setNumberContragent(String numberContragent) {
        this.numberContragent = numberContragent;
    }

    public String getDateDogovor() {
        return dateDogovor;
    }

    public void setDateDogovor(String dateDogovor) {
        this.dateDogovor = dateDogovor;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
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

    public String getTypeWork() {
        return typeWork;
    }

    public void setTypeWork(String typeWork) {
        this.typeWork = typeWork;
    }
}
