package com.company;

import java.util.ArrayList;

public class AeroSystem {

    private ArrayList<Cruise> cruises = new ArrayList<Cruise>();


    public void addCruise(Cruise cruise){
        cruises.add(cruise);
    }

    public void showCruises(){
        for(int i=0; i<cruises.size(); i++)
            cruises.get(i).show();
    }




}
