package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    ArrayList<Request> requestsList = new ArrayList<>();
    requestsList.add(new Request("Машерова 65", "Московская 267"));
    requestsList.add(new Request("Машерова 10", "Московская 265"));
    requestsList.add(new Request("Машерова 6", "Московская 263"));
    ArrayList<Driver> driverList = new ArrayList<>();
    driverList.add(new Driver("Водитель1"));
    driverList.add(new Driver("Водитель2"));
    driverList.add(new Driver("Водитель3"));
    driverList.add(new Driver("Водитель4"));
    driverList.add(new Driver("Водитель5"));
    ArrayList<Car> carsList = new ArrayList<>();
    carsList.add(new Car("Volvo", "2625ki4","Полностью исправно"));
    carsList.add(new Car("Mercedes", "2655ki4","Полностью исправно"));
    carsList.add(new Car("Vw", "2225ki4","Полностью исправно"));
    carsList.add(new Car("Volvo", "2125ki4","Требуется ремонт"));
    ArrayList<Dispatcher> dispatchersList = new ArrayList<>();
	Dispatcher mainDispatcher = new Dispatcher("Главный диспетчер", driverList);
	dispatchersList.add(0,mainDispatcher);
	Department department = new Department(driverList,carsList,dispatchersList);
	mainDispatcher.sentRequest(driverList.get(0), requestsList.get(0),carsList.get(0));
    mainDispatcher.sentRequest(driverList.get(1), requestsList.get(1),carsList.get(1));
    mainDispatcher.sentRequest(driverList.get(2), requestsList.get(2),carsList.get(2));
    String cause = driverList.get(3).requestToRepair();
    mainDispatcher.sentRepairRequest(driverList.get(3), cause,carsList.get(3));
    mainDispatcher.comleteRequest(driverList.get(0),"Авто полностью исправно", carsList.get(0));
    mainDispatcher.suspendedDriver(driverList.get(1), requestsList.get(1), driverList.get(4), carsList.get(1));
    mainDispatcher.rejectedRequest(driverList.get(2),"Авто полностью исправно", carsList.get(2));
    mainDispatcher.comleteRequest(driverList.get(3),"Авто полностью исправно", carsList.get(3));
    mainDispatcher.comleteRequest(driverList.get(4),"Авто полностью исправно", carsList.get(1));
    }
}
