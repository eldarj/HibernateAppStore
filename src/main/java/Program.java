import models.*;
import ui.Izbornik;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Program {
    public static void main(String[] args){

        System.out.println("##############################\n##### AppStore::Zadatak3 #####\n##############################");
        Izbornik.m_izbornik();

        /*EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MojaOznaka1");

        EntityManager em = emf.createEntityManager();*/

        /*// Ubacivanje OneToMany
        Store s1 = em.find(Store.class, 7);
        Klijent k1 = em.find(Klijent.class, 1);
        Faktura f = new Faktura();
        f.setBrojFakture(321);
        f.setDatum(LocalDate.now(ZoneId.systemDefault()));
        f.setKlijent(k1);

        f.setStore(s1);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();*/

        /*
        // Ubacivanje ManyToOne
        Store s1 = em.find(Store.class, 7);
        Klijent k1 = em.find(Klijent.class, 1);

        Faktura f = new Faktura();
        f.setBrojFakture(123);
        f.setDatum(LocalDate.now(ZoneId.systemDefault()));
        f.setStore(s1);
        f.setKlijent(k1);

        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();*/

        // Ubacivanje ManyToMany
        /*Store s1 = em.find(Store.class, 7);

        Proizvod novi = new Proizvod();
        novi.setNaziv("Drina 18");
        novi.setCijena(4);

        s1.getProizvodi().add(novi);

        em.getTransaction().begin();
        em.persist(s1);
        em.getTransaction().commit();*/

       /* List<Klijent> resultList = em.createQuery("select x from Klijent x", Klijent.class).getResultList();

        for (Klijent x : resultList){
            System.out.println("x: " + x.getIme());
        }*/

        //em.close();  //zatvara se konekcija
    }
}
