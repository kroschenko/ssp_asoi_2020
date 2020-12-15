package com.company.Members;

import com.company.Exams.Exam;
import com.company.Faculty;

public class Abiturient extends Man {
    //Поля класса Абитуриент
    private Faculty faculty;

    //Методы класса Абитуриент
    public void setFaculty(Faculty f) {
        faculty = f;
    }
    public Faculty getFaculty() {
        return faculty;
    }
    public void passExam(Exam exam) {
        exam.addPassedAbiturent(this);
    }

    //Конструктор класса Абитуриент
    public Abiturient(int aId, String aName, String aSurname ) {
        name = aName;
        surname = aSurname;
        id = aId;
    }

}
