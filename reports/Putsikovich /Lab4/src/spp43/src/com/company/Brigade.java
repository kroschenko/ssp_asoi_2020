package com.company;

import java.util.ArrayList;

public class Brigade {
    private ArrayList<Pilot> pilots = new ArrayList<Pilot>();
    private Navigator navigator;
    private Radioman radioman;
    private Stewardess stewardess;

    public void show(){
        for(int i=0; i<pilots.size(); i++)
            pilots.get(i).show();
        navigator.show();
        radioman.show();
        stewardess.show();
    }

    public ArrayList<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Radioman getRadioman() {
        return radioman;
    }

    public void setRadioman(Radioman radioman) {
        this.radioman = radioman;
    }

    public Stewardess getStewardess() {
        return stewardess;
    }

    public void setStewardess(Stewardess stewardess) {
        this.stewardess = stewardess;
    }

    public Brigade(ArrayList<Pilot> pilots, Navigator navigator, Radioman radioman, Stewardess stewardess) {
        this.pilots = pilots;
        this.navigator = navigator;
        this.radioman = radioman;
        this.stewardess = stewardess;
    }
}
