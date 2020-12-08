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

    String name1 = "Грондо";
    ArrayList <String> streets1 = new ArrayList<>();
    streets1.add("Улица Дзержинского");
    streets1.add("Улица Суворова");
    ArrayList <String> sqares1 = new ArrayList<>();
    sqares1.add("Площадь Ленина");
    sqares1.add("Площадь Советская");
    ArrayList <String> avenues1 = new ArrayList<>();
    avenues1.add("Проспект Строителей");
    avenues1.add("Проспект Космонавтов");
    City.Comunicate comunicate1 = new City.Comunicate();
    comunicate1.setStreets(streets1);
    comunicate1.setAvenues(avenues1);
    comunicate1.setSqares(sqares1);
    comunicate1.addStreet("Улица Наполеона Орды");
    comunicate1.addAvenue("Проспект Янки Купалы");
    comunicate1.addSqare("Площадь Декабристов");

    City city = new City(name, comunicate);
    city.printinfo();
    City city1 = new City(name1,comunicate1);
    city1.printinfo();
    }
}
