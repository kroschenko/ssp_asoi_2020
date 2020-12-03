package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Department {

    class Function{
        private int id;
        private String name;

        public Function(int id, String name){
            this.id = id;
            this.name = name;
        }

        public String toString(){
            return "id="+id+", должность="+name;
        }
    }

    class Worker{
        private int id;
        private String fio;
        private Function function;
        private LocalDate dateWorkingStart;
        private LocalDate dateWorkingEnd = null;

        public Worker(int id, String fio, Function function){
            this.id = id;
            this.fio = fio;
            this.function = function;
            this.dateWorkingStart = LocalDate.now();
        }

        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("id: "+id+", фио: "+fio+", должность: "+function.name+", статус: ");
            if(dateWorkingEnd==null) {
                builder.append("работает"+", дата трудоустройства: "
                        +dateWorkingStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            else
                builder.append("уволен"+", дата трудоустройства: "
                        +dateWorkingStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+", дата увольнения: "
                        +dateWorkingEnd.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            return builder.toString();
        }
    }

    ArrayList<Function> functions = new ArrayList<Function>();
    ArrayList<Worker> workers = new ArrayList<Worker>();

    public Department(){
        functions.add(new Function(1, "начальник"));
        functions.add(new Function(2, "заместитель начальника"));
        functions.add(new Function(3, "бухгалтер"));
        functions.add(new Function(4, "работник"));
    }

    public void showFunctions(){
        for(int i=0; i<functions.size(); i++)
            System.out.println(functions.get(i).toString());
    }

    public void showWorkers(){
        for(int i=0; i<workers.size(); i++)
            System.out.println(workers.get(i).toString());
    }

    public void addWorker(int workerId, String fio, int functionId){
        Function function = null;
        for(int i=0; i<functions.size(); i++)
            if(functions.get(i).id==functionId)
            {
                function = functions.get(i);
                break;
            }

        if(function==null)
            return;

        Worker worker = new Worker(workerId, fio, function);
        workers.add(worker);
    }

    public void dismissWorker(int workerId){
        for(int i=0; i<workers.size(); i++)
            if(workers.get(i).id==workerId)
            {
                workers.get(i).dateWorkingEnd = LocalDate.now();
                return;
            }
    }

}
