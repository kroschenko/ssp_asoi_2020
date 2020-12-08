package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//делаем общий класс, который будет содержать вложенные классы
class Department {
    //создадим класс, содержащий информацию о должностях
    class Roles {
        //так как это должности, то уделние отсутствует
        private int id;
        private String name;

        public Roles(int id, String name){
            this.id = id;
            this.name = name;
        }

        public String forPrint(){
            return "id="+id+", должность="+name;
        }
    }

    //внутренний клас, содержащий информацию о работниках фирмы!
    class Worker{
        private int id;
        private String FIO = "";
        private Roles roles;
        private LocalDate whenStartWork = null;
        private LocalDate whenEndWork = null;

        //добавление информации о рабочем
        public Worker(int id, String FIO, Roles roles){
            this.id = id;
            this.FIO = FIO;
            this.roles = roles;
            this.whenStartWork = LocalDate.now();
        }
        //просто вывод на экран информации по рабочему
        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("id: "+id+", фио: "+ FIO +", должность: "+ roles.name+", статус: ");
            if(whenEndWork ==null) {
                builder.append("работает"+", дата трудоустройства: "
                        + whenStartWork.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            else
                builder.append("уволен"+", дата трудоустройства: "
                        + whenStartWork.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+", дата увольнения: "
                        + whenEndWork.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            return builder.toString();
        }
    }
    //закончили создание классов. пишем функционал для main

    //содадим хранилище для рабочих и их должностей
    ArrayList<Roles> roles = new ArrayList<Roles>();
    ArrayList<Worker> workers = new ArrayList<Worker>();

    //начальные инициализации должностей
    public Department(){
        roles.add(new Roles(1, "директор"));
        roles.add(new Roles(2, "секретарь"));
        roles.add(new Roles(3, "бухгалтер"));
        roles.add(new Roles(4, "сотрудник"));
    }

    public void showRoles(){
        for(int i = 0; i< roles.size(); i++)
            System.out.println(roles.get(i).forPrint());
    }

    public void showWorkers(){
        for(int i=0; i<workers.size(); i++)
            System.out.println(workers.get(i).toString());
    }

    public void addWorker(int workerId, String fio, int functionId){
        Roles roles = null;
        for(int i = 0; i< this.roles.size(); i++)
            if(this.roles.get(i).id==functionId)
            {
                roles = this.roles.get(i);
                break;
            }

        if(roles ==null)
            return;

        Worker worker = new Worker(workerId, fio, roles);
        workers.add(worker);
    }

    public void dismissWorker(int workerId){
        for(int i=0; i<workers.size(); i++)
            if(workers.get(i).id==workerId)
            {
                workers.get(i).whenEndWork = LocalDate.now();
                return;
            }
    }

}

//показываем работу программы
public class Main {

    public static void main(String[] args) {
        Department department = new Department();

        System.out.println("Список должностей:\n");
        department.showRoles();
        //добавляем рабочих
        department.addWorker(1, "Клиницкая Р.П.", 1);
        department.addWorker(2, "Барболин М.О.", 2);
        department.addWorker(3, "Дряпко А.В.", 3);
        department.addWorker(4, "Куц Д.А.", 4);
        department.addWorker(5, "Сталин В.В.", 4);
        //удаляем Сталина
        department.dismissWorker(5);
        //Вывод оставшихся рабочих
        System.out.println("Все работники:\n");

        department.showWorkers();
    }
}
