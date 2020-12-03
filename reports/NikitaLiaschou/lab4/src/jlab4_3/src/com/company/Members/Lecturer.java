package com.company.Members;

import com.company.Exams.Exam;

public class Lecturer extends Man {
    private String position;

    public void setMark(Exam exam, Abiturient abiturient, int mark) {
        exam.setMark(this,abiturient,mark);
    }
    //Конструктор класса Преподователь
    public Lecturer(int lId, String lName, String lSurname,String lPosition ) {
        name = lName;
        surname = lSurname;
        id = lId;
        position = lPosition;
    }

}
