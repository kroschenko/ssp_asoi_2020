package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	String name = "Брест";
    ArrayList <String> streets = new ArrayList<>();
    streets.add("Улица В.И. Ленина");
    streets.add("Улица Московская");
    ArrayList <String> sqares = new ArrayList<>();
    sqares.add("Площадь Ленина");
    ArrayList <String> avenues = new ArrayList<>();
    avenues.add("Проспект Машерова");
    avenues.add("Партизанский проспект");
    City.Comunicate comunicate = new City.Comunicate();
    comunicate.setStreets(streets);
    comunicate.setAvenues(avenues);
    comunicate.setSqares(sqares);
    comunicate.addStreet("Улица Янки Купалы");
    comunicate.addAvenue("Проспект Республики");
    comunicate.addSqare("Площадь Свободы");

    City city = new City(name,comunicate);
    city.printinfo();
    }
}
