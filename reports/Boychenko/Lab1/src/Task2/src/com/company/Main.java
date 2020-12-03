package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
        if (args.length==0)
            throw new Exception("Count of arguments must be greater then 0");
        double[] array=convertArray(args);
        int startIndex= Integer.parseInt(args[args.length-2]);
        int endIndex= Integer.parseInt(args[args.length-1]);
        double []SubArray=subarray(array, startIndex, endIndex);
        for (int i=0; i< SubArray.length; i++)
            System.out.print(SubArray[i]+" ");
    }
    public static double[] subarray(double[] array, int startIndex, int endIndex) throws Exception
    {
        if (startIndex>=endIndex)
            throw new Exception("End index must be greater start index");
        if (startIndex>=array.length-2 || endIndex<0)
            throw new Exception("Error: out of range");
        double [] result=new double[endIndex-startIndex];
        for(int i=0, j=startIndex-1; j<endIndex-1; i++, j++)
            result[i]=array[j];
        return result;
    }
    public static double[] convertArray(String[] stringArray)
    {
        double[] result =new double[stringArray.length];
        for(int i=0; i< stringArray.length-2; i++)
            result[i]=Double.parseDouble(stringArray[i]);
        return result;
    }
}
