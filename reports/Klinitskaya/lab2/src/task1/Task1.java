import java.io.*;
import java.util.*;
public class Task1 {
    public static void main(String[] args) {

        //пытаемся считать файл, имя которого введено с вызовом программы
        try(FileReader file = new FileReader(args[0])) {

            //если удалось найти файл, то определяем объект класса reader для чтения из файла
            BufferedReader reader = new BufferedReader(file);
            //считывать из файла будем посимвольно
            char probel = ' ';
            int ch, length = 0;
            int count_of_words[] = new int[255];
            //пока не добрались до конца файла считываем по символу
            while((ch=reader.read())!=-1){
                System.out.print((char)ch);
                length++;
                //словили новое слово
                if((char)ch == probel){
                    length--;
                    count_of_words[length]++;
                    length = 0;
               }
            }
            System.out.println("");
            for(int i = 0; i < count_of_words.length; i++){
                if(count_of_words[i] != 0){
                    System.out.println("Count words witch have " + i + "letters = " + count_of_words[i]);
                }
            }
        }

        //если считать файл не удалось выводим сообщение ошибки
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}