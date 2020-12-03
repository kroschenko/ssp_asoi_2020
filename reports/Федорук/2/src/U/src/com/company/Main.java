package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> firstFile = Files.readAllLines(Paths.get("File1.txt"), Charset.defaultCharset());
        List<String> secondFile = Files.readAllLines(Paths.get("File2.txt"), Charset.defaultCharset());

        FileWriter writer = new FileWriter("File3.txt");


        int first = Integer.parseInt(args[1]);
        int second = Integer.parseInt(args[2]);
        int length = firstFile.size();
        int length1 = 0;
        int length2 = 0;

        String str1;
        String str2;

        int index1;
        int index2;

        char[] st111 = new char[10];
        char[] st121 = new char[10];
        char[] st211 = new char[10];
        char[] st221 = new char[10];

        char[] st112 = new char[10];
        char[] st122 = new char[10];
        char[] st212 = new char[10];
        char[] st222 = new char[10];

        char[] st113 = new char[10];
        char[] st123 = new char[10];
        char[] st213 = new char[10];
        char[] st223 = new char[10];

        char[] st114 = new char[10];
        char[] st124 = new char[10];
        char[] st214 = new char[10];
        char[] st224 = new char[10];


        if (first == 1 && second == 1) {
            for (int i = 0; i < length; i++) {
                str1 = firstFile.get(i);
                str2 = secondFile.get(i);
                length1 = str1.length();
                length2 = str2.length();
                index1 = str1.indexOf(' ');
                index2 = str2.indexOf(' ');
                str1.getChars(0, index1, st111, 0);
                str2.getChars(0, index2, st211, 0);
                str1.getChars(index1, length1, st121, 0);
                str2.getChars(index2, length2, st221, 0);
                if (Arrays.equals(st111, st211)) {
                    writer.write(st111);
                    writer.write(st121);
                    writer.write(st221);
                    writer.write("\n");
                }
            }
        }
        if (first == 1 && second == 2) {
            for (int i = 0; i < length; i++) {
                str1 = firstFile.get(i);
                str2 = secondFile.get(i);
                length1 = str1.length();
                length2 = str2.length();
                index1 = str1.indexOf(' ');
                index2 = str2.indexOf(' ');
                str1.getChars(0, index1, st112, 0);
                str2.getChars(0, index2, st212, 0);
                str1.getChars(index1, length1, st122, 0);
                str2.getChars(index2 + 1, length2, st222, 0);
                if (Arrays.equals(st112, st222)) {
                    writer.write(st112);
                    writer.write(st122);
                    writer.write(st212);
                    writer.write("\n");
                }
            }
        }
        if (first == 2 && second == 1) {
            for (int i = 0; i < length; i++) {
                str1 = firstFile.get(i);
                str2 = secondFile.get(i);
                length1 = str1.length();
                length2 = str2.length();
                index1 = str1.indexOf(' ');
                index2 = str2.indexOf(' ');
                str1.getChars(0, index1, st113, 0);
                str2.getChars(0, index2, st213, 0);
                str1.getChars(index1 + 1, length1, st123, 0);
                str2.getChars(index2, length2, st223, 0);
                System.out.println(st213);
                if (Arrays.equals(st123, st213)) {
                    writer.write(st123);
                    writer.write(st113);
                    writer.write(st213);
                    writer.write("\n");
                }
            }
        }

        if (first == 2 && second == 2) {
            for (int i = 0; i < length; i++) {
                str1 = firstFile.get(i);
                str2 = secondFile.get(i);
                //System.out.print(str1);
                length1 = str1.length();
                length2 = str2.length();
                index1 = str1.indexOf(' ');
                index2 = str2.indexOf(' ');
                str1.getChars(0, index1, st114, 0);
                str2.getChars(0, index2, st214, 0);
                str1.getChars(index1, length1, st124, 0);
                str2.getChars(index2, length2, st224, 0);
                //System.out.println(st224);
                if (Arrays.equals(st124, st224)) {
                    System.out.print(st124);
                    System.out.print(" ");
                    System.out.print(st114);
                    System.out.print(" ");
                    System.out.print(st214);
                    writer.write(st124);
                    writer.write(st114);
                    writer.write(st214);
                    writer.write("\n");
                }
            }
        }
        writer.close();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
