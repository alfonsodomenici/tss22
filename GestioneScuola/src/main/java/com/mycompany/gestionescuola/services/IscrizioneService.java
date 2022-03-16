/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.services;

import com.mycompany.gestionescuola.entity.Anagrafica;
import com.mycompany.gestionescuola.entity.Corso;
import com.mycompany.gestionescuola.entity.Iscrizione;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class IscrizioneService {

    private EntityManager em;

    public IscrizioneService() {
        this.em = DbManager.getInstance().getEM();
    }

    public List<Anagrafica> findByCorso(Long id) {
        return em.createQuery("select e.anagrafica from Iscrizione e where e.corso.id= :corso_id",
                Anagrafica.class)
                .setParameter("corso_id", id)
                .getResultList();
    }

    public List<Corso> findByAnagrafica(Long id) {
        return em.createQuery("select e.corso from Iscrizione e where e.anagrafica.id= :anagrafica_id",
                Corso.class)
                .setParameter("anagrafica_id", id)
                .getResultList();
    }

    public Iscrizione save(Iscrizione entity) {
        em.getTransaction().begin();
        Iscrizione saved = em.merge(entity);
        em.getTransaction().commit();
        return saved;
    }
}
