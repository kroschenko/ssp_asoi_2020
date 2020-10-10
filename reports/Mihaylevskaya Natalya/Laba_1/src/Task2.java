public class Task2 {
public static void main (String [] args){
    int []arr = new int [args.length]; 
    int [][] arr2= {{1,2,3},{2,3,1},{2,1,3}};
    for (int i=0; i< args.length; i++){
        arr[i]= Integer.parseInt(args[i]);
    }
        func1(arr);
        func2(arr2);
    }   
    public static void func1(int [] arr){
    }
    public static void func2(int [][] arr2){
        int []res=new int[arr2.length*arr2[0].length];
        int z=0;
        for(int i=0; i<arr2.length;i++){
            for(int j=0; j< arr2[i].length;j++){
                res[z]=arr2[i][j];
                z++;
            }
        }   
        for (int i=0; i<z;i++)
            System.out.print(" " + res[i]);
    }   
}   
