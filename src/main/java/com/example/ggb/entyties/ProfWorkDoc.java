package com.example.ggb.entyties;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProfWorkDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contragent_id", nullable = false)
    private Contragent contragent;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contragentObject_id", nullable = false)
    private ContragentObject contragentObject;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dogovor_id", nullable = false)
    private Dogovor dogovor;

    private String date;

    private String number;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "sotrud_id", nullable = false)
    private Sotrud sotrud;

    public ProfWorkDoc() {
    }

    public ProfWorkDoc(Long id, Work work, Contragent contragent, String date, Dogovor dogovor, Sotrud sotrud, String number, ContragentObject contragentObject) {
        this.id = id;
        this.work = work;
        this.contragent = contragent;
        this.date = date;
        this.number = number;
        this.contragentObject = contragentObject;
        this.dogovor = dogovor;
        this.sotrud = sotrud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContragentObject getContragentObject() {
        return contragentObject;
    }

    public void setContragentObject(ContragentObject contragentObject) {
        this.contragentObject = contragentObject;
    }

    public Dogovor getDogovor() {
        return dogovor;
    }

    public void setDogovor(Dogovor dogovor) {
        this.dogovor = dogovor;
    }

    public Sotrud getSotrud() {
        return sotrud;
    }

    public void setSotrud(Sotrud sotrud) {
        this.sotrud = sotrud;
    }
}
