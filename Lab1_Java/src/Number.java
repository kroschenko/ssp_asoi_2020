import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import java.lang.String;
public class Number {
    public static void main(String[] args){
        System.out.println("Введенная строка: ");
        for(int q=0;q<args.length;q++)
            System.out.println(args[q]);
        double[] myArray = convertArray(args);
        System.out.println(" ");
        System.out.println("Наиболее часто повторяющиеся числа: ");
        for(int i=0;i<myArray.length;i++){
            for(int j=i+1; j<myArray.length;j++) {
                if (myArray[i] == myArray[j]) {
                    System.out.println(myArray[j]);
                }
            }
        }
        System.out.println(" ");
        System.out.println("Полученный результат со сдвигом вправо: ");
        double[] result = shiftRigth(myArray,5);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public static double [ ] convertArray (String [] stringArray)
    {
        double [] result = new double [stringArray.length] ;
        for ( int i =0; i<result.length ; ++i )
            result [i] = Double.parseDouble(stringArray[i]) ;
        return result;
    }

    public static double [ ] shiftRigth (double[] array,int shift){
        double[] outputArray = new double[array.length+shift];
        for(int i=shift;i<outputArray.length;i++){
            outputArray[i]=array[i-shift];
        }
        return outputArray;
    }
}


