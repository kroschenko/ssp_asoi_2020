package com.company;

import java.util.ArrayList;

public class City {
    String name;
    Comunicate comunicate = new Comunicate();
    static class Comunicate {
        ArrayList <String> sqares;
        ArrayList <String> avenues;
        ArrayList <String> streets;

        public ArrayList<String> getSqares() {
            return sqares;
        }

        public void addSqare(String value) {
            sqares.add(value);
        }

        public void setSqares(ArrayList<String> sqares) {
            this.sqares = sqares;
        }

        public ArrayList<String> getAvenues() {
            return avenues;
        }

        public void addAvenue(String value) {
            avenues.add(value);
        }

        public void setAvenues(ArrayList<String> avenues) {
            this.avenues = avenues;
        }

        public ArrayList<String> getStreets() {
            return streets;
        }

        public void addStreet(String value) {
            streets.add(value);
        }

        public void setStreets(ArrayList<String> streets) {
            this.streets = streets;
        }
    }

    public City(String name, Comunicate comunicate) {
        this.name = name;
        this.comunicate = comunicate;
    }

    public void printinfo(){
        System.out.println("Город: "+ name);
        System.out.println("В нём есть такие площади как:" + comunicate.getSqares());
        System.out.println("В нём есть такие улицы как:" + comunicate.getStreets());
        System.out.println("В нём есть такие проспекты как:" + comunicate.getAvenues());
    }
}
