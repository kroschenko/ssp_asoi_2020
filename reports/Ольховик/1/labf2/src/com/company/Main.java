package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        if ( args.length != 2 )
            throw new Exception ( "Wrong number of input arguments." );
        double [] test = {1.0, 2.0, 3.0, 4.0, 5.0};
        int index = Integer.parseInt(args[0]);
        double element = Double.parseDouble(args[1]);
        double [] output = add(test,index,element);
        System.out.print("The result of transformation \n");
        for (int i=0;i< output.length;i++)
            System.out.print(output[i]+" ");
    }

    public static double[] add (double [] array, int index, double element) {
        double [] output = new double[index+1];
        for (int i =0;i<array.length;i++)
            output[i]=array[i];
        output[index] = element;
        return output;
    }
}
