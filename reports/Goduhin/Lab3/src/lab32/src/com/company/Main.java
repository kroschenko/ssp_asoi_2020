package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Car
{
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double cost;
    private String regNumber;
    private String carNumber;
    private String fio = null;
    private String passportNumber = null;

    public void print(boolean getHolderInfo){
        System.out.print("id: "+id+", brand: "+brand+", model: "+model+", year: "
                            +year+", color: "+color+ ", cost: "+cost+", regNumber: "
                            +regNumber+", carNumber: "+carNumber);
        if(getHolderInfo)
            System.out.println(", fio: "+fio+", passportNumber: "+passportNumber);
        else
            System.out.println();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


}

class Controller
{
    private ArrayList<Car> cars = new ArrayList<Car>();

    public boolean loadFromFile(String path)
    {
        ArrayList<Car> tempList = new ArrayList<Car>();
        File file = new File(path);

        Scanner scanner = null;

        try {
            scanner = new Scanner(file, "utf-8");
        }
        catch(FileNotFoundException e){
            return false;
        }

        while(scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(" ");

            if (values.length < 8 || values.length > 10)
                return false;

            Car car = new Car();

            try {
                car.setId(Integer.parseInt(values[0]));
                car.setBrand(values[1]);
                car.setModel(values[2]);
                car.setYear(Integer.parseInt(values[3]));
                car.setColor(values[4]);
                car.setCost(Double.parseDouble(values[5]));
                car.setRegNumber(values[6]);
                car.setCarNumber(values[7]);

                if (values.length > 8)
                    car.setFio(values[8]);
                if (values.length > 9)
                    car.setPassportNumber(values[9]);

                tempList.add(car);
            }
            catch(Exception e) {
                return false;
            }

        }

        scanner.close();

        cars = tempList;

        return true;
    }

    public void printCars()
    {
        for(int i=0; i<cars.size(); i++)
            cars.get(i).print(false);
    }

    public void printCarsByBrand(String brand)
    {
        for(int i=0; i<cars.size(); i++)
            if(cars.get(i).getBrand().equals(brand))
                cars.get(i).print(false);
    }

    public void printCarsByBrandWhereUsesGreaterThenNyears(String brand, int n)
    {
        for(int i=0; i<cars.size(); i++)
            if(cars.get(i).getBrand().equals(brand) && 2020-cars.get(i).getYear()>n)
                cars.get(i).print(false);
    }

    public void printCarsByYearWhereCostGreaterThen(int year, double cost)
    {
        for(int i=0; i<cars.size(); i++)
            if(cars.get(i).getYear() == year && cars.get(i).getCost() > cost)
                cars.get(i).print(false);
    }

    public void printCarsWhereHaveHolderWithoutHolderInfo()
    {
        for(int i=0; i<cars.size(); i++)
            if(cars.get(i).getFio() != null)
                cars.get(i).print(false);
    }

    public void printCarsWhereHaveHolder()
    {
        for(int i=0; i<cars.size(); i++)
            if(cars.get(i).getFio() != null)
                cars.get(i).print(true);
    }
}

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        if(!controller.loadFromFile("cars.txt"))
        {
            System.out.println("Ошибка чтения данных из файла.");
            return;
        }

        boolean menuKey = true;
        int code;

        Scanner scanner = new Scanner(System.in);

        String brand;
        int n, year;
        double cost;

        while(menuKey)
        {
            for(int i=0; i<10; i++)
                System.out.println();

            System.out.println("1 - вывести все автомобили");
            System.out.println("2 - вывести все автомобили заданной марки");
            System.out.println("3 - вывести все автомобили заданной марки, которые эксплуатируются больше n лет");
            System.out.println("4 - вывести все автомобили заданного года выпуска, цена которых больше указанной");
            System.out.println("5 - вывести все автомобили, которые взяты на прокат");
            System.out.println("6 - вывести все автомобили, которые взяты на прокат, с выводом личной информации об арендаторах");
            System.out.println("7 - завершить работу");

            code = scanner.nextInt();
            scanner.nextLine();

            if(code==1)
                controller.printCars();
            else if(code==2)
            {
                System.out.print("Введите бренд:");
                brand = scanner.nextLine();
                controller.printCarsByBrand(brand);
            }
            else if(code==3)
            {
                System.out.print("Введите бренд:");
                brand = scanner.nextLine();
                System.out.print("Введите n:");
                n = scanner.nextInt();
                scanner.nextLine();
                controller.printCarsByBrandWhereUsesGreaterThenNyears(brand, n);
            }
            else if(code==4)
            {
                System.out.print("Введите год выпуска:");
                year = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите цену:");
                cost = scanner.nextDouble();
                scanner.nextLine();
                controller.printCarsByYearWhereCostGreaterThen(year, cost);
            }
            else if(code == 5)
                controller.printCarsWhereHaveHolderWithoutHolderInfo();
            else if(code == 6)
                controller.printCarsWhereHaveHolder();
            else if(code == 7)
                menuKey= false;
            else
                System.out.println("Неверный код");

            System.out.println("Нажмите Enter для продолжения...");
            scanner.nextLine();
        }
        scanner.close();
    }
}
