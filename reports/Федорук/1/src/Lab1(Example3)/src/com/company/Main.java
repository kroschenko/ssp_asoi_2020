package com.company;

public class Main {

    public static void main(String[] args) {
        String str1 = args[0];
        String str2 = args[1];
        String res = xor(str1, str2);
        System.out.println("First string:");
        System.out.println(str1);
        System.out.println("Second string:");
        System.out.println(str2);
        System.out.println("Result string:");
        System.out.println(res);
   }



    static String xor(String str1, String str2){
        int length;
        String result="";
        char buffer1;
        char buffer2;
        if(str1.length()>=str2.length())
            length=str1.length();
        else{
            length=str2.length();
        }

        for (int i = 0; i<length;i++){
           buffer1 = str1.charAt(i);
           buffer2 = str2.charAt(i);
           if (buffer1!=buffer2)
               result+=1;
           else{
               result+=0;
           }
        }
        return result;
    }
}
