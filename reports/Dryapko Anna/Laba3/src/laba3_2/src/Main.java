import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Library>list1, list2,list3, list4, list5;

    public static void main(String[] args){
        File file = new File("boooks.txt");
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        System.out.println("Список книг");
        fillListBook(list1,file);
        outInfoAboutBook(list1);
        System.out.println("Книги старше 10 лет");
        fillListBookOld(list2,file,10);
        outInfoAboutBook(list2);
        System.out.println("Книги, взятые на чтение");
        fillListSomebodyRead(list3, file);
        outInfoAboutBook(list3);
        System.out.println("Книги, взятые на чтение, с выводом личной информации");
        fillListSomebodyReadWithInfo(list4, file);
        outInfoAllInfo(list4);
        System.out.println("Книги, которые задержаны читетелем дольше указанного срока");
        LocalDate dateNow=  LocalDate.parse("2020-05-05");
        fillListOverdue(list5, file, dateNow);
        outInfoAllInfo(list5);
    }




    public static void outInfoAboutBook(ArrayList<Library> list){
        for(Library library:list){
            System.out.println(library.getBook());
        }
    }

    public static void outInfoAllInfo(ArrayList<Library> list){
        for(Library library:list){
            System.out.println(library.getAllInfo());
        }
    }
    public static void fillListBook(ArrayList<Library> list, File file){
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            Library book;
            while(line!=null){
                String[] words = line.split("\t");
                book = new Library(words[0],words[1],words[2],words[3],words[4],
                        words[5],words[6]);
                list.add(book);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fillListBookOld(ArrayList<Library> list, File file, int old){
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            Library book;
            while(line!=null){
                String[] words = line.split("\t");
                int year = 2020 - Integer.parseInt(words[3]);
                if(year>old) {
                    book = new Library(words[0], words[1], words[2], words[3], words[4],
                            words[5], words[6]);
                    list.add(book);
                }
                    line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void fillListSomebodyRead (ArrayList<Library> list, File file){
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            Library book;
            while(line!=null){
                String[] words = line.split("\t");
                if(!words[7].equals("-")) {
                    book = new Library(words[0], words[1], words[2], words[3], words[4],
                            words[5], words[6]);
                    list.add(book);
                }
                line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void fillListSomebodyReadWithInfo(ArrayList<Library> list, File file){
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            Library book;
            while(line!=null){
                String[] words = line.split("\t");
                if(!words[7].equals("-")) {
                    book = new Library(words[0], words[1], words[2], words[3], words[4],
                            words[5], words[6], words[7], words[8]);
                    list.add(book);
                }
                line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fillListOverdue(ArrayList<Library> list, File file, LocalDate dateNow){
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            Library book;
            while(line!=null){
                String[] words = line.split("\t");
                if(!words[7].equals("-")) {
                    LocalDate dateSdachi = LocalDate.parse(words[8]);

                    if ((dateNow.compareTo(dateSdachi))>0) {
                        book = new Library(words[0], words[1], words[2], words[3], words[4],
                                words[5], words[6], words[7], words[8]);
                        list.add(book);
                    }
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
