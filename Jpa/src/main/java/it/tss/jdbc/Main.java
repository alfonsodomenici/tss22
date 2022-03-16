/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jdbc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbscuola");
        EntityManager em = emf.createEntityManager();
          /*
        em.createQuery("select e from Corso e", Corso.class)
                .getResultList()
                .forEach(System.out::println);

      
        Corso tosave = new Corso();
        tosave.setTitolo("jakarta EE edizione 4");
        tosave.setInizio(LocalDate.now());
        tosave.setCosto(BigDecimal.valueOf(120,50));
        tosave.setDurata(120);
        tosave.setDescrizione("applicazioni web con jakarta EE");
        tosave.setCreatoIl(LocalDateTime.now());
       
        
        em.createQuery("select e from Iscrizione e order by e.il DESC", Iscrizione.class)
                .getResultList()
                .forEach(System.out::println);
         */
        em.createNamedQuery(Iscrizione.FIND_BY_CORSO, Iscrizione.class)
                .setParameter("titolo", "%db%")
                .getResultStream()
                .map(v -> v.getAnagrafica())
                .forEach(System.out::println);
        
        em.createQuery("select e from Docente e order by e.anagrafica.cognome", Docente.class)
                .getResultList()
                .forEach(System.out::println);
        
        em.createNamedQuery(Corso.VIEW_CORSI_OK,VCorsoOk.class)
                .getResultList()
                .forEach(System.out::println);
    }
}
