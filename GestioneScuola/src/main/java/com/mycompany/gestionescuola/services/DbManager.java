/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */

/*
singleton class
 */
public class DbManager {

    private static DbManager instance;

    private EntityManager em;

    private DbManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbscuola");
        this.em = emf.createEntityManager();
    }

    public static DbManager getInstance() {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }

    public EntityManager getEM(){
        return this.em;
    }
}
