package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int country_id;
    String country_iso_code;
    @Column(name = "country_name")
    String countryName;
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    Set<Production_Country> productionCountries;

    public Country() {
    }

    public Country(String country_iso_code, String countryName) {
        this.country_iso_code = country_iso_code;
        this.countryName = countryName;
    }

    public Country(int country_id, String country_iso_code, String countryName) {
        this.country_id = country_id;
        this.country_iso_code = country_iso_code;
        this.countryName = countryName;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_iso_code() {
        return country_iso_code;
    }

    public void setCountry_iso_code(String country_iso_code) {
        this.country_iso_code = country_iso_code;
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
