package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Repository
{
    HashMap<String, HashSet<Integer>> data = new HashMap<String, HashSet<Integer>>();


    public void addValue(String word, int rowNumber)
    {
        HashSet rowNumbers;

        if(!data.containsKey(word))
            rowNumbers = new HashSet<Integer>();
        else
            rowNumbers = data.get(word);

        rowNumbers.add(rowNumber);
        data.put(word,rowNumbers);
    }

    public void print()
    {
        for (HashMap.Entry<String, HashSet<Integer>> element : data.entrySet()) {
            System.out.print("word: " + element.getKey() + "  rows: ");

            HashSet rowNumbers = element.getValue();

            Iterator<HashSet> iterator = rowNumbers.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+" ");
            }

            System.out.println();

        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Repository repository = new Repository();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if(!file.exists())
        {
            System.out.println("Ошибка: файл не существует.");
            return;
        }

        Scanner fileScanner = new Scanner(file, "utf-8");

        int rowNumber = 0;

        while(fileScanner.hasNext())
        {
            String line = fileScanner.nextLine();
            line = line.replaceAll("[\\.\\,\\:\\;\\!\\?\\\"\\'\\*\\(\\)]", "");

            String[] words = line.split(" ");

            for(int i=0; i<words.length; i++)
                repository.addValue(words[i], rowNumber);

            rowNumber++;

        }

        fileScanner.close();

        repository.print();
    }
}
