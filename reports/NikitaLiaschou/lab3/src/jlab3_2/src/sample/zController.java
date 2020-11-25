package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

import static sample.Main.loadBooks2;

public class zController {

    private ObservableList<Book> books = FXCollections.observableArrayList();

    @FXML
    private TableView<Book> tableUsers;

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

    // инициализируем форму данными
    @FXML
    private void initialize() throws IOException, ParseException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        udkCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("udkCode"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        countCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("countBooks"));
        tomsCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("countToms"));
        dateProduceCol.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        pagesCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("pages"));

        // заполняем таблицу данными
        tableUsers.setItems(books);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() throws IOException, ParseException {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList = loadBooks2();
        for(Book tst : bookList) {
            books.add(tst);
        }
    }

}