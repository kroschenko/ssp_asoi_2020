package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enther filename:");
        String path = scan.nextLine();

        File file = new File(path);
        try {
            scan = new Scanner(file, "utf-8");
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }

        HashSet<String> elements = new HashSet<String>();

        String[] elementsMas;
        while(scan.hasNextLine())
        {
            elementsMas = scan.nextLine().split(" ");

            for(int i=0; i<elementsMas.length; i++)
                elements.add(elementsMas[i]);
        }

        ArrayList<String> sorted = new ArrayList<>(elements);
        Collections.sort(sorted);

        for(int i=0; i<sorted.size(); i++)
            System.out.println(sorted.get(i));
    }
}
