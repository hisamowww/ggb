package com.example.ggb.entyties;

import jakarta.persistence.*;

@Entity
public class ContragentObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "mestorog_id", nullable = false)
    private Mestorog mestorog;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @Column(name = "objectZavod")
    private String objectZavod;

    @Column(name = "objectMarka")
    private String objectMarka;

    @Column(name = "objectYear")
    private String objectYear;

/*    @Column(name = "objectFond")
    private Set<Fond> objectFond;*/

/*    @Column(name = "objectGroup")
    private ObjectGroup objectGroup;

    @Column(name = "ukpg")
    private Ukpg ukpg;

*/

    public ContragentObject() {
    }

    public ContragentObject(Long id, String name, String number, Mestorog mestorog, Contragent contragent, String objectZavod, String objectMarka, String objectYear) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.mestorog = mestorog;
        this.contragent = contragent;
        this.objectZavod = objectZavod;
        this.objectMarka = objectMarka;
        this.objectYear = objectYear;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Mestorog getMestorog() {
        return mestorog;
    }

    public void setMestorog(Mestorog mestorog) {
        this.mestorog = mestorog;
    }

    public Contragent getContragent() {
        return contragent;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public String getObjectZavod() {
        return objectZavod;
    }

    public void setObjectZavod(String objectZavod) {
        this.objectZavod = objectZavod;
    }

    public String getObjectMarka() {
        return objectMarka;
    }

    public void setObjectMarka(String objectMarka) {
        this.objectMarka = objectMarka;
    }

    public String getObjectYear() {
        return objectYear;
    }

    public void setObjectYear(String objectYear) {
        this.objectYear = objectYear;
    }
}
