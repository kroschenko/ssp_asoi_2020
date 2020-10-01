package com.company;

public class Main {

    public static void main(String[] args) {
	double [] array = convertArray(args);
	shiftLeft(array, 15 );
    }

    public static double[] convertArray(String[] stringArray) {
        double[] result= new double[stringArray.length];
        for (int i = 0; i < result.length; ++i ){
            result[i] = Double.parseDouble(stringArray[i]);
            System.out.println(result[i]);
        }
        return result;
    }

    static void shiftLeft(double[] array, int shift){
        System.out.println("");
        int count  = array.length;

        double[] newArr = new double[array.length];

        for(int i = 0; i<=count-1;i++){
            if (i+shift >= count){
                int ostatok = (i+shift)%count;
                newArr[i] = array[ostatok];
            }
            else {
                newArr[i] = array [i+shift];
            }
        }
        for (double i : newArr){
            System.out.println(i);
        }


    }
}
