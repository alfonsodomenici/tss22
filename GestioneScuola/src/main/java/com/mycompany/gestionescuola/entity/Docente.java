/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionescuola.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */

@Entity
@Table(name = "t_docenti")
public class Docente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docenti")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_anagrafica")
    private Anagrafica anagrafica;

    @ManyToOne
    @JoinColumn(name = "id_corso")    
    private Corso corso;
    
    @Column(name = "costo_orario", precision = 5, scale = 2)
    private BigDecimal costo;
    
    @Column(name = "ore_docenza")
    private Short ore;
    
    /*
    getter setter
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Anagrafica getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(Anagrafica anagrafica) {
        this.anagrafica = anagrafica;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Short getOre() {
        return ore;
    }

    public void setOre(Short ore) {
        this.ore = ore;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Docente other = (Docente) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Docente{" + "id=" + id + ", anagrafica=" + anagrafica + ", corso=" + corso + ", costo=" + costo + ", ore=" + ore + '}';
    }
    
    
}
