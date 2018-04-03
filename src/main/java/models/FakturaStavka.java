package models;

import javax.persistence.*;

@Entity
public class FakturaStavka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fs_id;

    @Column(nullable = false)
    private Integer kolicina;

    @ManyToOne
    @JoinColumn(name = "faktura_id")
    private Faktura faktura;

    @ManyToOne
    @JoinColumn(name = "proizvod_id")
    private Proizvod proizvod;

    public Integer getFs_id() {
        return fs_id;
    }

    public void setFs_id(Integer fs_id) {
        this.fs_id = fs_id;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
