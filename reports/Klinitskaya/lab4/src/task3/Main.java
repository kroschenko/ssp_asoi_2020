package com.company;
import java.util.HashMap;
import java.util.ArrayList;

//книга
class Book {

    //id книги, название и автор. их инициализация и получение:
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //метод проверяющий книгу на совпадение (по идентификатору)
    @Override
    public boolean equals(Object obj) {
        return ((Book)obj).id == id;
    }

    public void print(){
        System.out.print("id: "+id+"; title: "+ title +"; author: "+author);
    }

}
//каталог книг
class Catalog {
    //создаем список из книг, методы на добавление, удаление книг из списка
    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book){
        books.add(book);
    }
    //Удаление и поиск книги происходят по идентификатору
    public void deleteBookById(int bookId){
        for(int i=0; i<books.size(); i++)
            if(books.get(i).getId() == bookId) {
                books.remove(i);
                return;
            }
    }

    public Book getBookById(int bookId){
        for(int i=0; i<books.size(); i++)
            if(books.get(i).getId() == bookId)
                return books.get(i);

        return null;
    }

    public void show(){
        System.out.println("Каталог:");
        for(int i=0; i<books.size(); i++) {
            books.get(i).print();
            System.out.println();
        }
    }
}

//человек. может как быть читателем, так и находиться в черной книге, быть администратором и т.д.
//класс содержит идентификатор и ФИО человека
abstract class Person {

    protected int id;
    protected String fio;

    public Person(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


}

//читатель
class Reader extends Person {
    //может взять на чтение несколько книг, в зависимости от заказа.
    //изначально НЕ находится в "черном" списке
    private HashMap<Book, Integer> books = new HashMap<Book, Integer>();
    private boolean blacklist = false;

    public Reader(int id, String fio) {
        super(id, fio);
    }

    //методы на взятие или возврат книги, добавление и проверку "черного" списка
    public void takeBook(Book book, int status){
        books.put(book, status);
    }

    public void returnBook(Book book){
        books.remove(book);
    }

    public boolean isBlacklist() {
        return blacklist;
    }

    public void setBlacklist(boolean blacklist) {
        this.blacklist = blacklist;
    }
    //читатель делает заказ на взятие новой кники
    public Order makeOrder(int id, int idBook, int isHaveBook){
        return new Order(id, idBook, isHaveBook);
    }

    public void show(){
        System.out.println("id: "+id+"; fio: "+fio+"; in blacklist: "+blacklist);
        System.out.println("Взятые книги:");
        for (HashMap.Entry<Book, Integer> whereIs : books.entrySet()) {
            whereIs.getKey().print();
            System.out.print("; тип выдачи: ");
            if(whereIs.getValue()==0)
                System.out.println("абонемент");
            else if(whereIs.getValue()==1)
                System.out.println("читальный зал");
        }
    }
}

//заказ на получение книги
class Order {
    //номер заказа, книги, информация по количеству книг
    private int id;
    private int idBook;
    private int isHaveBook;

    //инициализация и получение информации
    public Order(int id, int idBook, int isHaveBook) {
        this.id = id;
        this.idBook = idBook;
        this.isHaveBook = isHaveBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIsHaveBook() {
        return isHaveBook;
    }

    public void setIsHaveBook(int isHaveBook) {
        this.isHaveBook = isHaveBook;
    }

}
//интерфейс! библиотекаря
interface LibrarianInterface {
    boolean giveBookToReader(Reader reader, Order order);
}
//сам класс библиотекаря
class Librarian extends Person implements LibrarianInterface {

    //инициализация и получение
    private Catalog catalog;

    public Librarian(int id, String fio, Catalog catalog) {
        super(id, fio);
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    //проверяем, не находится ли читатель в черном списке и выдаем ему книгу
    public boolean giveBookToReader(Reader reader, Order order){
        if(reader.isBlacklist())
            return false;

        Book book = catalog.getBookById(order.getIdBook());

        if(book==null)
            return false;

        reader.takeBook(book, order.getIsHaveBook());
        catalog.deleteBookById(book.getId());
        return true;
    }

    public void takeBookFromReader(Reader reader, Book book){
        reader.returnBook(book);
        catalog.addBook(book);
    }
}
//администратор заносящий в "черный" список
class Admin extends Person {

    public Admin(int id, String fio) {
        super(id, fio);
    }
    //смысл жизни - добавлять в черный список.
    public void addToBlacklist(Reader reader){
        reader.setBlacklist(true);
    }
}
//демонстрация работы программы
public class Main {

    public static void main(String[] args) {
        //устанавливаем администратор, создаем каталог и добавляем в него несколько книг
        Admin administrator = new Admin(0, "Барболин М.О.");

        Catalog catalog = new Catalog();

        Book book1 = new Book(5, "Сказка о веселых котятах", "Достоевский");
        Book book2 = new Book(10, "Невская ночь", "Грибоедов");
        Book book3 = new Book(12, "Чистый код", "Молодец");
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        //после заполнения каталога книгами создаем объект библиотекаря и сообщаем ему каталог
        Librarian librarian = new Librarian(1, "Любимин Л.П.", catalog);
        catalog.show();

        //создаем читателя и генерируем подачу запросов
        Reader reader1 = new Reader(987, "Вереметьев И.И");
        Reader reader2 = new Reader(584, "Горшков А.М.");

        Order order1 = reader1.makeOrder(34, 10, 0);
        Order order2 = reader1.makeOrder(11, 12, 1);
        Order order3 = reader2.makeOrder(15, 5, 0);

        System.out.println("\n\n\n");
        //проверяем запрошенные книги и выдаем по запросу, если совпали
        if(!librarian.giveBookToReader(reader1, order1))
            System.out.println("order1 не удалось выдать reader1");

        if(!librarian.giveBookToReader(reader1, order2))
            System.out.println("order2 не удалось выдать reader1");

        if(!librarian.giveBookToReader(reader2, order3))
            System.out.println("order3 не удалось выдать reader2");
        //приемка книг (возврат)
        librarian.takeBookFromReader(reader1, book2);
        //обавление читателя в черный список
        administrator.addToBlacklist(reader2);

        Order order4 = reader2.makeOrder(357, 10, 1);

        if(!librarian.giveBookToReader(reader2, order4))
            System.out.println("order4 не удалось выдать reader2");

        System.out.println("\n\n\n");

        catalog.show();

        System.out.println("\n\n\nReader1:");

        reader1.show();

        System.out.println("\n\n\nReader2:");

        reader2.show();
    }
}
