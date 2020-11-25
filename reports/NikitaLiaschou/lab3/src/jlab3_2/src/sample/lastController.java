package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static sample.Main.loadBooks2;

public class lastController {

    private ObservableList<Book> books = FXCollections.observableArrayList();
    @FXML
    private Label labele;

    private String testik;

    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private TableColumn<Book, Integer> udkCol;
    @FXML
    private TableColumn<Book, String> authorCol;
    @FXML
    private TableColumn<Book, String> titleCol;
    @FXML
    private TableColumn<Book, Integer> countCol;
    @FXML
    private TableColumn<Book, Integer> tomsCol;
    @FXML
    private TableColumn<Book, String> dateProduceCol;
    @FXML
    private TableColumn<Book, Integer> pagesCol;



    public lastController(String testik) {
        this.testik = testik;
    }


    private void init() throws IOException, ParseException, java.text.ParseException {
        labele.setText("Список книг старше "+testik+" лет");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList = loadBooks2();
        Date nowyear=new Date();
        int year=nowyear.getYear();
        for(Book tst : bookList) {
            Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(tst.year);
            if(year-date1.getYear() > Integer.parseInt(testik)) {
                books.add(tst);
            }
        }
    }


    @FXML
    private void initialize() throws IOException, ParseException, java.text.ParseException {
        init();

        // устанавливаем тип и значение которое должно хранится в колонке
        udkCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("udkCode"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        countCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("countBooks"));
        tomsCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("countToms"));
        dateProduceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        pagesCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("pages"));

        // заполняем таблицу данными
        tableBooks.setItems(books);
    }
}
