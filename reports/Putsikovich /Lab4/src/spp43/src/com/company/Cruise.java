package com.company;

public class Cruise {

    private Brigade brigade;
    private Plane plane;
    private Aeroport originalAeroport;
    private Aeroport destinationAeroport;
    private int status; //0 - готовится, 1 - в полете, 2 - отменен, 3 - завершен

    public void show(){
        System.out.println("Рейс: ");
        System.out.println("Бригада: ");
        brigade.show();
        System.out.println("Самолет: ");
        plane.show();
        System.out.println("Аэропорт отлета: ");
        originalAeroport.show();
        System.out.println("Аэропорт назначения: ");
        destinationAeroport.show();
        System.out.print("Статус: ");

        if(status==0)
            System.out.println("готовится к вылету");
        else if(status==1)
            System.out.println("в полете");
        else if(status==2)
            System.out.println("отменен");
        else if(status==3)
            System.out.println("завершен");
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Aeroport getOriginalAeroport() {
        return originalAeroport;
    }

    public void setOriginalAeroport(Aeroport originalAeroport) {
        this.originalAeroport = originalAeroport;
    }

    public Aeroport getDestinationAeroport() {
        return destinationAeroport;
    }

    public void setDestinationAeroport(Aeroport destinationAeroport) {
        this.destinationAeroport = destinationAeroport;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Cruise(Brigade brigade, Plane plane, Aeroport originalAeroport, Aeroport destinationAeroport) {
        this.brigade = brigade;
        this.plane = plane;
        this.originalAeroport = originalAeroport;
        this.destinationAeroport = destinationAeroport;
        this.status=0;
    }
}
