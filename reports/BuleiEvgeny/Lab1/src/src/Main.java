import java.util.Arrays;

public class Main {
    public static void main( String[] args) {
        double[] arr = new double[args.length];
        for(int i = 0; i<args.length; i++)
            arr[i]=Double.parseDouble(args[i]);
        function1(arr);
        reverse(new double[]{3,8,1,5,9,7,2});
        if(polindrome("А лис, он умён - крыса сыр к нему носила.")) {
            System.out.println("this is polindrome");
        }else System.out.println("this is'n polindrome");

    }
    public static void function1(double[] arr){
        double max, min,sum,proiz;
        max = min =sum=proiz= arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]) max=arr[i];
            if(min>arr[i]) min=arr[i];
            sum=sum+arr[i];
            proiz=proiz*arr[i];
        }
        System.out.println("max="+max+"\nmin="+min+"\nsum="+sum+"\ncomp="+proiz);
    }
    public static void reverse(double[] arr){
        double[] newArr = new double[arr.length];
        for(int i=0,j=arr.length-1;i<newArr.length;i++,j--){
            newArr[i]=arr[j];
        }
        System.out.print("Reserve array ");
        for(int z=0;z<newArr.length;z++)
            System.out.print(" "+newArr[z]);
        System.out.println();
    }

    public static boolean polindrome(String str) {
       str = str.toLowerCase();
       String result = str.replaceAll("[^а-яА-ЯёЁ]|\\s","");
       String result2 = result.replaceAll("[ё]","е");
       for(int i = 0; i< result2.length()/2;i++){
           if(result2.charAt(i)!=result2.charAt(result2.length()-i-1)){
               return false;
           }
       }
       return true;
    }
}
