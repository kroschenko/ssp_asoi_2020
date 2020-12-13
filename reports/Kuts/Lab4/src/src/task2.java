import java.util.Scanner;

class Wheel {
    int rotationSpeed = 0;

    public int getRotationSpeed() { return rotationSpeed; }

    public void setRotationSpeed(int rotationSpeed) { this.rotationSpeed = rotationSpeed; }
}

enum carList {Renault, BMW, Lamborghini}

class Car {
    Wheel wheel = new Wheel();
    String selectCar;
    boolean isEngineStarted = false;
    int turnGear;

    public Car(String selectCar) { this.selectCar = selectCar; }

    public void setEngineStarted(boolean engineStarted) { isEngineStarted = engineStarted; }

    public void startEngine() { setEngineStarted(true); }

    public void stopEngine() { setEngineStarted(false); }

    public void turnOnGear(int gear) { turnGear = gear; }

    public void drive() {
        if (!isEngineStarted) System.out.println("Двигатель выключен");
        else {
            switch (turnGear) {
                case 0 -> System.out.println("Двигатель запущен \nНейтральная передача. Скорость 0 км/ч");
                case 1 -> {
                    switch (selectCar) {
                        case "Renault" -> wheel.setRotationSpeed(20);
                        case "BMW" -> wheel.setRotationSpeed(30);
                        case "Lamborghini" -> wheel.setRotationSpeed(40);
                    }
                    System.out.println("Первая передача. Скорость " + wheel.getRotationSpeed() + " км/ч");
                }
                case 2 -> {
                    switch (selectCar) {
                        case "Renault" -> wheel.setRotationSpeed(40);
                        case "BMW" -> wheel.setRotationSpeed(60);
                        case "Lamborghini" -> wheel.setRotationSpeed(80);
                    }
                    System.out.println("Вторая передача. Скорость " + wheel.getRotationSpeed() + " км/ч");
                }
                case 3 -> {
                    switch (selectCar) {
                        case "Renault" -> wheel.setRotationSpeed(60);
                        case "BMW" -> wheel.setRotationSpeed(90);
                        case "Lamborghini" -> wheel.setRotationSpeed(120);
                    }
                    System.out.println("Третья передача. Скорость " + wheel.getRotationSpeed() + " км/ч");
                }
                case 4 -> {
                    switch (selectCar) {
                        case "Renault" -> wheel.setRotationSpeed(90);
                        case "BMW" -> wheel.setRotationSpeed(150);
                        case "Lamborghini" -> wheel.setRotationSpeed(200);
                    }
                    System.out.println("Четвертая передача. Скорость " + wheel.getRotationSpeed() + " км/ч");
                }
                case 5 -> {
                    switch (selectCar) {
                        case "Renault" -> wheel.setRotationSpeed(140);
                        case "BMW" -> wheel.setRotationSpeed(200);
                        case "Lamborghini" -> wheel.setRotationSpeed(300);
                    }
                    System.out.println("Пятая передача. Скорость " + wheel.getRotationSpeed() + " км/ч");
                }
                case -1 -> {
                    switch (selectCar) {
                        case "Renault" -> wheel.setRotationSpeed(20);
                        case "BMW" -> wheel.setRotationSpeed(40);
                        case "Lamborghini" -> wheel.setRotationSpeed(50);
                    }
                    System.out.println("Задний ход. Скорость " + wheel.getRotationSpeed() + " км/ч");
                }
            }
        }
    }

    public void TestDrive() {
        drive();
        startEngine();
        turnOnGear(0); drive();
        turnOnGear(-1); drive();
        turnOnGear(1); drive();
        turnOnGear(2); drive();
        turnOnGear(3); drive();
        turnOnGear(4); drive();
        turnOnGear(5); drive();
        stopEngine(); drive();
    }
}

public class task2 {
    public static void main(String[] args) {
        Car car1 = new Car(carList.Renault.toString());
        Car car2 = new Car(carList.BMW.toString());
        Car car3 = new Car(carList.Lamborghini.toString());

        System.out.println("1 - Renault Clio");
        System.out.println("2 - BMW M3 E46");
        System.out.println("3 - Lamborghini Huracan Evo");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите автомобиль: ");
        int menu = scanner.nextInt();
        System.out.println();
        switch (menu) {
            case 1 -> car1.TestDrive();
            case 2 -> car2.TestDrive();
            case 3 -> car3.TestDrive();
        }
    }
}