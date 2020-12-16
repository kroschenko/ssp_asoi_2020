package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int nums [] = new int [args.length];
        for (int i = 0; i< args.length; ++i){
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println(sr(nums));

        Scanner in2 = new Scanner(System.in);
        System.out.print("Input sentenses: ");
        String str = in2.next();
        System.out.println(capitalize(str));

        Scanner in = new Scanner(System.in);
        System.out.print("Input rows: ");
        int rows = in.nextInt();
        System.out.print("Input cols: ");
        int cols = in.nextInt();

        int[][] matrix = createMatrix(rows, cols);
        for (int[] line : matrix) {
            for (int elem : line) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }

    }

    public static int[][] createMatrix(int rows, int cols) {
        int array [][] = IntStream.range(0, rows)
                .mapToObj(i -> new Random()
                        .ints(cols, 0, 1)
                        .toArray())
                .toArray(int[][]::new);
       // int j = 0;
        for(int i = 0; i<rows; ++i){
          //  j += 1;
            array[i][i] = 1;
        }

        return array;
    }

    public static double sr(int [] strArray){
        double result [] = new double [strArray.length];
        int value = 0;
        double sr = 0;
        int big = 0;
        double raz = 0;
        for(int i = 0; i<result.length; ++i)
            value += strArray[i];
        sr = value/result.length;
        for (int i = 0; i<result.length; ++i){
            if (strArray[i]<sr){
                big+=1;
        }
        }
        raz = big*100/sr;

        return  raz;
    }

    public static String capitalize(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }
}
