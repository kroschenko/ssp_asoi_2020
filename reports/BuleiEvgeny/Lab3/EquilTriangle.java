import java.util.Objects;

import static java.lang.Math.*;

public class EquilTriangle {
    private double a;
    private double b;
    private double c;

    public EquilTriangle() {
        a = 0;
        b = 0;
        c = 0;
    }

    public EquilTriangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isTriangle(){
        if((a+b)<=c) return false;
        if((a+c)<=b) return false;
        if((b+c)<=a) return false;
        return true;
    }

    public double perimeter(){
        return a+b+c;
    }

    public double square(){
        return a*b*sqrt(3)/4;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquilTriangle)) return false;
        EquilTriangle that = (EquilTriangle) o;
        return Double.compare(that.a, a) == 0 &&
                Double.compare(that.b, b) == 0 &&
                Double.compare(that.c, c) == 0;
    }

    @Override
    public String toString() {
        return "EquilTriangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
