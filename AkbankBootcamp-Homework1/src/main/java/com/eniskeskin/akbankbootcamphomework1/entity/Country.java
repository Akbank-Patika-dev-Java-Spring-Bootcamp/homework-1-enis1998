package com.eniskeskin.akbankbootcamphomework1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String president;
    public void setName(String name) {
        this.name = name;
    }
    public void setPresident(String president) {
        this.name = president;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPresident() {
        return president;
    }


}
