package com.company;

import java.util.ArrayList;

public class Catalog {

    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(int bookId){
        for(int i=0; i<books.size(); i++)
            if(books.get(i).getId() == bookId) {
                books.remove(i);
                return;
            }
    }

    public Book getBookById(int id){
        for(int i=0; i<books.size(); i++)
            if(books.get(i).getId() == id)
                return books.get(i);

        return null;
    }

    public void show(){
        System.out.println("Каталог:");
        for(int i=0; i<books.size(); i++) {
            books.get(i).show();
            System.out.println();
        }
    }
}
