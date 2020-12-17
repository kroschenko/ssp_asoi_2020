package com.company;

public class Aeroport {
    private String country;
    private String name;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("country: "+country);
        System.out.println("name: "+name);
    }

    public Aeroport(String country, String name) {
        this.country = country;
        this.name = name;
    }
}
