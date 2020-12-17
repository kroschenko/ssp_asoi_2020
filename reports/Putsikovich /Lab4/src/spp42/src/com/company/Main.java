package com.company;

import java.util.ArrayList;

class Planet{
    String name;
    int size;
    String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Planet(String name, int size, String color){
        this.name = name;
        this.size = size;
        this.color = color;
    }

    public void show(){
        System.out.println("Планета "+name+", цвет: "+color+", размер: "+size);
    }
}

class Star{
    int size;
    int age;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Star(int size, int age){
        this.size = size;
        this.age = age;
    }

    public void show(){
        System.out.println("Звезда размером "+size+" и возрастом "+age);
    }
}

class StarSystem{
    ArrayList<Planet> planets;
    ArrayList<Star> stars;

    public StarSystem(){
        planets = new ArrayList<Planet>();
        stars = new ArrayList<Star>();
    }

    public void addPlanet(String name, int size, String color){
        planets.add(new Planet(name, size, color));
    }

    public void addStar(int size, int age){
        stars.add(new Star(size, age));
    }

    public void removePlanets(){
        planets.clear();
    }

    public void removeStars(){
        stars.clear();
    }

    public void show(){
        System.out.println("Состав звёздной системы:");
        if(planets.size()==0&&stars.size()==0)
            System.out.println("пусто");
        else
        {
            for(int i=0; i<planets.size(); i++)
                planets.get(i).show();
            for(int i=0; i<stars.size(); i++)
                stars.get(i).show();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        StarSystem system = new StarSystem();

        system.addPlanet("Меркурий", 250000, "оранжевый");
        system.removePlanets();
        system.show();

        system.addPlanet("Венера", 400000, "красный");
        system.addPlanet("Сатурн", 735002, "серебристый");

        system.addStar(500, 1000000);
        system.addStar(350, 780000);
        system.addStar(800, 5450000);

        system.show();

    }
}
