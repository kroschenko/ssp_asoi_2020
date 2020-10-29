package com.company;

public class Main {
    public static void zad1(int[] array){
        System.out.println();
        int summa = 0;
        int proizv = 1;
        int max = array[0];
        int min = array[0];
        for (int i=0;i<array.length;i++){
            summa += array[i];
            proizv *= array[i];
            if(array[i]>max) max=array[i];
            if(array[i]<min) min=array[i];
        }

        System.out.println("Summa=" +summa);
        System.out.println("Proizv=" +proizv);
        System.out.println("Max=" +max);
        System.out.println("Min=" +min);
    }
    public static void reverse(int[] array){
        System.out.println();

        System.out.print("reverse arr:");
        int temp;
        for (int i= array.length-1,j=0;i>= array.length/2;i--,j++){
            temp = array[j];
            array[j]=array[i];
            array[i]=temp;
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]);

        }

    }
    public static boolean polindrome(String str){
        str=str.toLowerCase();
        String result = str.replaceAll("[^а-яА-ЯёЁ ]|\\s", "");
        String result2 = result.replaceAll("[ё ]", "е");
        System.out.print(result2);
        System.out.println();
        int n = result2.length();
        for (int i=0;i<n/2;++i){
            if(result2.charAt(i)!=result2.charAt(n-i-1)){
                return false;

            }

        }
        return true;


    }
    public static void main(String[] args) {
        int array[];
        array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
            System.out.println(array[i]);
        }

        zad1(array);
        reverse(array);
        System.out.println();
        if(polindrome("А лис, он умён – крыса сыр к нему носила")){
            System.out.print("Palindrome");
        }
        else{
            System.out.print("Not palindrome");
        }
    };

}
