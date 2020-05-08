package com.example.treinamento.model;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("Country")
    private String name;

    @SerializedName("Slug")
    private String slug;

    @SerializedName("ISO2")
    private String iso2;

    public Country(String name, String slug, String iso2){
        this.setName(name);
        this.setSlug(slug);
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
