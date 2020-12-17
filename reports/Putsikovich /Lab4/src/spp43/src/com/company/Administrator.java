package com.company;

import java.util.ArrayList;

public class Administrator extends Worker {

    public Brigade createBrigade(ArrayList<Pilot> pilots, Navigator navigator, Radioman radioman, Stewardess stewardess){
        return new Brigade(pilots, navigator, radioman, stewardess);
    }

    public Cruise createCruise(Brigade brigade, Plane plane, Aeroport originalAeroport, Aeroport destinationAeroport){
        return new Cruise(brigade, plane, originalAeroport, destinationAeroport);
    }

    public Cruise askChangeDestinationAeroport(Cruise cruise, Aeroport destinationAeroport){
        cruise.setDestinationAeroport(destinationAeroport);
        return cruise;
    }

    public boolean cancelCruise(Cruise cruise){
        if(cruise.getStatus()==0) {
            cruise.setStatus(2);
            return true;
        }
        else{
            return false;
        }
    }

    public void work(){
        System.out.println("Администратор работает!");
    }

    public void show(){
        System.out.println("Администратор:");
        super.show();
    }

    public Administrator(int id, String fio) {
        super(id, fio);
    }
}
