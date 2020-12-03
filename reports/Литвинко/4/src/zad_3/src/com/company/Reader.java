package com.company;

import java.util.HashMap;

public class Reader extends Person {

    private HashMap<Book, Integer> books = new HashMap<Book, Integer>();
    private boolean blacklist = false;

    public Reader(int id, String fio) {
        super(id, fio);
    }

    //status:
    //0: абонемент
    //1: читальный зал
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

    public Order makeOrder(int id, int idBook, int statusGivedBook){
        return new Order(id, idBook, statusGivedBook);
    }

    public void show(){
        System.out.println("id: "+id+"; fio: "+fio+"; in blacklist: "+blacklist);
        System.out.println("Взятые книги:");
        for (HashMap.Entry<Book, Integer> pair : books.entrySet()) {
            pair.getKey().show();
            System.out.print("; тип выдачи: ");
            if(pair.getValue()==0)
                System.out.println("абонемент");
            else if(pair.getValue()==1)
                System.out.println("читальный зал");
        }
    }
}
