package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Payment{

    class Product{
        private int id;
        private String name;
        private double cost;
        private int count=0;

        public Product(int id, String name, double cost){
            this.id=id;
            this.name=name;
            this.cost=cost;
        }

        public void print(){
            System.out.println("id: "+id+", name: "+name+", cost: "+cost+" р.");
        }

        public void printCount(){
            System.out.println("id: "+id+", name: "+name+", cost: "+cost+" р.  "+", count: "+count);
        }

        public double getSum(){
            return cost*count;
        }

        public Product clone(){
            Product product = new Product(id, name, cost);
            product.count = count;
            return product;
        }
    }

    private ArrayList<Product> products;
    private ArrayList<Product> paymentProducts;

    public Payment(){
        products = new ArrayList<Product>();

        products.add(new Product(0, "Молоко", 2.15));
        products.add(new Product(1, "Хлеб", 1.3));
        products.add(new Product(2, "Вода", 0.94));

        paymentProducts = new ArrayList<Product>();
    }

    public void printProducts(){
        for(int i=0; i<products.size(); i++)
            products.get(i).print();
    }

    public void printPaymentProducts(){
        double sum=0;

        for(int i=0; i<paymentProducts.size(); i++) {
            paymentProducts.get(i).printCount();
            sum+=paymentProducts.get(i).getSum();
        }
        String formatSum = String.format("%.2f", sum);
        System.out.println("Итого: "+formatSum+" р.");
    }

    public boolean addPaymentProduct(int id, int count){
        if(count<1)
            return false;

        for(int i=0; i<paymentProducts.size(); i++)
            if(paymentProducts.get(i).id == id)
            {
                paymentProducts.get(i).count += count;
                return true;
            }

        for(int i=0; i<products.size(); i++)
            if(products.get(i).id == id)
            {
                Product product = products.get(i).clone();
                product.count = count;
                paymentProducts.add(product);
                return true;
            }

        return false;
    }

    public boolean removePaymentProduct(int id){
        for(int i=0; i<paymentProducts.size(); i++)
            if(paymentProducts.get(i).id == id) {
                paymentProducts.remove(i);
                return true;
            }

        return false;
    }




}

public class Main {

    public static void main(String[] args) {
        Payment payment = new Payment();

        Scanner scan = new Scanner(System.in);
        for(boolean key=true; key; ){
            System.out.println("1 - посмотреть список доступных товаров");
            System.out.println("2 - посмотреть список товаров в моей покупке");
            System.out.println("3 - добавить товар в мою покупку");
            System.out.println("4 - удалить товар из моей покупки");
            System.out.println("5 - выйти");

            int menuKey = Integer.parseInt(scan.nextLine());

            switch(menuKey){
                case 1: payment.printProducts();
                System.out.println("Нажмите Enter:");break;
                case 2: payment.printPaymentProducts();
                System.out.println("Нажмите Enter:");break;
                case 3: System.out.println("Введите id товара:");
                        int id = Integer.parseInt(scan.nextLine());
                        System.out.println("Введите количество товара:");
                        int count = Integer.parseInt(scan.nextLine());
                        boolean result = payment.addPaymentProduct(id, count);
                    System.out.println("Нажмите Enter:");
                        if(!result){
                            System.out.println("Произошла ошибка из-за некорректных параметров");
                        }
                    break;
                case 4: System.out.println("Введите id товара:");
                        int id2 = Integer.parseInt(scan.nextLine());
                        boolean result2 = payment.removePaymentProduct(id2);
                        if(!result2){
                            System.out.println("Произошла ошибка из-за некорректных параметров");
                        }
                    System.out.println("Нажмите Enter:");break;
                case 5: key = false;
            }

            scan.nextLine();
            for(int i=0; i<10; i++)
                System.out.println();
        }
    }
}
