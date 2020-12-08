package com.company;

public class Bus {
    private String driverFIO;
    private String number;
    private int route;
    private String producer;
    private int year;
    private int mileage;
    private int locationCode; //0 - парк, 1 - маршрут

    public String getDriverFIO() {
        return driverFIO;
    }

    public void setDriverFIO(String driverFIO) {
        this.driverFIO = driverFIO;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    public String toString(){
        String location = null;
        if(locationCode==0)
            location = "в парке";
        else if(locationCode==1)
            location = "на маршруте";

        return driverFIO+", "+number+", "+route+", "+producer+", "+year+", "+mileage+","+location;
    }
}
