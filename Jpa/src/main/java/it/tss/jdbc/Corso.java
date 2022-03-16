/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jdbc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "v_corso_ok",
            classes = {
                @ConstructorResult(targetClass = it.tss.jdbc.VCorsoOk.class,
                        columns = {
                            @ColumnResult(name = "titolo_corso", type = String.class),
                            @ColumnResult(name = "id_corso", type = Long.class),
                            @ColumnResult(name = "descrizione_corso", type = String.class),
                            @ColumnResult(name = "data_inizio", type = LocalDate.class),
                            @ColumnResult(name = "durata_corso", type = Integer.class),
                            @ColumnResult(name = "data_creazione", type = LocalDateTime.class),
                            @ColumnResult(name = "costo_corso", type = BigDecimal.class),
                            @ColumnResult(name = "costo_scontato", type = BigDecimal.class),})
            })
})

@NamedNativeQueries({
    @NamedNativeQuery(name = Corso.VIEW_CORSI_OK,
            query = "select * from v_corsi_ok",
            resultSetMapping = "v_corso_ok")
})
@Entity
@Table(name = "t_corsi")
public class Corso implements Serializable {

    public static final String VIEW_CORSI_OK = "Corso.viewCorsiOk";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corso")
    private Long id;

    @Column(name = "titolo_corso")
    private String titolo;

    @Column(name = "descrizione_corso")
    private String descrizione;

    @Column(name = "data_inizio")
    private LocalDate inizio;

    @Column(name = "durata_corso")
    private Integer durata;

    @Column(name = "costo_corso", precision = 6, scale = 2)
    private BigDecimal costo;

    @Column(name = "data_creazione")
    private LocalDateTime creatoIl;

    /*
    getter setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public LocalDateTime getCreatoIl() {
        return creatoIl;
    }

    public void setCreatoIl(LocalDateTime creatoIl) {
        this.creatoIl = creatoIl;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Corso other = (Corso) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Corso{" + "id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", inizio=" + inizio + ", durata=" + durata + ", costo=" + costo + ", creatoIl=" + creatoIl + '}';
    }

}
