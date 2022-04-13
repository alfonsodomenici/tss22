/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.world;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author tss
 */
@Embeddable
public class CountrylanguagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CountryCode")
    private String countryCode;
    @Basic(optional = false)
    @Column(name = "Language")
    private String language;

    public CountrylanguagePK() {
    }

    public CountrylanguagePK(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryCode != null ? countryCode.hashCode() : 0);
        hash += (language != null ? language.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountrylanguagePK)) {
            return false;
        }
        CountrylanguagePK other = (CountrylanguagePK) object;
        if ((this.countryCode == null && other.countryCode != null) || (this.countryCode != null && !this.countryCode.equals(other.countryCode))) {
            return false;
        }
        return !((this.language == null && other.language != null) || (this.language != null && !this.language.equals(other.language)));
    }

    @Override
    public String toString() {
        return "it.tss.world.CountrylanguagePK[ countryCode=" + countryCode + ", language=" + language + " ]";
    }
    
}
