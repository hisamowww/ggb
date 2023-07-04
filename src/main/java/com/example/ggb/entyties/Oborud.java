package com.example.ggb.entyties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Oborud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "shifr")
    private String shifr;
    @Column(name = "number")
    private String number;
    @Column(name = "komplect")
    private String komplect;
    @Column(name = "zavodNumb")
    private String zavodNumb;
    @Column(name = "dateFirst")
    private String dateFirst;
    @Column(name = "srok")
    private String srok;
    @Column(name = "passport")
    private String passport;

    public Oborud() {
    }

    public Oborud(Long id, String name, String shifr, String number, String komplect, String zavodNumb, String dateFirst, String srok, String passport) {
        this.id = id;
        this.name = name;
        this.shifr = shifr;
        this.number = number;
        this.komplect = komplect;
        this.zavodNumb = zavodNumb;
        this.dateFirst = dateFirst;
        this.srok = srok;
        this.passport = passport;
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

    public String getShifr() {
        return shifr;
    }

    public void setShifr(String shifr) {
        this.shifr = shifr;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKomplect() {
        return komplect;
    }

    public void setKomplect(String komplect) {
        this.komplect = komplect;
    }

    public String getZavodNumb() {
        return zavodNumb;
    }

    public void setZavodNumb(String zavodNumb) {
        this.zavodNumb = zavodNumb;
    }

    public String getDateFirst() {
        return dateFirst;
    }

    public void setDateFirst(String dateFirst) {
        this.dateFirst = dateFirst;
    }

    public String getSrok() {
        return srok;
    }

    public void setSrok(String srok) {
        this.srok = srok;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
