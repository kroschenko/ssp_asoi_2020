package com.company;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        TrainNotif controller = new TrainNotif();
        Scanner scanner = new Scanner(System.in);
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        if(!controller.loadFromFile("timetable.txt"))
        {
            System.out.println("Ошибка чтения данных из файла.");
            return;
        }

        boolean menuKey = true;
        int key;

        //для печати информационного сообщения о скором отправлении поезда
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String currTime = sdf.format(timestamp);
                controller.printtrainFromTime(currTime);
            }
        },0,60*1000);

        String toStation, number,fromTime;
        while(menuKey)
        {
            for(int i=0; i<5; i++)
            System.out.println();
            System.out.println("1 - Вывести данные о всех поездах");
            System.out.println("2 - Вывести информацию о поезде по его номеру");
            System.out.println("3 - По названию станции назначения выводит данные обо всех поездах, которые следуют до этой станции");
            System.out.println("4 - Выводит список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа");
            System.out.println("5 - Выводит список поездов, отправляющихся до заданного пункта назначения и имеющих общие места");
            System.out.println("6 - завершить работу");

            key = scanner.nextInt();
            scanner.nextLine();


            if(key==1)
                controller.printTrains();
            else if(key==2)
            {
                System.out.print("Введите номер поезда:");
                number = scanner.nextLine();
                controller.printTrainByNumber(number);
            }
            else if(key==3)
            {
                System.out.print("Введите станцию назначения:");
                toStation = scanner.nextLine();
                controller.printTrainsByToStation(toStation);
            }
            else if(key==4)
            {
                System.out.print("Введите станцию назначения:");
                toStation = scanner.nextLine();
                System.out.print("Введите заданное время (в формате HH:mm, например 07:10):");
                fromTime = scanner.nextLine();
                controller.printTrainsByToStationAndFromTime(toStation,fromTime);
            }
            else if(key == 5)
            {
                System.out.print("Введите станцию назначения:");
                toStation = scanner.nextLine();
                controller.printTrainsByToStationAndCP(toStation);
            }
            else if(key == 6)
                menuKey= false;
            else
                System.out.println("Неверный код");

            System.out.println("Нажмите Enter для продолжения...");
            scanner.nextLine();
        }
        scanner.close();
        timer.cancel();
    }

}


