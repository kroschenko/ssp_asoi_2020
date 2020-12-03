package com.company;

public class Main {

    public static void main(String[] args) {
	Rectangle one = new Rectangle();
	Rectangle two = new Rectangle();

	one.setW(500);
	one.setH(500);
	two.setW(5);
	two.setH(500);

	one.info();
	two.info();
	one.isExist();
	one.equals(two);
	one.area();
	one.perimeter();
	one.isSquare();
    }
}
class Rectangle {
        int width;
        int height;

        Rectangle() {
        width = 1;
        height = 1;
        }
        Rectangle(int a) {
        width = a;
        height = 1;
        }
        Rectangle(int a, int b) {
        width = a;
        height = b;
        }

        void info() {
        System.out.println("W: " + width);
        System.out.println("H: " + height);
        }
        void setW(int a) {
        width = a;
        }
        void setH(int a) {
        height = a;
        }
        void isSquare() {
                if(width == height) {
                        System.out.println("Да, это квадрат");
                } else {
                        System.out.println("Нет, это не квадрат");
                }
        }
        void isExist() {
                if(width == 0 || height == 0) {
                        System.out.println("Такой прямоугольник невозможен!");
                } else {
                        System.out.println("Такой прямоугольник возможен!");
                }
        }
        void area() {
                System.out.println(width*height);
        }
        void perimeter() {
                System.out.println(width*2+height*2);
        }
        void equals(Rectangle obj) {
                if((obj.width == width && obj.height == height) ||(obj.width == height && obj.height == width)) {
                        System.out.println("Равны");
                } else {
                        System.out.println("Не равны");
                }
        }


}


