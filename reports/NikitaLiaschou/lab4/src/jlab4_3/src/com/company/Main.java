package com.company;

import com.company.Exams.Exam;
import com.company.Members.Abiturient;
import com.company.Members.Lecturer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Faculty> listOfFaculties = new ArrayList<Faculty>();
        ArrayList<Exam> listOfExams = new ArrayList<Exam>();
        ArrayList<Lecturer> listOfLecturers = new ArrayList<Lecturer>();
        ArrayList<Abiturient> listOfAbiturients = new ArrayList<Abiturient>();

        int ids[] = {0,0,0,0};//ID: Абитуриент, Преподователь, Факультет, Экзамен
        //Абитуриенты
        Abiturient ab1 = new Abiturient(++ids[0],"Никита","Лещёв");
        Abiturient ab2 = new Abiturient(++ids[0],"Олег","Бочонский");
        Abiturient ab3 = new Abiturient(++ids[0],"Екатерина","Богрова");
        Abiturient ab4 = new Abiturient(++ids[0],"Елисей","Щавельский");
        Abiturient ab5 = new Abiturient(++ids[0],"Мария","Кушкина");
        Abiturient ab6 = new Abiturient(++ids[0],"Яков","Крупин");
        Abiturient ab7 = new Abiturient(++ids[0],"Владлен","Дешевых");
        Abiturient ab8 = new Abiturient(++ids[0],"Харитон","Вятт");
        Abiturient ab9 = new Abiturient(++ids[0],"Ника","Мухоморова");
        //Преподователи
        Lecturer Kroschenko = new Lecturer(++ids[1],"Александр","Крощенко","Д1");
        Lecturer Golovko = new Lecturer(++ids[1],"Владимир","Головко","Д2");
        Lecturer Bezobrazov = new Lecturer(++ids[1],"Сергей","Безобразов","Д1");
        Lecturer Hveschuk = new Lecturer(++ids[1],"Владимир","Хвещук","Д2");
        //Факультеты
        Faculty feis = new Faculty(++ids[2],"ФЭИС");
        Faculty ef = new Faculty(++ids[2],"ЭФ");
        //Экзамены
        Exam Math = new Exam(++ids[3],"Математика");
        Exam Phys = new Exam(++ids[3],"Физика");
        Exam Eng = new Exam(++ids[3],"Английский язык");
        Exam Rus = new Exam(++ids[3],"Русский язык");

        //Ставим на экзамен своего преподователя
        Math.setExaminator(Kroschenko);
        Phys.setExaminator(Golovko);
        Eng.setExaminator(Bezobrazov);
        Rus.setExaminator(Hveschuk);

        //ФЭИС
            //Устанавливаем какие экзамены нужны для поступления на факультет
            feis.setFacultyExam(Math);
            feis.setFacultyExam(Phys);
            feis.showFacultyExams();

            //Регистрируем абитуриентов на факультет
            feis.regAbiturient(ab1);
            feis.regAbiturient(ab2);
            feis.regAbiturient(ab3);
            feis.regAbiturient(ab4);
            feis.regAbiturient(ab5);
            feis.showAbiturents();

            //Абитуриенты сдают экзамены
            ab1.passExam(Math);
            ab2.passExam(Math);
            ab3.passExam(Math);
            ab4.passExam(Math);
            ab5.passExam(Math);
            ab1.passExam(Phys);
            ab2.passExam(Phys);
            ab3.passExam(Phys);
            ab4.passExam(Phys);
            ab5.passExam(Phys);

            //Экзаменаторы выставляют оценки
            Kroschenko.setMark(Math,ab1,7);
            Kroschenko.setMark(Math,ab2,3);
            Kroschenko.setMark(Math,ab3,2);
            Kroschenko.setMark(Math,ab4,10);
            Kroschenko.setMark(Math,ab5,5);
            Golovko.setMark(Phys,ab1,7);
            Golovko.setMark(Phys,ab2,10);
            Golovko.setMark(Phys,ab3,6);
            Golovko.setMark(Phys,ab4,3);
            Golovko.setMark(Phys,ab5,6);
        //ЭФ
            //Устанавливаем какие экзамены нужны для поступления на факультет
            ef.setFacultyExam(Math);
            ef.setFacultyExam(Eng);
            ef.showFacultyExams();

            //Регистрируем абитуриентов на факультет
            ef.regAbiturient(ab6);
            ef.regAbiturient(ab7);
            ef.regAbiturient(ab8);
            ef.regAbiturient(ab9);
            ef.showAbiturents();

            //Абитуриенты сдают экзамены
            ab6.passExam(Math);
            ab7.passExam(Math);
            ab8.passExam(Math);
            ab9.passExam(Math);
            ab6.passExam(Eng);
            ab7.passExam(Eng);
            ab8.passExam(Eng);
            ab9.passExam(Eng);

            //Экзаменаторы выставляют оценки
            Kroschenko.setMark(Math,ab6,7);
            Kroschenko.setMark(Math,ab7,3);
            Kroschenko.setMark(Math,ab8,2);
            Kroschenko.setMark(Math,ab9,10);
            Bezobrazov.setMark(Eng,ab6,7);
            Bezobrazov.setMark(Eng,ab7,10);
            Bezobrazov.setMark(Eng,ab8,6);
            Bezobrazov.setMark(Eng,ab9,3);

        Math.showPassedAbiturients();
        Phys.showPassedAbiturients();
        Eng.showPassedAbiturients();
        getResults(feis);
        getResults(ef);

        //System.out.println("\033[31;1;24m"+"Hello"+"\033[0m");

        //Ставим на экзамен своего преподователя
        //MathExam.setExaminator(Kroschenko);



//        feis.regAbiturient(Nikita);
//        feis.regAbiturient(Oleg);
//        feis.showAbiturents();
//        feis.countAbiturients();

    }

    public static void getResults(Faculty f) {
        System.out.println("\033[34;1;24m"+"#\t Результаты вступительных экзаменов по факультету : "+f.facultyName+"\033[0m");
        //Получаем список абитуриентов факультета
        ArrayList<Abiturient> tempAbiturientLiST = f.getAbiturients();
        //Получаем список экзаменов на факультета
        ArrayList<Exam> tempExamsList = f.getExamsList();
        //Создаем список новых студентов
        HashMap<Abiturient,Double> newStudents = new HashMap<>();
        for(Abiturient item : tempAbiturientLiST) {
            double tempMark = 0;
            for(Exam item2 : tempExamsList) {
                tempMark += Integer.parseInt(item2.getPassedAbiturientMark(item));
            }
            tempMark = tempMark/tempExamsList.size();
            newStudents.put(item,tempMark);
        }

        for(Map.Entry<Abiturient,Double> item : newStudents.entrySet()) {
            System.out.println("\033[35;1;24m"+"\t "+item.getKey().name+" "+item.getValue()+"\033[0m");
        }
    }
}
