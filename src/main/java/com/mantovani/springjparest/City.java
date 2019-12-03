package com.mantovani.springjparest;

import javax.persistence.*;

@Entity
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Country country;

    public City(){}

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}