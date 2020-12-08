package com.company;

import java.util.ArrayList;

public class Passenger {
    ArrayList<Request> requestsList = new ArrayList<>();
    String data;
    String point;
    double time;
    String destination;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void create_request(){
        requestsList.add(new Request(data,point,time,destination));
    }
    
    void printRequest() {
        int i = 0;
        for (Request requeste: requestsList) {
            System.out.println("Заявка номер: " + i + ", Дата: " + requeste.departure_date + ", Время: " + requeste.departure_time + ", Начальный пункт: " + requeste.departure_point + ", Пункт назначения: " + requeste.final_destination);
            i++;
        }
    }
}
