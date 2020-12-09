//package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        try(FileReader file = new FileReader(args[2])) {
            BufferedReader reader = new BufferedReader(file);
            //проверяем есть ли вообще аргументы и является ли первый аргумент - cp
            if (args.length == 0 || !args[0].equals("cp")) {
                System.out.println("Incorrect input");
                return;
            }

            //проверим ввел ли пользователь ключи
            char[] flag_check = args[1].toCharArray();
            boolean f_f = false, f_i = false, f_n = false;
            if (flag_check[0] == '-') {
                //если ввел, то узнаем какие именно
                for (int i = 1; i < flag_check.length; i++) {
                    //при нахождении соответсвующего ключа его значение устанавливается как истина
                    switch (flag_check[i]) {
                        case 'f': {
                            f_f = true;
                            break;
                        }
                        case 'i': {
                            f_i = true;
                            break;
                        }
                        case 'n': {
                            f_n = true;
                            break;
                        }
                    }
                }
            }
            //теперь у нас есть булевы знчения на каждый ключ и мы можем начать работу с файлами
            File fileout = new File(args[3]);
            //если файла не было, то создаем
            if(!fileout.exists()){
                fileout.createNewFile();
            }
            //если нельзя записать и удаление разрешено, то удаляем файл
            if(f_f && !fileout.canWrite()){
                fileout.delete();
            }
            //если пользователь готов перезаписать файл и поставил ключ n, то запрашиваем разрешение
            if(f_i != false && f_n != true){
                System.out.println("If you want to rewrite the file enter 1");
                int user_answer = System.in.read();
                //если он согласен, то ставить флаг append значение false
                if(user_answer == 1){
                    try(FileWriter writeInFile = new FileWriter(fileout, false)){
                        //теперь можно начать запись в файл из исходного файла
                        int ch;
                        while((ch = reader.read()) != -1){
                            System.out.print((char)ch);
                            writeInFile.append((char)ch);
                        }
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
            //иначе ставим флаг true и просто дописываем текс в конец исходного файла
            else
                try(FileWriter writeInFile = new FileWriter(fileout, true)) {
                    //теперь можно начать запись в файл из исходного файла
                    int ch;
                    while ((ch = reader.read()) != -1) {
                        System.out.print((char) ch);
                        writeInFile.append((char) ch);
                    }
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}