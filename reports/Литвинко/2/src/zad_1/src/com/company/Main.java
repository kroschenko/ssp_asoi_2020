package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        String path = inputScanner.nextLine();

        File file = new File(path);

        Scanner fileScanner;

        try {
            fileScanner = new Scanner(file, "utf-8");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Не удаётся открыть файл");
            return;
        }

        String fileData = "";

        while(fileScanner.hasNext())
            fileData += fileScanner.nextLine();

        fileData = fileData.replaceAll("[^A-Za-zА-Яа-я ёЁ]", "");


        String[] words = fileData.split(" ");

        int maxWordLength = 0;

        for(int i=0; i<words.length; i++)
            if(words[i].length()>maxWordLength)
                maxWordLength = words[i].length();

        int[] lengthsOfWords = new int[maxWordLength+1];

        for(int i=0; i<lengthsOfWords.length; i++)
            lengthsOfWords[i] = 0;

        for(int i=0; i<words.length; i++)
            lengthsOfWords[words[i].length()]++;

        System.out.println("Букв в слове      Количество случаев");

        for(int i=1; i<lengthsOfWords.length; i++)
            if(lengthsOfWords[i]>0)
                 System.out.println(i+"                 "+lengthsOfWords[i]);
    }
}
