package ui;

import helpers.KonzolniAlat;
import models.Faktura;
import models.Klijent;
import models.Proizvod;
import models.Store;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

public class Izbornik {
    private static final String PERSISTANCE_UNIT_NAME = "MojaOznaka1";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);

    public static void m_izbornik(){
        int unos;
        do {
            System.out.println("IZBORNIK:");
            System.out.print("1. NEW STORE\n");
            System.out.print("2. DODAJ: KLIJENTA\n");
            System.out.print("3. DODAJ: PROIZVOD\n");
            System.out.print("4. DODAJ: PRODAJA (FAKTURA)\n");
            System.out.print("5. Prikaz faktura\n");
            System.out.print("6. Dodaj testne podatke i testiraj\n");
            System.out.print("0. EXIT\n");
            unos = KonzolniAlat.ucitajInteger();

            switch (unos) {
                case 1:  m_store_new();
                    break;
                case 2:  m_klijent_add();
                    break;
                case 3:  m_proizvod_add();
                    break;
                case 4:  m_prodaja_add();
                    break;
                case 5:  m_prikaz_faktura();
                    break;
                case 6:  m_test_app();
                    break;
            }

        } while(unos!=0);
    }

    private static void m_store_new(){
        EntityManager em = factory.createEntityManager();

        Store s = new Store();
        System.out.println("Unesite naziv firme:");
        s.setNaziv(KonzolniAlat.ucitajString());

        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    private static void m_test_app() {
    }

    private static void m_proizvod_add() {
        EntityManager em = factory.createEntityManager();

        Proizvod p = new Proizvod();
        System.out.println("Unesite naziv proizvoda:");
        p.setNaziv(KonzolniAlat.ucitajString());

        System.out.println("Unesite cijenu proizvoda:");
        p.setCijena(KonzolniAlat.ucitajInteger());

        System.out.println("Unesite JMJ:");
        p.setJMJ(KonzolniAlat.ucitajString());

        em.getTransaction().begin();
        em.persist(p);

        int dodaj_firmi = 1;
        do{
            System.out.println("Želite dodati proizvod u firmu? (1 = DA)");
            dodaj_firmi = KonzolniAlat.ucitajInteger();
            if (dodaj_firmi == 1){
                Query q = em.createQuery("select s from Store s");
                List<Store> stores = q.getResultList();
                for (Store s : stores) {
                    System.out.println("["+s.getStore_id()+"]: " + s.getNaziv());
                }
                System.out.println("Izaberite firmu (rbr):");
                int store_id = KonzolniAlat.ucitajInteger();
                Store store_za_dodati = null;
                for (Store s : stores){
                    if(s.getStore_id() == store_id){
                        store_za_dodati = em.find(Store.class, store_id);
                    }
                }

                if (store_za_dodati != null){
                    store_za_dodati.getProizvodi().add(p);

                    em.persist(store_za_dodati);

                    System.out.println("Uspješno ste dodali proizvod u firmu!");
                } else {
                    System.out.println("Došlo je do greške!");
                }
            }

        } while (dodaj_firmi == 1);
        em.getTransaction().commit();
        em.close();
    }

    private static void m_prodaja_add() {
        EntityManager em = factory.createEntityManager();

        Faktura f = new Faktura();

        System.out.println("Unesite datum fakture:");

        int y,m,d;

        System.out.println("Godina:");
        y = KonzolniAlat.ucitajInteger();

        System.out.println("Mjesec:");
        m = KonzolniAlat.ucitajInteger();

        System.out.println("Dan:");
        d = KonzolniAlat.ucitajInteger();

        f.setDatum(LocalDate.of(y, m, d));

        System.out.println("Unesite broj fakture:");
        f.setBrojFakture(KonzolniAlat.ucitajInteger());

        System.out.println("Izaberite klijenta (rbr):");

        Query qk = em.createQuery("select s from Klijent s");
        List<Klijent> klijenti = qk.getResultList();
        for (Klijent k : klijenti) {
            System.out.println("["+k.getKlijent_id()+"]: " + k.getInfo());
        }
        int klijent_id = KonzolniAlat.ucitajInteger();
        Klijent klijent = em.find(Klijent.class, klijent_id);
        f.setKlijent(klijent);

        Query qs = em.createQuery("select s from Store s");
        List<Store> stores = qs.getResultList();
        for (Store s : stores) {
            System.out.println("["+s.getStore_id()+"]: " + s.getNaziv());
        }
        int store_id = KonzolniAlat.ucitajInteger();
        Store store = em.find(Store.class, store_id);
        f.setStore(store);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();

        System.out.println("Dodali ste fakturu!");
    }


    private static void m_prikaz_faktura() {
        EntityManager em = factory.createEntityManager();

        System.out.println("Fakture:");

        Query q = em.createQuery("select s from Faktura s");
        List<Faktura> fakture = q.getResultList();
        for (Faktura x : fakture) {
            x.infoIspis();
        }
        
    }

    private static void m_klijent_add() {
        EntityManager em = factory.createEntityManager();

        Klijent s = new Klijent();
        System.out.println("Unesite ime klijenta:");
        s.setIme(KonzolniAlat.ucitajString());

        System.out.println("Unesite prezime klijenta:");
        s.setPrezime(KonzolniAlat.ucitajString());

        System.out.println("Unesite adresu klijenta:");
        s.setAdresa(KonzolniAlat.ucitajString());


        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }
}
