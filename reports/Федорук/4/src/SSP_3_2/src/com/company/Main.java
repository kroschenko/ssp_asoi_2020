package com.company;

public class Main {

    public static void main(String[] args) {
	Car car1 = new Car(privod.Four_Wheel.toString());
	Car car2 = new Car(privod.Rear.toString());
    Car car3 = new Car(privod.Front_Wheel.toString());
    car1.motion();
    car2.startEngine();
    car2.motion();
    car3.startEngine();
    car3.turnOnGear(0);
    car3.motion();
    car3.turnOnGear(1);
    car3.motion();
    car3.turnOnGear(2);
    car3.motion();
    car3.turnOnGear(3);
    car3.motion();
    car3.turnOnGear(4);
    car3.motion();
    car3.turnOnGear(5);
    car3.motion();
    car3.turnOnGear(-1);
    }
}
