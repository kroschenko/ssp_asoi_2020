package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter file path:");
        String name = scanner.nextLine();
        File file = new File(name);

        scanner = new Scanner(file, "utf-8");

        while(scanner.hasNext())
        {
             String words = scanner.nextLine();
             String[] mas = words.split(" ");

             words = "";

             for(int i=mas.length-1; i>=0; i--)
                 words+=mas[i]+" ";

             System.out.println(words);

        }

    }
}
