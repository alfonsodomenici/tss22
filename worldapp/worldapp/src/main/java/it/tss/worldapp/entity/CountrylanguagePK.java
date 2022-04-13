/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.worldapp.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author tss
 */
@Embeddable
public class CountrylanguagePK implements Serializable {

    @JoinColumn(name = "CountryCode")
    @ManyToOne(optional = false)
    private Country country;
    @Basic(optional = false)
    @Column(name = "Language")
    private String language;

    public CountrylanguagePK() {
    }

    public CountrylanguagePK(Country country, String language) {
        this.country = country;
        this.language = language;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.country);
        hash = 79 * hash + Objects.hashCode(this.language);
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
        final CountrylanguagePK other = (CountrylanguagePK) obj;
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        return Objects.equals(this.country, other.country);
    }

    

}
