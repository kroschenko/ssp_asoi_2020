package com.company;


public class Main {

    public static void main(String[] args) {
        int [] array=convertArray(args);
        int amount=args.length;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        for (int i = 0; i < amount; i++) {
            int leng = String.valueOf(array[i]).length();
            if (leng == 1) {
                count1++;
            }
            if (leng == 2) {
                count2++;
            }
            if (leng == 3) {
                count3++;
            }
            if (leng == 4) {
                count4++;
            }
            if (leng == 5) {
                count5++;
            }
            if (leng == 6) {
                count6++;
            }
            if (leng == 7) {
                count7++;
            }
            if (leng == 8) {
                count8++;
            }
            if (leng == 9) {
                count9++;
            }
            if (leng == 10) {
                count10++;
            }
        }
        System.out.println("Count 1 digital " + count1 +
                "\nCount 2 digital " + count2 +
                "\nCount 3 digital " + count3 +
                "\nCount 4 digital " + count4 +
                "\nCount 5 digital " + count5 +
                "\nCount 6 digital " + count6 +
                "\nCount 7 digital " + count7 +
                "\nCount 8 digital " + count8 +
                "\nCount 9 digital " + count9 +
                "\nCount 10 digital " + count10);


            }
            public static int[] convertArray(String[] stringArray) {
                int[] result= new int[stringArray.length];
                for (int i = 0; i < result.length; ++i ){
                    result[i] = Integer.parseInt(stringArray[i]);
                System.out.println(result[i]);
                }
                return result;
            }
        }
