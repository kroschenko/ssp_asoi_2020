package com.company;

public class Order {

    private int id;
    private int idBook;

    //0: абонемент
    //1: читальный зал
    private int statusGivedBook;

    public Order(int id, int idBook, int statusGivedBook) {
        this.id = id;
        this.idBook = idBook;
        this.statusGivedBook = statusGivedBook;
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

    public int getStatusGivedBook() {
        return statusGivedBook;
    }

    public void setStatusGivedBook(int statusGivedBook) {
        this.statusGivedBook = statusGivedBook;
    }

}
