package com.company;

import java.util.Scanner;

public class Menu {
    public void start(){
        Payment payment = new Payment();
        payment.fill();

        Scanner scanner = new Scanner(System.in);

        boolean key = true;
        int code;
        int id;

        while(key){
            for(int i=0; i<15; i++)
                System.out.println();

            System.out.println("0: список товаров");
            System.out.println("1: моя покупка");
            System.out.println("2: добавить товар в покупку");
            System.out.println("3: удалить товар из покупки");
            System.out.println("4 - выйти");

            code = Integer.parseInt(scanner.nextLine());

            if(code==0) {
                payment.showTovar(false);
            }
            else if(code==1) {
                payment.showTovar(true);
            }
            else if(code==2) {
                System.out.println("id товара:");
                id = Integer.parseInt(scanner.nextLine());
                System.out.println("Количество товара:");
                int price = Integer.parseInt(scanner.nextLine());
                payment.addTovar(id, price);
            }
            else if(code==3) {
                System.out.println("id товара:");
                id = Integer.parseInt(scanner.nextLine());
                payment.deleteTovar(id);
            }
            else {
                key = false;
            }

            System.out.println("Нажмите Enter");
            scanner.nextLine();
        }
    }
}
