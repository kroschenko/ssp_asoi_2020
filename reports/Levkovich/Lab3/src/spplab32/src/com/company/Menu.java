package com.company;
import com.company.Buses;

import java.util.Scanner;

public class Menu {
    Buses buses;

    void start() throws Exception
    {
         buses = new Buses();

         Scanner scanner = new Scanner(System.in);

         for(boolean key=true; key;)
         {
             System.out.println("Введите 0, чтобы посмотреть все автобусы");
             System.out.println("Введите 1, чтобы посмотреть автобусы, которые выехали из парка");
             System.out.println("Введите 2, чтобы посмотреть автобусы, которые остались в парке");
             System.out.println("Введите 3, чтобы посмотреть автобусы по заданному номеру маршрута");
             System.out.println("Введите 4, чтобы посмотреть автобусы, которые эксплуатируются больше 10 лет");
             System.out.println("Введите 5, чтобы посмотреть автобусы, пробег которых больше 100000 км");
             System.out.println("Введите 6, чтобы посмотреть автобусы, которые находятся в парке, и автобусы, которые находятся на маршруте");
             System.out.println("Введите 7, чтобы выйти");

             int k = Integer.parseInt(scanner.nextLine());

             switch(k)
             {
                 case 0: buses.show(); break;
                 case 1: buses.showRoute(); break;
                 case 2: buses.showPark(); break;
                 case 3: System.out.println("Введите номер маршрута:");
                         int route = Integer.parseInt(scanner.nextLine());
                         buses.showRoute(route); break;
                 case 4: buses.showLonger(); break;
                 case 5: buses.showLongMileAge(); break;
                 case 6: buses.showInfo(); break;
                 case 7: key = false;
             }

             scanner.nextLine();
             System.out.println("\n\n\n\n\n");

         }
    }
}
