package com.company;

public class Plane {
    private Chassis chassis;
    private int capacity;
    private int flightRange;

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public Plane(Chassis chassis, int capacity, int flightRange) {
        this.chassis = chassis;
        this.capacity = capacity;
        this.flightRange = flightRange;
    }

    public void show(){
        chassis.show();
        System.out.println("capacity: "+capacity);
        System.out.println("flightRange: "+flightRange);
    }
}
