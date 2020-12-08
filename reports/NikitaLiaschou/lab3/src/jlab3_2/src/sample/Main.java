package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Библиотека");
        primaryStage.setScene(new Scene(root, 320, 405));
        primaryStage.show();
    }

    public static ArrayList<String> fileToList() {
        ArrayList<String> text = new ArrayList<String>();
        try {
            File file = new File("st.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            text.add(line);
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                text.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text.remove(text.size()-1);
        return text;
    }
    public static String[] lineToVar(String inline) {
        String components[] = inline.split("\\s+");
        return components;
    }
    public static ArrayList<Book> loadBooks() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        ArrayList<String> text = new ArrayList<String>();
        text = fileToList();
        String components[];
        for(String item : text) {
            components = lineToVar(item);
            bookList.add(new Book(Integer.parseInt(components[0]),
                    components[1]+" "+components[2], components[3],Integer.parseInt(components[4]),
                    Integer.parseInt(components[5]), components[6], Integer.parseInt(components[7]),
                    components[8]+" "+components[9], components[10]));
        }
        return bookList;
    }
    public static ArrayList<Book> loadBooks2() throws IOException, ParseException {
        ArrayList<Book> bookList = new ArrayList<Book>();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("test.json"));
        // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
        JSONObject jsonObject = (JSONObject) obj;

        // A JSON array. JSONObject supports java.util.List interface.
        JSONArray bookslist = (JSONArray) jsonObject.get("books");

        Iterator<JSONObject> iterator = bookslist.iterator();
        JSONObject book;
        while (iterator.hasNext()) {
            book = iterator.next();
            Book kniga = new Book(
                    Integer.parseInt((String)book.get("udkCode")),
                    (String)book.get("author"),
                    (String)book.get("title"),
                    Integer.parseInt((String) book.get("count")),
                    Integer.parseInt((String)book.get("toms")),
                    (String)book.get("dateProduce"),
                    Integer.parseInt((String)book.get("pages")),
                    (String)book.get("user"),
                    (String)book.get("dateTake")
                    );
            bookList.add(kniga);
        }
        return bookList;
    }

    public static void printAllList(ArrayList<Book> booklist) {
        for(Book item : booklist) {
            System.out.print(item.udkCode+"\t");
            System.out.print(item.author+"\t");
            System.out.print(item.bookName+"\t");
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        launch(args);
//        ArrayList<Book> bookListz = new ArrayList<Book>();
//        loadBooks2();


    }
}
