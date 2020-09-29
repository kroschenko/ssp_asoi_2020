package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        if ( args.length < 5)
        throw new Exception ( "Count of arguments must be greater then 5" );
        System.out.print(fTask(args) + "\n");
        double [] output = add(convertArray(args),getIndex(args),getElement(args));
        System.out.print("The result of adding "+ getElement(args) +" with index = "+ getIndex(args) +": \n");
        for (int i=0;i< output.length;i++)
            System.out.print(output[i]+" ");
        System.out.print("\nYour string from symbol ("+ getSymbol(args) +") with "+ getRepeats(args) +" repeats: \n"+repeat(getSymbol(args),getRepeats(args)));
    }

    private static double fTask(String [] input) {
        double sum = 0, midle;
        double[] arr = convertArray(input);
        if (arr.length%2 == 1) {
            System.out.print("Your median sequence of an odd series of numbers is ");
            midle=arr[arr.length/2];
        } else {
            for (int i=arr.length/2;i> (arr.length/2)-2;i--)
                sum+=arr[i];
            midle=sum/2;
            System.out.print("Your median sequence of an even series of numbers is ");
        }
        return midle;
    }

    private static double [] convertArray (String [] strArray)
    {
        double [] result = new double [strArray.length-4] ;
        for ( int i =0; i<result.length; ++i)
        result [i] = Double.parseDouble ( strArray [ i ] );
        return result;
    }

    private static int getIndex(String [] arr) {
    return Integer.parseInt(arr[arr.length-4]);
    }

    private static double getElement(String [] arr) {
        return Double.parseDouble(arr[arr.length-3]);
    }

    private static int getRepeats(String [] arr) {
        return Integer.parseInt(arr[arr.length-2]);
    }

    private static char getSymbol(String [] arr) {
        String symbol = arr[arr.length-1];
        return symbol.charAt(0);
    }

    private static double[] add (double [] array, int index, double element) {
        int size = Math.max(array.length,index);
        double [] output = new double[size];
        for (int i =0;i<array.length;i++)
            output[i]=array[i];
        output[index-1] = element;
        return output;
    }

    private static String repeat(char ch, int repeat) {
        StringBuilder stringch = new StringBuilder();
        for (int i=0;i<repeat;i++)
            stringch.append(ch);
        return stringch.toString();
    }

}
