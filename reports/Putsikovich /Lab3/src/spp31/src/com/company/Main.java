package com.company;

class IsoscelesTriangle
{
    private double basis; //основание
    private double side; //две боковые равные стороны

    public IsoscelesTriangle()
    {
        basis = 0;
        side = 0;
    }

    public IsoscelesTriangle(double basis, double side)
    {
        this.basis = basis;
        this.side = side;
    }

    public double getBasis()
    {
        return basis;
    }

    public double getSide()
    {
        return side;
    }

    public void setBasis(double basis)
    {
        this.basis = basis;
    }

    public void setSide(double side)
    {
        this.side = side;
    }

    public boolean isExist()
    {
        if(2*side>basis && basis+side>side)
            return true;
        else
            return false;
    }

    public double getSquare()
    {
        double h = Math.sqrt( Math.pow(side, 2) - Math.pow(basis/2, 2) );

        return basis*h/2;
    }

    public double getPerimeter()
    {
        return basis + 2*side;
    }

    public boolean equals(IsoscelesTriangle otherIsoscelesTriangle)
    {
        if(basis == otherIsoscelesTriangle.basis && side == otherIsoscelesTriangle.side && basis>0 && side>0)
            return true;
        else
            return false;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("IsoscelesTriangle { basis: ");
        builder.append(basis);
        builder.append(", side: ");
        builder.append(side);
        builder.append(" }");

        return builder.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        IsoscelesTriangle triangleNotExist = new IsoscelesTriangle(5, 2);

        System.out.println("triangleNotExist exists? "+triangleNotExist.isExist());

        IsoscelesTriangle triangleEmpty = new IsoscelesTriangle();
        System.out.println(triangleEmpty.toString());

        System.out.println("triangleEmpty exists? "+triangleEmpty.isExist());

        IsoscelesTriangle triangle = new IsoscelesTriangle(4, 3);

        triangle.setBasis(7);
        triangle.setSide(5);
        System.out.println("triangle basis: "+triangle.getBasis());
        System.out.println("triangle side: "+triangle.getSide());

        System.out.println("triangle exists? "+triangle.isExist());

        System.out.println("triangle square: "+triangle.getSquare());
        System.out.println("triangle perimeter: "+triangle.getPerimeter());

        IsoscelesTriangle triangleEqual = new IsoscelesTriangle(7, 5);

        System.out.println("triangle = triangleEqual ? "+triangle.equals(triangleEqual));
        System.out.println("triangle = triangleNotExist ? "+triangle.equals(triangleNotExist));
    }
}
