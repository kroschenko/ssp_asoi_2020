package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        AeroSystem system = new AeroSystem();

        Administrator administrator = new Administrator(123, "Серый А.А.");

        Pilot pilot1 = new Pilot(12334, "Белый В.С.", administrator);
        Pilot pilot2 = new Pilot(13421, "Цветочкин А.М.", administrator);
        ArrayList<Pilot> pilots = new ArrayList<Pilot>();
        pilots.add(pilot1);
        pilots.add(pilot2);

        Navigator navigator = new Navigator(67, "Курочкин М.М.", 5);
        Radioman radioman = new Radioman(412, "Радионов Я.И.", "63.2");
        Stewardess stewardess = new Stewardess(326, "Ромашкина А.Ю", 1);

        Brigade brigade = administrator.createBrigade(pilots, navigator, radioman, stewardess);

        Chassis chassis = new Chassis("ОАО АвиаСтрой", 100);
        Plane plane = new Plane(chassis, 150, 3000);

        Aeroport originalAeroport = new Aeroport("Беларусь", "Минск-2");
        Aeroport destinationAeroport = new Aeroport("Россия", "Внуково");

        Cruise cruise = administrator.createCruise(brigade, plane, originalAeroport, destinationAeroport);

        pilot1.setCruise(cruise);
        pilot2.setCruise(cruise);

        system.addCruise(cruise);

        administrator.cancelCruise(cruise);

        system.showCruises();

        cruise.setStatus(0);//только для демонстрации функций

        Aeroport aeroport3 = new Aeroport("Украина", "Киев-1");
        pilot2.callAdministratorChangeAeroportDestination(aeroport3);

        for(int i=0; i<10; i++)
            System.out.println();

        system.showCruises();


    }
}
