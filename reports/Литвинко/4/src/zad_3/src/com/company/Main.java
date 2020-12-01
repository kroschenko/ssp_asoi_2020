package com.company;

public class Main {

    public static void main(String[] args) {
        Admin administrator = new Admin(0, "Иванов И.И.");

        Catalog catalog = new Catalog();

        Book book1 = new Book(5, "Сказка о рыбаке и рыбке", "Пушкин");
        Book book2 = new Book(10, "Война и мир", "Толстой");
        Book book3 = new Book(12, "Горе от ума", "Грибоедов");
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        Librarian librarian = new Librarian(1, "Светлый А.Е.", catalog);

        catalog.show();

        Reader reader1 = new Reader(987, "Вертьянова М.И");

        Order order1 = reader1.makeOrder(34, 10, 0);
        Order order2 = reader1.makeOrder(11, 12, 1);

        Reader reader2 = new Reader(584, "Горшков А.М.");

        Order order3 = reader1.makeOrder(15, 5, 0);

        System.out.println("\n\n\n");

        if(!librarian.giveBookToReader(reader1, order1))
            System.out.println("order1 не удалось выдать reader1");

        if(!librarian.giveBookToReader(reader1, order2))
            System.out.println("order2 не удалось выдать reader1");

        if(!librarian.giveBookToReader(reader2, order3))
            System.out.println("order3 не удалось выдать reader2");

        librarian.takeReturnedBook(reader1, book2);

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
