package com.company;

class Triangle
{
    double rebro;

    public Triangle()
    {
        this.rebro = 5;
    }

    public Triangle(double rebro)
    {
        this.rebro = rebro;
    }

    public void setRebro(double rebro)
    {
        this.rebro = rebro;
    }

    public double getRebro()
    {
        return this.rebro;
    }

    public double perimeter()
    {
        return rebro*3;
    }

    public double square()
    {
        return Math.pow(rebro, 2)*Math.sqrt(3) / 4;
    }

    public boolean checkExists()
    {
        if(rebro>0)
            return true;
        else
            return false;
    }

    public boolean equals(Triangle triangle)
    {
        return rebro == triangle.rebro;
    }

    public String toString()
    {
        return "Triangle, rebro = "+rebro;
    }
}

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.toString());

        Triangle triangle2 = new Triangle(7);

        System.out.println("perimeter "+triangle2.perimeter());
        System.out.println("square "+triangle2.square());

        System.out.println("Vtoroy treugolnik suchestvuet  "+ triangle2.checkExists());

        System.out.println("vtoroy treugolnik raven pervomy  "+triangle2.equals(triangle));

        Triangle triangle3 = new Triangle();
        triangle3.setRebro(7);

        System.out.println("vtoroy treugolnik raven tret'emu  "+triangle2.equals(triangle3));
    }
}
