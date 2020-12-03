package sample;

import java.util.Date;

public class Book {
    int udkCode;
    String author;
    String bookName;
    int countBooks;
    int countToms;
    String year;
    int pages;
    String user;
    String deadline;

    public Book(int udkCode, String author, String bookName, int countBooks, int countToms, String year, int pages, String user, String deadline) {
        this.udkCode = udkCode;
        this.author = author;
        this.bookName = bookName;
        this.countBooks = countBooks;
        this.countToms = countToms;
        this.year = year;
        this.pages = pages;
        this.user = user;
        this.deadline = deadline;
    }
    public Book() {

    }

    public int getUdkCode() {
        return udkCode;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public int getCountBooks() {
        return countBooks;
    }

    public int getCountToms() {
        return countToms;
    }

    public String getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getUser() {
        return user;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setUdkCode(int udkCode) {
        this.udkCode = udkCode;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCountBooks(int countBooks) {
        this.countBooks = countBooks;
    }

    public void setCountToms(int countToms) {
        this.countToms = countToms;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
