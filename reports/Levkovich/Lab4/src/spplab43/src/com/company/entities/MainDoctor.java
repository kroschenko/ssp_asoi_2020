package com.company.entities;

import com.company.interfaces.IMainDoctor;

import java.util.ArrayList;

public class MainDoctor extends Doctor implements IMainDoctor {

    public MainDoctor(int id, String name, String surname) {
        super(id, name, surname, 1);
    }

    public void makePurposes(Patient patient, ArrayList<Purpose> purposes) {
        for(int i=0; i<purposes.size(); i++) {
            Purpose purpose1 = purposes.get(i).clone();
            purpose1.updateTime();
            purpose1.setDoctor(this);
            patient.addTohistory(purpose1);
        }
    }
    public void dischargePatient(Patient patient, int reason){
        patient.setStatus(reason);
    }
}
