package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {
        int length = 10;

        if (args.length == 0 || args.length > 3) {
            System.out.println("неверное число аргументов");
            return;
        }
        else {
            if (args.length == 2) {
                try {
                    length = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("неверные аргументы");
                    return;
                }

            } else if (args.length == 3) {
                try {
                    length = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.out.println("неверные аргументы");
                    return;
                }
                if (!args[0].equals("-n")) {
                    System.out.println("неверные аргументы");
                    return;
                }
            }
        }


            try {
                RandomAccessFile file = new RandomAccessFile(args[args.length - 1], "r");
                int line = 1;

                long pos = file.length() - 1;
                if (pos < 0)
                    return;

                do {
                    file.seek(pos);
                    char c = (char) file.readByte();
                    if (c == '\n' && pos != file.length() - 1)
                        line++;

                    if (line > length)
                        break;

                    if (pos != 0)
                        pos--;
                }
                while (pos != 0);

                file.seek(pos);

                while (true) {
                    try {
                        String str = new String(file.readLine().getBytes("ISO-8859-1"), "utf-8");
                        System.out.println(str);
                    } catch (NullPointerException e) {
                        break;
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("файл не найден");
            } catch (IOException e) {
                System.out.println("ошибка файла");
                e.printStackTrace();
            }

    }
}
