package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    String date;
    String point;
	Passenger passenger = new Passenger();
	passenger.setDestination("Пинск");
	passenger.setData("07.12.2020");
	passenger.setPoint("Брест");
	passenger.setTime(12.15);
	passenger.create_request();

	passenger.setDestination("Заболоть");
	passenger.setData("14.12.2020");
	passenger.setPoint("Брест");
	passenger.setTime(18.25);
	passenger.create_request();

	passenger.setDestination("Ольховск");
	passenger.setData("09.12.2020");
	passenger.setPoint("Брест");
	passenger.setTime(01.00);
	passenger.create_request();

	passenger.setDestination("Подгорье");
	passenger.setData("07.12.2020");
	passenger.setPoint("Брест");
	passenger.setTime(23.00);
	passenger.create_request();

	passenger.setDestination("Воронеж");
	passenger.setData("17.12.2020");
	passenger.setPoint("Брест");
	passenger.setTime(21.48);
	passenger.create_request();


	passenger.printRequest();

	System.out.println("Введите номер вашей заявки для отображения списка поездов");
		Scanner requestNumber = new Scanner(System.in);
		int number = requestNumber.nextInt();

		date = passenger.requestsList.get(number).departure_date;
		point = passenger.requestsList.get(number).final_destination;

		Administrator administrator = new Administrator();
		administrator.setData("07.12.2020");
		administrator.setDestination("Пинск");
		ArrayList<String> stations = new ArrayList<>();
		stations.add("Барановичи");
		stations.add("Подгорье");
		stations.add("Витебск");
		stations.add("Могилёв");
		administrator.setStations(stations);
		ArrayList<Double> stationsTimes = new ArrayList<>();
		stationsTimes.add(12.00);
		stationsTimes.add(14.00);
		stationsTimes.add(18.25);
		stationsTimes.add(23.12);
		administrator.setStationsTime(stationsTimes);

		administrator.create_railway();

		administrator.printAvailableRailway(date, point);
		System.out.println("Введите номер выбраного поезда");
		Scanner railwayNumber = new Scanner(System.in);
		int r_number =railwayNumber.nextInt();
		System.out.println("Ваш счёт на оплату");
		System.out.println("Оплатить поезд № " + number);
		System.out.println("Стоимость оплаты: " + 50*stations.size());
	}
}
