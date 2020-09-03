package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        if ( args.length == 0)
        throw new Exception ( "Count of arguments must be greater then 0" );
        double sum = 0, midle =0;

        double[] arr = convertArray(args);
        if (args.length%2 == 1) {

        midle=arr[args.length/2];
        sum=0;
        } else {
            for (int i=args.length/2;i> (args.length/2)-2;i--)
                sum+=arr[i];
        midle=sum/2;
        sum=0;
        }

        System.out.println("middle = " + midle);
    }

    public static double [] convertArray (String [] strArray)
    {
        double [] result = new double [strArray.length] ;
        for ( int i =0; i<result.length; ++i)
        result [i] = Double.parseDouble ( strArray [ i ] );
        return result;
    }

}
