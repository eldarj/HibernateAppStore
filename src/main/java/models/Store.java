package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer store_id;

    @Column(nullable = false, length = 100)
    private String naziv;

    @OneToMany(mappedBy = "store")
    @Cascade(CascadeType.ALL)
    private List<Faktura> fakture = new ArrayList<Faktura>();

    @ManyToMany(cascade = {javax.persistence.CascadeType.ALL})
    @JoinTable(
            name = "Store_Proizvod",
            joinColumns = {@JoinColumn(name = "store_id")},
            inverseJoinColumns = { @JoinColumn(name = "proizvod_id")}
    )
    private List<Proizvod> proizvodi;

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Faktura> getFakture() {
        return fakture;
    }

    public void setFakture(List<Faktura> fakture) {
        this.fakture = fakture;
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }
}
