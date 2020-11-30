package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        String str1,str2,str3,str4;
        //чтение и запись в массив существительных
        BufferedReader readerNoun = new BufferedReader(new FileReader("E:\\noun.txt"));


        ArrayList<String> noun = new ArrayList<String>();
        while((str1 = readerNoun.readLine()) != null ) {
                if (!str1.isEmpty()) {
                    noun.add(str1);
                }
            }
        String[] nouns = noun.toArray(new String[0]);

        //чтение и запись в массив глаголов
    BufferedReader readerVerb = new BufferedReader(new FileReader("E:\\verb.txt"));


    ArrayList<String> verb = new ArrayList<String>();
        while((str2 = readerVerb.readLine()) != null ) {
        if (!str2.isEmpty()) {
            verb.add(str2);
        }
    }
    String[] verbs = verb.toArray(new String[0]);


        //чтение и запись в массив предлогов

    BufferedReader readerPreposition = new BufferedReader(new FileReader("E:\\preposition.txt"));


    ArrayList<String> preposition = new ArrayList<String>();
        while((str3 = readerPreposition.readLine()) != null ) {
        if (!str3.isEmpty()) {
            preposition.add(str3);
        }
    }
    String[] prepositions = preposition.toArray(new String[0]);

        //чтение и запись в массив прилагательных

        BufferedReader readerAdjective = new BufferedReader(new FileReader("E:\\adjective.txt"));


        ArrayList<String> adjective = new ArrayList<String>();
        while((str4 = readerAdjective.readLine()) != null ) {
            if (!str4.isEmpty()) {
                adjective.add(str4);
            }
        }
        String[] adjectives = adjective.toArray(new String[0]);

        //вывод предложений
        for (int i=0;i<20;i++){
            int number1= (int) (Math.random()*10);
            int number2= (int) (Math.random()*10);
            int number3= (int) (Math.random()*10);
            int number4= (int) (Math.random()*10);
            int number5= (int) (10 + Math.random()*10);
            System.out.println(nouns[number1]+" "+verbs[number2]+" "+prepositions[number3]+" "+adjectives[number4]+" "+nouns[number5]+".");
        }
    }


}

