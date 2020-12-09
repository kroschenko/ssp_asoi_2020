package com.company;


import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        System.out.println("1 - Вывести список вариантов");
        System.out.println("2 - Вывести список, отсортированный по цене");
        System.out.println("3 - Включить режим сортировки");
        System.out.println("4 - Выход");
        Scanner input = new Scanner(System.in);
        int menu = input.nextInt();
        switch (menu){
            case 1:{
                mobile.printMobile();
                break;
            }
            case 2:{
                mobile.sortFromPrice();
                break;
            }
            case 3:{
                mobile.sort();
                break;
            }
            case 4:{

            }
        }
    }
}
