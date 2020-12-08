import java.util.Objects;

public class Rectangle {

    double a, b;

    public Rectangle(){
        this.a=3;
        this.b=5;
    }

    public Rectangle(double a, double b){
        this.a=a;
        this.b=b;

    }
    public double perimeter(){
        return 2*a+2*b;
    }
    public double square(){
        return a*b;
    }
    public boolean isItSquare(){
        if(a==b) return true;
        return false;
    }
    public boolean checkForExistence(){
        if(a<=0 || b<=0) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.a, a) == 0 &&
                Double.compare(rectangle.b, b) == 0;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
