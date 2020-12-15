package com.company.Exams;

import com.company.Members.Abiturient;
import com.company.Members.Lecturer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exam {
    private int id;
    public String examName;
    private Lecturer Examinator;
    private HashMap<Abiturient,String> PassedAbiturients = new HashMap<>();

    public String getPassedAbiturientMark(Abiturient abiturient) {
        if(PassedAbiturients.containsKey(abiturient)) {
            return PassedAbiturients.get(abiturient);
        } else {
            System.out.println("#\t Данный абитурент не сдавал экзамен");
            return "null";
        }
    }
    public void showPassedAbiturients() {
        System.out.println("\033[31;1;24m"+"#\t Список сдавших экзамен по предмету : "+this.examName+"\033[0m");
        System.out.println("#\t Всего сдало : "+this.PassedAbiturients.size());
        for(Map.Entry<Abiturient,String> item : PassedAbiturients.entrySet()) {
            System.out.println("\t "+item.getKey().name+" "+item.getKey().surname
                    +"\n\t\tОценка : "+item.getValue());
        }
    }
    public void setMark(Lecturer lecturer, Abiturient abiturient, int mark) {
        if(this.Examinator == lecturer) {
            if(this.PassedAbiturients.containsKey(abiturient)) {
                this.PassedAbiturients.put(abiturient,String.valueOf(mark));
            } else {
                System.out.println("#\t ! Этот абитурент не сдавал экзамен");
            }
        } else {
            System.out.println("#\t ! Вы не являетесь экзаменатором этого предмета");
        }
    }
    public void addPassedAbiturent(Abiturient abiturient) {
        PassedAbiturients.put(abiturient,"Не выставлено");
    }
    public void setExaminator(Lecturer lecturer) {
        Examinator = lecturer;
    }
    public Lecturer getExaminator() {
        return Examinator;
    }

    //Конструктор класса Экзамен
    public Exam(int id, String examName) {
        this.id = id;
        this.examName = examName;
    }
}
