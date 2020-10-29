public class Main {

    public static void main(String[] args) throws  Exception{
        if (args.length==0)
            throw new Exception("Count of arguments must be greater then 0");
        double[] array= convertArray(args);
        for(int i=0; i< array.length-1; i++)
            if (array[i]!=array[i+1]) {
                System.out.println("Не равны");
                break;
            }
            else if(array[i]==array[i+1] && i+2==array.length)
                System.out.println("Равны");
    }
    public static double[] convertArray(String[] stringArray)
    {
        double[] result =new double[stringArray.length];
        for(int i=0; i< stringArray.length; i++)
            result[i]=Double.parseDouble(stringArray[i]);
        return result;
    }
}
