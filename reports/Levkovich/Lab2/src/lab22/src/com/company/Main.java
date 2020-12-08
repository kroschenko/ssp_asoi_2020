package com.company;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {
        String errorStr = "Ошибка: неверно переданы аргументы";
        String fileErrorStr = "Ошибка: файл не найден";

        int rowCount = 10;

        if (args.length == 2)
        {
            try {
                rowCount = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(errorStr);
                return;
            }
        }
        else if (args.length == 3)
        {
            if (!args[0].equals("-n")) {
                System.out.println(errorStr);
                return;
            }

            try {
                rowCount = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println(errorStr);
                return;
            }
        }
        else if(args.length<1 || args.length>3)
        {
            System.out.println(errorStr);
            return;
        }


        try {
            RandomAccessFile file = new RandomAccessFile(args[args.length - 1], "r");

            String currentStr;

            for(int i=0; i<rowCount; i++)
            {
                currentStr = file.readLine();

                if(currentStr==null)
                    break;
                else
                    System.out.println(currentStr);
            }

        } catch (FileNotFoundException e) {
            System.out.println(fileErrorStr);
        }
    }
}
