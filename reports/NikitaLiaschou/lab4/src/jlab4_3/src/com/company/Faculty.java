package com.company;

import com.company.Exams.Exam;
import com.company.Members.Abiturient;

import java.util.ArrayList;

public class Faculty {
    private int facultyId;
    public String facultyName;
    private ArrayList<Abiturient> abiturentsList = new ArrayList();
    private ArrayList<Exam> examsList = new ArrayList();

    public void showFacultyExams() {
        System.out.println("\033[33;1;24m"+"#\t Список экзаменов для поступления на факультет : "+this.facultyName+"\033[0m");
        for(Exam item : examsList) {
            System.out.println("\t "+item.examName + "\t Экзаменатор : "+ item.getExaminator().name + " " + item.getExaminator().surname);
        }
    }
    public void showAbiturents() {
        System.out.println("\033[33;1;24m"+"#\t Список абитуриентов факультета "+facultyName+"\033[0m");
        for(Abiturient item : abiturentsList) {
            System.out.println("\t "+item.name+" "+item.surname);
        }
    }
    public void setFacultyExam(Exam exam) {
        examsList.add(exam);
    }
    public void regAbiturient(Abiturient ab) {
        abiturentsList.add(ab);
        ab.setFaculty(this);
    }
    public ArrayList<Abiturient> getAbiturients() {
        return abiturentsList;
    }
    public ArrayList<Exam> getExamsList() {
        return examsList;
    }
    //Конструктор класса Факультет
    public Faculty(int facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }
}
