package com.company;

import com.company.Bus;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Buses {

    ArrayList<Bus> buses = new ArrayList<Bus>();
    int currentYear = 2020;

    public Buses() throws Exception
    {
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file, "utf-8");

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] words = line.split(",");

            Bus bus = new Bus();
            bus.setDriverFIO(words[0]);
            bus.setNumber(words[1]);
            bus.setRoute(Integer.parseInt(words[2]));
            bus.setProducer(words[3]);
            bus.setYear(Integer.parseInt(words[4]));
            bus.setMileage(Integer.parseInt(words[5]));
            bus.setLocationCode(Integer.parseInt(words[6]));

            buses.add(bus);
        }
    }

    public void show()
    {
        for(int i=0; i<buses.size(); i++)
            System.out.println(buses.get(i).toString());
    }

    public void showPark()
    {
        for(int i=0;i<buses.size(); i++)
            if(buses.get(i).getLocationCode()==0)
                System.out.println(buses.get(i).toString());
    }

    public void showRoute()
    {
        for(int i=0;i<buses.size(); i++)
            if(buses.get(i).getLocationCode()==1)
                System.out.println(buses.get(i).toString());
    }

    public void showRoute(int route)
    {
        for(int i=0;i<buses.size(); i++)
            if(buses.get(i).getRoute() == route)
                System.out.println(buses.get(i).toString());
    }

    public void showLonger()
    {
        for(int i=0;i<buses.size(); i++)
            if(currentYear - buses.get(i).getYear() > 10)
                System.out.println(buses.get(i).toString());
    }

    public void showLongMileAge()
    {
        for(int i=0;i<buses.size(); i++)
            if(buses.get(i).getMileage() > 100000)
                System.out.println(buses.get(i).toString());
    }

    public void showInfo()
    {
        System.out.println("В парке:\n");

        for(int i=0;i<buses.size(); i++)
            if(buses.get(i).getLocationCode()==0)
                System.out.println(buses.get(i).toString());

        System.out.println("На маршруте:\n");

        for(int i=0;i<buses.size(); i++)
            if(buses.get(i).getLocationCode()==1)
                System.out.println(buses.get(i).toString());
    }
}
