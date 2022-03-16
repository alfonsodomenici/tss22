/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author tss
 */
public class VCorsoOk {
    public String titolo;
    public Long id;
    public String descrizione;
    public LocalDate inizio;
    public Integer durata;
    public LocalDateTime creatoIl;
    public BigDecimal costo;
    public BigDecimal costoScontato;

    public VCorsoOk(String titolo, 
            Long id, 
            String descrizione, 
            LocalDate inizio, 
            Integer durata, 
            LocalDateTime creatoIl,
            BigDecimal costo, 
            BigDecimal costoScontato) {
        this.titolo = titolo;
        this.id = id;
        this.descrizione = descrizione;
        this.inizio = inizio;
        this.durata = durata;
        this.creatoIl = creatoIl;
        this.costo = costo;
        this.costoScontato = costoScontato;
    }

    @Override
    public String toString() {
        return "VCorsoOk{" + "titolo=" + titolo + ", id=" + id + ", descrizione=" + descrizione + ", inizio=" + inizio + ", durata=" + durata + ", creatoIl=" + creatoIl + ", costo=" + costo + ", costoScontato=" + costoScontato + '}';
    }
    
    
    
}
