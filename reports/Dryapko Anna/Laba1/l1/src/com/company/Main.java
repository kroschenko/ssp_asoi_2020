package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int [] arr2 = new int[] {-1,5,-1,1,-2,3,5,5,4,6,5,7,7};


        System.out.println("----------task1(" + Arrays.toString(arr2) + ")-----------");
        System.out.println("sum: " + task1(arr2));

        System.out.println("----------task2 from 1 to 2, size5----------- ");
        Arrays.toString(arr2);
        double[][] rez = task2(1,2,5);
        for(int i=0;i<rez.length;i++){
            System.out.print("" + Arrays.toString(rez[i]) + "\n");
        }

        System.out.println("----------task3(\"HeLLo wORLd\")-----------");
        System.out.println(task3("HeLLo wORLd"));

    }
    private static int task1(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i] < 0) sum += arr[i]*arr[i];
        return sum;
    }
    private static double [][] task2(int a, int b, int size){
        double [][]arr = new double[size][size];
        double r;
        for (int i = 0; i < size;  i++){
            for(int j =0; j<size;j++){
                arr[i][j] = a + Math.random() * (b-a);
            }

        }
        return arr;
    }
    private static String task3(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.toUpperCase(chars[i]) == chars[i] ?
                    Character.toLowerCase(chars[i]) :
                    Character.toUpperCase(chars[i]);

        }
        return new String(chars);
    }
}
