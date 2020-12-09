package com.company;


enum privod {
    Front_Wheel,
    Rear,
    Four_Wheel
}

public class Car {
    Wheel wheel = new Wheel() ;
    String setPrivod;
    boolean isEngineStarted = false;
    int turnGear;
    int [] gear = {0,1,2,3,4,5,-1};

    public Car(String setPrivod) {
        this.setPrivod = setPrivod;
    }

    public boolean isEngineStarted() {
        return isEngineStarted;
    }

    public void setEngineStarted(boolean engineStarted) {
        isEngineStarted = engineStarted;
    }

    public int[] getGear() {
        return gear;
    }

    public void setGear(int[] gear) {
        this.gear = gear;
    }

    public boolean startEngine(){
        setEngineStarted(true);
        return isEngineStarted;
    }

    public int turnOnGear(int gear){
        turnGear=gear;
        return turnGear;
    }

    public void motion(){
        if(isEngineStarted==false){
            System.out.println("Сперва запустите двигатель");
        }else {
            if (turnGear == gear[0]) {
                System.out.println("Вы не включили передачу");
            }
            else {
                switch (turnGear){
                    case 1:{
                        if(setPrivod=="Front_Wheel"||setPrivod=="Rear") {
                            wheel.setRotationSpeed(10);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+" км/ч");
                        }else{
                            wheel.setRotationSpeed(15);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed() + " км/ч");
                        }
                        break;
                    }
                    case 2:{
                        if(setPrivod=="Front_Wheel"||setPrivod=="Rear") {
                            wheel.setRotationSpeed(20);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }else{
                            wheel.setRotationSpeed(30);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }
                        break;
                    }
                    case 3:{
                        if(setPrivod=="Front_Wheel"||setPrivod=="Rear") {
                            wheel.setRotationSpeed(40);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }else{
                            wheel.setRotationSpeed(60);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }
                        break;
                    }
                    case 4:{
                        if(setPrivod=="Front_Wheel"||setPrivod=="Rear") {
                            wheel.setRotationSpeed(80);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }else{
                            wheel.setRotationSpeed(120);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }
                        break;
                    }
                    case 5:{
                        if(setPrivod=="Front_Wheel"||setPrivod=="Rear") {
                            wheel.setRotationSpeed(120);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }else{
                            wheel.setRotationSpeed(160);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }
                        break;
                    }
                    case -1:{
                        if(setPrivod=="Front_Wheel"||setPrivod=="Rear") {
                            wheel.setRotationSpeed(-10);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }else{
                            wheel.setRotationSpeed(-15);
                            System.out.println("Вы движетесь со скоростью " + wheel.getRotationSpeed()+ " км/ч");
                        }
                        break;
                    }
                }
            }
        }

    }
}

class Wheel {
    int rotationSpeed = 0;

    public int getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(int rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public int returnRotationSpeed(){
        return rotationSpeed;
    }
}
