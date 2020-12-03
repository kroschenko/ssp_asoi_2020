package com.company;

class Triangle
{
    double gipotenyza;
    double katet1, katet2;

    public Triangle(double gipotenyza, double katet1, double katet2) {
        this.gipotenyza = gipotenyza;
        this.katet1 = katet1;
        this.katet2 = katet2;
    }

    public Triangle() {
        gipotenyza = katet1 = katet2 = 0;
    }

    public boolean isExists() {
        if(gipotenyza <=0 || katet1 <= 0 || katet2 <= 0)
            return false;

        if(Math.pow(katet1, 2)+ Math.pow(katet2, 2) != Math.pow(gipotenyza, 2))
            return false;

        return true;
    }

    public double getPerimeter() {
        return gipotenyza + katet1 + katet2;
    }

    public double getSquare() {
        return katet1*katet2*0.5;
    }

    public String toString() {
        return "katet1="+katet1+", katet2="+katet2+", gipotenyza="+gipotenyza;
    }

    public boolean equals(Triangle other) {
        if(other.gipotenyza == gipotenyza) {

            if(other.katet1 == katet1 && other.katet2 == katet2)
                return true;
            else if(other.katet1 == katet2 && other.katet2 == katet1)
                return true;
        }

        return false;
    }

    public void setKatet1(double katet1){
        this.katet1 = katet1;
    }

    public double getKatet1(){
        return katet1;
    }

    public void setKatet2(double katet2){
        this.katet2 = katet2;
    }

    public double getKatet2(){
        return katet2;
    }

    public void setGipotenyza(double gipotenyza){
        this.gipotenyza = gipotenyza;
    }

    public double getGipotenyza(){
        return gipotenyza;
    }
}

public class Main {

    public static void main(String[] args) {
        Triangle t1 = new Triangle(5, 3, 4);
        System.out.println(t1.toString());

        System.out.println("Perimeter "+t1.getPerimeter());
        System.out.println("Square "+t1.getSquare());

        Triangle t2 = new Triangle();
        t2.setGipotenyza(5);
        t2.setKatet1(4);
        t2.setKatet2(3);

        System.out.println("t1 equals t2 - "+ t1.equals(t2));

        t2.setKatet2(4);

        System.out.println("exists triangle t2 - "+t2.isExists());

        System.out.println("t1 equals t2 - "+ t1.equals(t2));
    }
}
