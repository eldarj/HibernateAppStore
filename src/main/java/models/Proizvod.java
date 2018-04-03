package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Proizvod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer proizvod_id;

    @Column(nullable = false, length = 20)
    private String naziv;

    @Column(nullable = true, length = 10)
    private String JMJ;

    @Column(nullable = false)
    private Integer cijena;

    @ManyToMany(mappedBy = "proizvodi")
    private List<Store> stores;

    public Integer getProizvod_id() {
        return proizvod_id;
    }

    public void setProizvod_id(Integer proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getJMJ() {
        return JMJ;
    }

    public void setJMJ(String JMJ) {
        this.JMJ = JMJ;
    }

    public Integer getCijena() {
        return cijena;
    }

    public void setCijena(Integer cijena) {
        this.cijena = cijena;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
