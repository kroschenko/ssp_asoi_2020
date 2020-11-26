package com.company;

import com.company.exceptions.FileEmptyException;
import com.company.exceptions.FileExistsException;
import com.company.exceptions.NoDirectoryException;
import com.company.exceptions.NoPlaceException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();

        boolean key = true;
        byte code;
        Scanner scanner = new Scanner(System.in);

        while(key)
        {
            for(int i=0; i<15; i++)
                System.out.println();

            System.out.println("1: вывести список файлов и директорий");
            System.out.println("2: вывести список свободных сегментов");
            System.out.println("3: вывести список занятых сегментов");
            System.out.println("4: добавить файл");
            System.out.println("5: добавить папку");
            System.out.println("6: удалить файл");
            System.out.println("7: удалить папку");
            System.out.println("8: выйти");

            code = Byte.parseByte(scanner.nextLine());

            if(code==1)
                storage.printFiles();
            else if(code==2)
                storage.printFreeSegments();
            else if(code==3)
                storage.printOccupiedSegments();
            else if(code==4)
            {
                String path, directory;
                System.out.println("Введите путь к файлу:");
                path = scanner.nextLine();
                System.out.println("Введите путь к файлу на гибком диске:");
                directory = scanner.nextLine();

                try
                {
                    storage.writeFile(path, directory);
                }
                catch(FileEmptyException e)
                {
                    System.out.println("Ошибка: файл пуст");
                }
                catch(FileExistsException e)
                {
                    System.out.println("Ошибка: файл существует на гибком диске");
                }
                catch(NoDirectoryException e)
                {
                    System.out.println("Ошибка: указанной директории не существует на гибком диске");
                }
                catch(NoPlaceException e)
                {
                    System.out.println("Ошибка: на гибком диске нет места");
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("Ошибка: файл не найден");
                }
                catch(Exception e)
                {
                    System.out.println("Ошибка");
                    e.printStackTrace();
                }

            }
            else if(code==5)
            {
                String path, name;
                System.out.println("Введите путь к директории на гибком диске:");
                path = scanner.nextLine();
                System.out.println("Введите имя папки:");
                name = scanner.nextLine();

                try
                {
                    storage.createDirectory(path, name);
                }
                catch(FileExistsException e)
                {
                    System.out.println("Ошибка: папка уже существует на гибком диске");
                }
                catch(Exception e)
                {
                    System.out.println("Ошибка");
                    e.printStackTrace();
                }
            }
            else if(code==6)
            {
                System.out.println("Введите путь к файлу на гибком диске:");
                String path = scanner.nextLine();

                try
                {
                    storage.removeFile(path);
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("Ошибка: файл не существует на гибком диске");
                }
                catch(Exception e)
                {
                    System.out.println("Ошибка");
                    e.printStackTrace();
                }
            }
            else if(code==7)
            {
                System.out.println("Введите путь к папке на гибком диске:");
                String path = scanner.nextLine();

                try
                {
                    storage.removeDirectory(path);
                }
                catch(Exception e)
                {
                    System.out.println("Ошибка");
                    e.printStackTrace();
                }
            }
            else if(code==8)
                key=false;

            System.out.println("Нажмите Enter:");
            scanner.nextLine();
        }
    }
}
