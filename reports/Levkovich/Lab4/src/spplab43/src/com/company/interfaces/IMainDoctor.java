package com.company.interfaces;

import com.company.entities.Patient;
import com.company.entities.Purpose;

import java.util.ArrayList;

public interface IMainDoctor {

    void makePurposes(Patient patient, ArrayList<Purpose> purposes);
    void dischargePatient(Patient patient, int reason);
}
