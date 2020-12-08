package com.company.interfaces;

import com.company.entities.Patient;
import com.company.entities.Purpose;

public interface IDoctor {

    void executePurpose(Patient patient, Purpose purpose);
}
