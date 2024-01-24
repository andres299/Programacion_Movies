package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    int countryId;

    @Column(name = "country_iso_code")
    String countryIsoCode;
    @Column(name = "country_name")
    String countryName;
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    Set<Production_Country> productionCountries;

    public Country() {
    }

    public Country(String countryIsoCode, String countryName) {
        this.countryIsoCode = countryIsoCode;
        this.countryName = countryName;
    }

    public Country(int countryId, String countryIsoCode, String countryName) {
        this.countryId = countryId;
        this.countryIsoCode = countryIsoCode;
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Production_Country> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(Set<Production_Country> productionCountries) {
        this.productionCountries = productionCountries;
    }
}
