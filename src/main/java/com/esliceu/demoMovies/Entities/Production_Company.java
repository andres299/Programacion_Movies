package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Production_Company {

    @Id
    private int company_id;

    private String companyName;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private Set<Movie_Company> movieCompanies;

    public Production_Company() {
    }

    public Production_Company(int company_id, String companyName) {
        this.company_id = company_id;
        this.companyName = companyName;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Movie_Company> getMovieCompanies() {
        return movieCompanies;
    }

    public void setMovieCompanies(Set<Movie_Company> movieCompanies) {
        this.movieCompanies = movieCompanies;
    }
}