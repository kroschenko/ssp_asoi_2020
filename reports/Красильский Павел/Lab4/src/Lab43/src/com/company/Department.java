package com.company;

import java.util.ArrayList;

class Department {
    public ArrayList<Driver> drivers;
    public ArrayList<Car> cars;
    public ArrayList<Dispatcher> dispatchers;

    public Department(ArrayList<Driver> drivers, ArrayList<Car> cars, ArrayList<Dispatcher> dispatchers) {
        this.drivers = drivers;
        this.cars = cars;
        this.dispatchers = dispatchers;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void addDispatcher(Dispatcher dispatcher) {
        dispatchers.add(dispatcher);
    }

    public void removeDispatcher(Dispatcher dispatcher) {
        dispatchers.remove(dispatcher);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }
}

class Request {
    public String startPoint;
    public String endPoint;

    public enum Status {During,Finished, Rejected}

    public Status CurrentStatus;

    public Request(String startPoint, String endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        CurrentStatus = Status.During;
    }

    public void completeOrder() {
        CurrentStatus = Status.Finished;
        if (startPoint.toLowerCase().equals("ремонт"))
            System.out.println(startPoint + " - " + endPoint + " завершён");
        else
            System.out.println("Заказ: " + startPoint + " - " + endPoint + " Выполнен");
    }

    public void rejectedOrder() {
        CurrentStatus = Status.Rejected;
        System.out.println("Заказ: " + startPoint + " - " + endPoint + " отменён");
    }

    public Status getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        CurrentStatus = currentStatus;
    }

}

class Car {
        String model;
        String number;
        String state;

    public Car(String model, String number, String state) {
        this.model = model;
        this.number = number;
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
