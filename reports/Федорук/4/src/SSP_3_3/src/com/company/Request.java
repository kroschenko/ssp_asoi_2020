package com.company;

public class Request {
    String departure_date;
    String departure_point;
    double departure_time;
    String final_destination;

    public Request(String departure_date, String departure_point, double departure_time, String final_destination) {
        this.departure_date = departure_date;
        this.departure_point = departure_point;
        this.departure_time = departure_time;
        this.final_destination = final_destination;
    }
}
