package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Faktura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer faktura_id;

    @Column(nullable = false)
    private Integer brojFakture;

    @Column(nullable = false)
    private LocalDate datum;

    @ManyToOne
    @JoinColumn(name = "klijent_id")
    private Klijent klijent;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "faktura")
    @Cascade(CascadeType.ALL)
    private List<FakturaStavka> stavke;

    public Integer getFaktura_id() {
        return faktura_id;
    }

    public void setFaktura_id(Integer faktura_id) {
        this.faktura_id = faktura_id;
    }

    public Integer getBrojFakture() {
        return brojFakture;
    }

    public void setBrojFakture(Integer brojFakture) {
        this.brojFakture = brojFakture;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public List<FakturaStavka> getStavke() {
        return stavke;
    }

    public void setStavke(List<FakturaStavka> stavke) {
        this.stavke = stavke;
    }

    public Store getStore() {
        return store;
    }

    public void infoIspis(){
        System.out.println(
                "[" + faktura_id + "] " +
                        " Datum: " + datum.format(DateTimeFormatter.ofPattern("dd LLLL yyyy")) +
                        " Br." + brojFakture +
                        " Klijent:" + klijent.getInfo() +
                        " Firma:" + store.getNaziv()
        );
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
