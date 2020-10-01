package com.company;

import java.util.Scanner;

public class Main {
    public static void part1(String[] args) {
        int intargs[] = new int[args.length];
        for(int i=0;i<args.length;i++) {
            intargs[i] = Integer.parseInt(args[i]);
        }
        int res = 0;
        for(int num :intargs) {
            if(num < 0) {
                res = res+num*num;
            }
        }
        System.out.println(res);
    }
    public static void part2(double a, double b, int size){
        double[][] mat = new double[size][size];
        for(int i=0;i<size;i++){
            for(int k=0;k<size;k++) {
                mat[i][k] = a+(Math.random()*(b-a));
                System.out.print(mat[i][k]+" ");
            }
            System.out.println();
        }
    }
    public static void part3(String str){
        if(str != null){
            char strarray[] = str.toCharArray();
            for(char e :strarray) {
                if(String.valueOf(e).toLowerCase().equals(String.valueOf(e))) {
                    System.out.print(String.valueOf(e).toUpperCase());
                } else {
                  System.out.print(String.valueOf(e).toLowerCase());
               }
            }
        }
    }
    public static void main(String[] args) {
        part1(args);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 of range: ");
        String a = in.nextLine();
        System.out.println("Enter 2 of range: ");
        String b = in.nextLine();
        System.out.println("Enter size : ");
        String c = in.nextLine();
        part2(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c));
        System.out.println("Enter str: ");
        String line = in.nextLine();
        part3(line);

    }
}
