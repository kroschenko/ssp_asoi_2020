package com.company;

import com.company.entities.Doctor;
import com.company.entities.MainDoctor;
import com.company.entities.Patient;
import com.company.entities.Purpose;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MainDoctor mainDoctor = new MainDoctor(23, "Абдулов", "Абдул");

        Doctor doctor = new Doctor(35, "Дмитрий", "Серов", 1);
        Doctor nurse = new Doctor(37, "Анастасия", "Румянцева", 0);

        Patient patient = new Patient(50, "Евгений", "Больной");

        Purpose purpose1 = new Purpose("Бисептол", 1);
        purpose1.setCountOfDay(3);
        Purpose purpose2 = new Purpose("Массаж спины", 0);
        purpose2.setCountOfDay(1);
        Purpose purpose3 = new Purpose("Удаление аденоидов", 2);

        ArrayList<Purpose> purposes = new ArrayList<Purpose>();
        purposes.add(purpose1);
        purposes.add(purpose2);
        purposes.add(purpose3);

        mainDoctor.makePurposes(patient, purposes);

        patient.print();

        for(int i=0; i<5; i++)
            System.out.println("");

        nurse.executePurpose(patient, purpose1);
        doctor.executePurpose(patient, purpose3);
        nurse.executePurpose(patient, purpose1);
        nurse.executePurpose(patient, purpose2);
        nurse.executePurpose(patient, purpose1);

        mainDoctor.dischargePatient(patient, 1);

        patient.print();
    }
}
