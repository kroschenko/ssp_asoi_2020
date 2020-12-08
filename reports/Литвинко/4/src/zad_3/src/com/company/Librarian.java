package com.company;

public class Librarian extends Person implements LibrarianInterface {

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

    public boolean giveBookToReader(Reader reader, Order order){
        if(reader.isBlacklist())
            return false;

        Book book = catalog.getBookById(order.getIdBook());

        if(book==null)
            return false;

        reader.takeBook(book, order.getStatusGivedBook());
        catalog.removeBook(book.getId());
        return true;
    }

    public void takeReturnedBook(Reader reader, Book book){
        reader.returnBook(book);
        catalog.addBook(book);
    }
}
