import java.util.Objects;

import static java.lang.Math.*;

public class EquilTriangle {
    private double a;

    public EquilTriangle() {
        a = 1;
    }

    public EquilTriangle(double a){
        this.a = a;
    }

    public boolean isTriangle(){
        if(a<=0) return false;
        return true;
    }

    public double perimeter(){
        return 3*a;
    }

    public double square(){
        return a*a*sqrt(3)/4;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "EquilTriangle{" +
                "a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquilTriangle)) return false;
        EquilTriangle that = (EquilTriangle) o;
        return Double.compare(that.a, a) == 0;
    }

}
