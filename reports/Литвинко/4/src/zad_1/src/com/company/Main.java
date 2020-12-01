package com.company;

public class Main {

    public static void main(String[] args) {
        Department department = new Department();

        System.out.println("Все должности:\n");
        department.showFunctions();

        department.addWorker(1, "Селиванов П.Ю.", 1);
        department.addWorker(2, "Круглова Ю.Я.", 2);
        department.addWorker(3, "Косой М.М.", 3);
        department.addWorker(4, "Белова А.Е.", 4);
        department.addWorker(5, "Горький И.И.", 4);

        department.dismissWorker(4);

        System.out.println("Все работники:\n");

        department.showWorkers();
    }
}
