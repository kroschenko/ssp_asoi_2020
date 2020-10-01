package com.company;

public class Main {

    public static void main(String[] args) {
        int array[];
        long array1[];
        array = new int[args.length];
        array1 = new long[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
            array1[i] = Long.parseLong(args[i]);
        }
        System.out.println(getMaxMin(array));
        removeElement(array1, 2);
        System.out.println(randomString(50, false));
    }

    public static int getMaxMin(int[] inputArray) {
        int maxValue = inputArray[0];
        int minValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (maxValue < inputArray[i]) maxValue = inputArray[i];
            if (minValue > inputArray[i]) minValue = inputArray[i];
        }
        return maxValue - minValue;
    }

    public static long[] removeElement(long[] array, long element) {
        long searchElement = element;
        int j = 0;
        for (j = 0; j < array.length; j++) {
            if (array[j] == searchElement) {
                break;
            }
        }
        for (int k = j; k < array.length - 1; k++)
            array[k] = array[k + 1];
        for (int g = 0; g < array.length - 1; g++)
            System.out.print(array[g] + " ");
        return array;
    }

    public static String randomString(int lenght, boolean asciiOnly) {
        StringBuilder builder = new StringBuilder();
        if (asciiOnly == true) {
            int a = 0;
            int b = 127;
            for (int i = 0; i < lenght; i++) {
                builder.append((char) (a + (int) (Math.random() * b)));
            }
        } else {
            int a = 0;
            int b = 65536;
            for (int i = 0; i < lenght; i++) {
                builder.append((char) (a + (int) (Math.random() * b)));
            }

        }
        return builder.toString();
    }
}
