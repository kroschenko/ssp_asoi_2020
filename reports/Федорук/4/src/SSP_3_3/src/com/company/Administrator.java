package com.company;

import java.util.ArrayList;

public class Administrator {
    ArrayList<Railway> railwaysList = new ArrayList<>();
    String data;
    String destination;
    ArrayList<String> stations;
    ArrayList<Double> stationsTime;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<String> getStations() {
        return stations;
    }

    public void setStations(ArrayList<String> stations) {
        this.stations = stations;
    }

    public ArrayList<Double> getStationsTime() {
        return stationsTime;
    }

    public void setStationsTime(ArrayList<Double> stationsTime) {
        this.stationsTime = stationsTime;
    }


    public void create_railway(){

        railwaysList.add(new Railway(destination,data,stations,stationsTime));
    }

    void printAvailableRailway(String date, String point) {
        int i = 0;
        for (Railway railway: railwaysList) {
            System.out.println(railway.departure_date);
            if(railway.departure_date==date) {
                if (railway.fin_destination == point) {
                    System.out.println("Поезд номер: " + i + ", Дата: " + railway.departure_date + ", Конечный пункт: " + railway.fin_destination + ", Список станций: " + railway.stations + ", Время прибытия на станции: " + railway.stationsTime);
                }
                else{
                    for (String stations: railway.stations) {
                        if(stations==point){
                            System.out.println("Поезд номер: " + i + ", Дата: " + railway.departure_date + ", Конечный пункт: " + railway.fin_destination + ", Список станций: " + railway.stations + ", Время прибытия на станции: " + railway.stationsTime);
                        }
                    }
                }
            }
            i++;
        }
    }
}
