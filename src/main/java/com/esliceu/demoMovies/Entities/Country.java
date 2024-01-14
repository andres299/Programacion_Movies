package com.esliceu.demoMovies.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;

    private String countryIsoCode;
    private String countryName;

    @OneToMany(mappedBy = "country")
    private Set<Production_Country> productionCountries;

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
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
