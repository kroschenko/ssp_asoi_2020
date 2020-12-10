import java.util.ArrayList;
import java.util.Scanner;

class Administrator {
    ArrayList<Train> trainList = new ArrayList<>();
    String departurePoint, departureTime, departureDate, destinationPoint, destinationTime;
    ArrayList<String> stationList, stationTimeList;

    public void setDeparturePoint(String departurePoint) { this.departurePoint = departurePoint; }

    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

    public void setDestinationTime(String destinationTime) { this.destinationTime = destinationTime; }

    public void setDestinationPoint(String destinationPoint) { this.destinationPoint = destinationPoint; }

    public void setStationList(ArrayList<String> stationList) { this.stationList = stationList; }

    public void setStationTimeList(ArrayList<String> stationTimeList) { this.stationTimeList = stationTimeList; }

    public void createTrain() {
        trainList.add(new Train(destinationPoint, destinationTime, departurePoint, departureTime, departureDate,
                stationList, stationTimeList));
    }

    void printTrain(String date, String point) {
        int i = 0;
        for (Train train : trainList) {
            if(train.departureDate.equals(date))
                if (train.destinationPoint.equals(point)) System.out.println("Поезд №" + i + ", Отбытие: "
                        + train.departurePoint + " " + train.departureTime + " " + train.departureDate + ", Прибытие: "
                        + train.destinationPoint + " " + train.destinationTime + " " + train.departureDate
                        + "\nМаршрут: " + train.stationList + ", Время прибытия по станциям: " + train.stationTimeList);
            i++;
        }
    }
}

class Passenger {
    ArrayList<Request> requestsList = new ArrayList<>();
    String date, point, time, destination;

    public void setDate(String date) { this.date = date; }

    public void setPoint(String point) { this.point = point; }

    public void setTime(String time) { this.time = time; }

    public void setDestination(String destination) { this.destination = destination; }

    public void createRequest() { requestsList.add(new Request(date, point, time, destination)); }

    void printRequest() {
        int i = 0;
        for (Request request: requestsList) {
            System.out.println("Заявка №" + i + ", Дата: " + request.departureDate + ", Время: " + request.departureTime
                    + ", Пункт отбытия: " + request.departurePoint + ", Пункт назначения: " + request.destinationPoint);
            i++;
        }
    }
}

class Train {
    String destinationPoint, destinationTime, departurePoint, departureTime, departureDate;
    ArrayList<String> stationList, stationTimeList;

    public Train(String destinationPoint, String destinationTime, String departurePoint, String departureTime,
                 String departureDate, ArrayList<String> stationList, ArrayList<String> stationTimeList) {
        this.destinationPoint = destinationPoint;
        this.destinationTime = destinationTime;
        this.departurePoint = departurePoint;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.stationList = stationList;
        this.stationTimeList = stationTimeList;
    }
}

class Request {
    String departureDate, departurePoint, departureTime, destinationPoint;

    public Request(String departureDate, String departurePoint, String departureTime, String destinationPoint) {
        this.departureDate = departureDate;
        this.departurePoint = departurePoint;
        this.departureTime = departureTime;
        this.destinationPoint = destinationPoint;
    }
}

public class task3 {
    public static void main(String[] args) {
        String date, point;
        Passenger passenger = new Passenger();
        passenger.setDestination("Минск");
        passenger.setDate("11.12.2020");
        passenger.setPoint("Брест");
        passenger.setTime("06:00");
        passenger.createRequest();

        passenger.setDestination("Брест");
        passenger.setDate("13.12.2020");
        passenger.setPoint("Минск");
        passenger.setTime("19:30");
        passenger.createRequest();

        passenger.printRequest();

        System.out.print("Введите номер заявки: ");
        Scanner scanner = new Scanner(System.in);
        int requestNumber = scanner.nextInt();
        System.out.println("");

        date = passenger.requestsList.get(requestNumber).departureDate;
        point = passenger.requestsList.get(requestNumber).destinationPoint;

        Administrator administrator = new Administrator();
        administrator.setDeparturePoint("Брест");
        administrator.setDepartureDate("11.12.2020");
        administrator.setDepartureTime("06:21");
        administrator.setDestinationPoint("Минск");
        administrator.setDestinationTime("09:23");
        ArrayList<String> stations1 = new ArrayList<>();
        stations1.add("Жабинка");
        stations1.add("Береза");
        stations1.add("Барановичи");
        administrator.setStationList(stations1);
        ArrayList<String> stationsTimes = new ArrayList<>();
        stationsTimes.add("06:44");
        stationsTimes.add("07:28");
        stationsTimes.add("08:30");
        administrator.setStationTimeList(stationsTimes);
        administrator.createTrain();

        administrator.setDeparturePoint("Минск");
        administrator.setDepartureDate("13.12.2020");
        administrator.setDepartureTime("19:47");
        administrator.setDestinationPoint("Брест");
        administrator.setDestinationTime("23:02");
        ArrayList<String> stations2 = new ArrayList<>();
        stations2.add("Барановичи");
        stations2.add("Ивацевичи");
        stations2.add("Жабинка");
        administrator.setStationList(stations2);
        ArrayList<String> stationsTimes2 = new ArrayList<>();
        stationsTimes2.add("21:13");
        stationsTimes2.add("21:45");
        stationsTimes2.add("22:43");
        administrator.setStationTimeList(stationsTimes2);
        administrator.createTrain();

        administrator.printTrain(date, point);

        Scanner railwayNumber = new Scanner(System.in);
        System.out.print("Введите номер поезда: ");
        int r_number = railwayNumber.nextInt();
        int checkNumber = (int) (Math.random() * 200000) + 100000;
        int seat = (int) (Math.random() * 200) + 10;
        int ticketCost = (int) (Math.random() * 5) + 20;
        System.out.println("\nСчет №" + checkNumber);
        System.out.println("Оплата маршрута №" + r_number);
        System.out.println("Место №" + seat);
        System.out.println("Стоимость билета: " + ticketCost);
        System.out.println("Приятной поездки!");
    }
}