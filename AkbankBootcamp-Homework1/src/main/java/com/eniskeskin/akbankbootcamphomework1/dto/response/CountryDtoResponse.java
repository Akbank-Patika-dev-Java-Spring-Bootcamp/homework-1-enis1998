package com.eniskeskin.akbankbootcamphomework1.dto.response;

public class CountryDtoResponse {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String president;
    public void setName(String name) {
        this.name = name;
    }
    public void setPresident(String president) {
        this.name = president;
    }
    public String getName() {
        return name;
    }
    public String getPresident() {
        return president;
    }
}
