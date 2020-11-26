package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2 && args.length != 3) {
            System.out.println("ошибка - неправильное число аргументов");
            return;
        }

        String key = "", pathReadableFile = args[args.length - 2], pathWritableFile = args[args.length - 1];

        if (pathReadableFile.equals(pathWritableFile)) {
            System.out.println("ошибка - исходный и целевой файлы совпадают");
            return;
        }

        if (args.length == 3) {
            key = args[0];

            key = key.toLowerCase();

            String keyTemp = key.replaceAll("[-fin]", "");

            boolean repeat = false;

            for (int x = 0; x < key.length(); x++)
                for (int y = 0; y < key.length(); y++)
                    if (key.charAt(x) == key.charAt(y) && x != y) {
                        repeat = true;
                        break;
                    }

            if (key.length() < 2 || key.length() > 4 || key.charAt(0) != '-' || keyTemp.length() != 0 || repeat) {
                System.out.println("ошибка - неверный ключ");
                return;
            }

        }

        File writableFile = new File(pathWritableFile);

        Scanner scanner = new Scanner(System.in);

        if (writableFile.exists()) {
            if (key.contains("n")) {
                System.out.println("целевой файл уже существует");
                return;
            } else if (key.contains("i")) {
                System.out.println("Перезаписать существующий файл? Y - да");
                String answer = scanner.nextLine().toLowerCase();
                if (!answer.equals("y")) {
                    System.out.println("отменено");
                    return;
                }
            }
        }


        FileReader reader;
        FileWriter writer;

        try {
            reader = new FileReader(pathReadableFile);
        } catch (FileNotFoundException e) {
            System.out.println("ошибка - невозможно найти исходный файл");
            return;
        }

        try {
            writer = new FileWriter(pathWritableFile);
        } catch (IOException e) {
            if (key.contains("f")) {
                writableFile.delete();
                try {
                    writer = new FileWriter(pathWritableFile);
                } catch (IOException e2) {
                    System.out.println("ошибка - невозможно создать целевой файл");
                    return;
                }

            } else {
                System.out.println("ошибка - невозможно создать целевой файл");
                return;
            }
        }

        int symbol;

        do {
            try {
                symbol = reader.read();

                if (symbol != -1)
                    writer.write(symbol);
            } catch (IOException e) {
                System.out.println("ошибка - невозможно считать/записать данные");
                return;
            }

        }
        while (symbol != -1);


        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("непредвиденная ошибка");
            return;
        }

        System.out.println("успешно");
    }
}
