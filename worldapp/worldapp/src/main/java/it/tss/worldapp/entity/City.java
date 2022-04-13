/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.worldapp.entity;

import it.tss.worldapp.boundary.CountryTypeAdapter;
import java.io.Serializable;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name = City.FIND_BY_COUNTRY, 
            query = "SELECT e FROM City e INNER JOIN e.country c  WHERE c.name like :country")})


@Entity
@Table(name = "city")
public class City implements Serializable{

    public static final String FIND_BY_COUNTRY = "City.findByCountry";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @Column(name = "Name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "District", nullable = false)
    private String district;

    @NotNull
    @Column(name = "Population", nullable = false)
    private int population;
    
    @JsonbTypeAdapter(CountryTypeAdapter.class)
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "CountryCode")
    private Country country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final City other = (City) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
