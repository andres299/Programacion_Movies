package com.esliceu.demoMovies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Production_Company {

    @Id
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private Set<Movie_Company> movieCompanies;

    public Production_Company() {
    }

    public Production_Company(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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