package com.company;

import java.util.ArrayList;

 class Driver {
        String name;
        Car car;
        ArrayList<Request> requests = new ArrayList<>();

        public Driver(String name) {
            this.name = name;
        }

        public Driver(String name, ArrayList<Request> requests, Car car) {
            this.name = name;
            this.requests = requests;
            this.car = car;
        }

        public void addRequest(Request request, Car car) {
            requests.add(request);
            if (request.startPoint.toLowerCase().equals("ремонт"))
                System.out.println("Авто " + car.model + " " + car.number + " отправлено на "+ request.startPoint + ", по причине: " + request.endPoint);
            else
                System.out.println("Водителю " + name + " назначен заказ: "+ request.startPoint + " - " + request.endPoint);
        }

        public void removeRequest(Request request, Car car) {
            requests.remove(request);
            System.out.println("Авто " + car.model + " " + car.number + " возвращено на базу, состояние: " + car.state);
        }

        public String requestToRepair() {
            String cause = "Проблемы с двигателем";
            System.out.println("Водитель " + name + " создал заявку на ремонт авто, по причине: " + cause);
            return cause;
        }

        public void completeRequest(Request request, String state, Car car) {
            request.completeOrder();
            if (request.startPoint.toLowerCase().equals("ремонт")) {
                System.out.println("Состояние авто "+ car.model + " " + car.number +" у " + name + " после завершения ремонта: " + state);
                car.setState(state);
            } else {
                System.out.println("Состояние авто "+ car.model + " " + car.number +" у " + name + " после выполнения заказа: " + state);
                car.setState(state);
            }
        }

        public void rejectedRequest(Request request, String state, Car car) {
            request.rejectedOrder();
            System.out.println("Состояние авто "+ car.model + " " + car.number +" у " + name + " после возвращения на базу из-за отмены заказа: " + state);
            car.setState(state);
        }
 }

    class Dispatcher {
        String name;
        ArrayList<Driver> drivers;

        public Dispatcher(String name, ArrayList<Driver> driversList) {
            this.name = name;
            this.drivers = driversList;
        }

        public void sentRequest (Driver driver, Request request,Car car) {
            drivers.get(drivers.indexOf(driver)).addRequest(request, car);
       }

       public void sentRepairRequest(Driver driver, String cause, Car car) {
           drivers.get(drivers.indexOf(driver)).addRequest(new Request("Ремонт",cause), car);
       }

       public void comleteRequest(Driver driver, String state, Car car) {
           drivers.get(drivers.indexOf(driver)).completeRequest(driver.requests.get(0),state,car);
       }

       public void rejectedRequest(Driver driver, String state, Car car) {
           drivers.get(drivers.indexOf(driver)).rejectedRequest(driver.requests.get(0),state,car);
       }

       public void suspendedDriver(Driver driver, Request request, Driver driver1, Car car) {
            System.out.println(driver.name + " отстранён, его заказ переходит " + driver1.name);
            driver.removeRequest(request, car);
            driver1.addRequest(request, car);
       }

    }

