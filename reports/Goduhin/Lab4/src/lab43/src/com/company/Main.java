package com.company;

public class Main {

    public static void main(String[] args) {
        Account account1 = new Account(0);
        Account account2 = new Account(1);

        account1.setMoneyCount(30);
        account2.setMoneyCount(20.57);

        Chip chip = new Chip(0, "Semicond Inc");

        Card card1 = new Card(0, 200, chip);
        Card card2 = new Card(1, 30, chip);

        Client client1 = new Client(0, "Алексеев А.П", account1, card1);
        Client client2 = new Client(1, "Александров М.П.", account2, card2);

        String[] receivers = {"Столовая №2", "Интернет-магазин blizko", "Кафе \"У дома\""};

        Order order1 = new Order(0, receivers[0], 12.5, false);
        Order order2 = new Order(1, receivers[2], 32, false);

        client1.setOrder(order1);
        client2.setOrder(order2);

        Admin admin = new Admin(0, "Главнов Г.Ю.");

        client1.show();
        System.out.println();
        client2.show();


        client2.payOrder(true);
        client1.paymentToOtherAccount(account2, 5, false);
        client1.blockCard();
        client1.cancelAccount();

        admin.blockCard(card2);

        System.out.println();
        System.out.println();
        System.out.println("После действий:");
        client1.show();
        System.out.println();
        client2.show();
    }
}
