package com.example.treinamento.model;

public class Country {

    private String name;

    private String slug;

    private String iso2;

    public Country(String name, String iso2){
        this.setName(name);
        this.setIso2(iso2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
}
