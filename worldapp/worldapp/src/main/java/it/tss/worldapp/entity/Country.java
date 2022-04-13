/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.worldapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    @NotBlank
    @Column(length = 3, name = "Code")
    private String code;

    @NotEmpty
    @Column(name = "Name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "Continent", nullable = false)
    private Continent continent;
    @NotEmpty
    @Column(name = "Region", nullable = false)
    private String region;
    @NotNull
    @Column(name = "SurfaceArea", nullable = false)
    private BigDecimal surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;
    @NotNull
    @Column(name = "Population", nullable = false)
    private int population;
    @Column(name = "LifeExpectancy")
    private BigDecimal lifeExpectancy;
    @Column(name = "GNP")
    private BigDecimal gnp;
    @Column(name = "GNPOld")
    private BigDecimal gNPOld;
    @NotEmpty
    @Column(name = "LocalName", nullable = false)
    private String localName;
    @NotEmpty
    @Column(name = "GovernmentForm", nullable = false)
    private String governmentForm;
    @Column(name = "HeadOfState")
    private String headOfState;
    @Column(name = "Capital")
    private Integer capital;
    @Basic(optional = false)
    @Column(name = "Code2")
    private String code2;

    public JsonObject toJsonSlice() {
        return Json.createObjectBuilder()
                .add("code", code)
                .add("name", name)
                .build();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public BigDecimal getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(BigDecimal lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public BigDecimal getGnp() {
        return gnp;
    }

    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    public BigDecimal getgNPOld() {
        return gNPOld;
    }

    public void setgNPOld(BigDecimal gNPOld) {
        this.gNPOld = gNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.code);
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
        final Country other = (Country) obj;
        return Objects.equals(this.code, other.code);
    }

}
