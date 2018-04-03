package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Klijent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer klijent_id;

    @Column(nullable = false, length = 50)
    private String ime;

    @Column(nullable = false, length = 50)
    private String prezime;

    @Column(nullable = true, length = 100)
    private String adresa;

    @OneToMany(mappedBy = "klijent")
    @Cascade(CascadeType.ALL)
    private List<Faktura> fakture;

    public Integer getKlijent_id() {
        return klijent_id;
    }

    public void setKlijent_id(Integer klijent_id) {
        this.klijent_id = klijent_id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getInfo(){
        return ime + " " + prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Faktura> getFakture() {
        return fakture;
    }

    public void setFakture(List<Faktura> fakture) {
        this.fakture = fakture;
    }
}
