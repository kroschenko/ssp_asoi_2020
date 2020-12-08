package com.company;

import java.util.ArrayList;

public class Railway {
     String fin_destination;
     String departure_date;
     ArrayList<String> stations;
     ArrayList<Double> stationsTime;

    public Railway(String fin_destination, String departure_date, ArrayList<String> stations, ArrayList<Double> stationsTime) {
        this.fin_destination = fin_destination;
        this.departure_date = departure_date;
        this.stations = stations;
        this.stationsTime = stationsTime;
    }
}
