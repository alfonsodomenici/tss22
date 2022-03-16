/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.services;

import com.mycompany.gestionescuola.entity.Anagrafica;
import com.mycompany.gestionescuola.entity.Provincia;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author tss
 */
public class AnagraficaService {

    private EntityManager em;

    public AnagraficaService() {
        this.em = DbManager.getInstance().getEM();
    }

    public List<Anagrafica> all() {
        return em.createQuery("select e from Anagrafica e order by e.cognome")
                .getResultList();
    }

    public Anagrafica save(Anagrafica entity) {
        em.getTransaction().begin();
        Anagrafica saved = em.merge(entity);
        em.getTransaction().commit();
        return saved;
    }

    public void remove(Long id) {
        em.getTransaction().begin();
        em.remove(em.find(Anagrafica.class, id));
        em.getTransaction().commit();
    }

    public Anagrafica find(Long id) {
        return em.find(Anagrafica.class, id);
    }

    public Optional<Provincia> findProvinciaByName(String pv) {
        try {
            return Optional.of(em.createQuery("select e from Provincia e where e.pv like :pv", Provincia.class)
                    .setParameter("pv", pv)
                    .getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
