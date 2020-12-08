package com.company;

import java.util.ArrayList;
import java.util.Scanner;

    class Product{
        private int id;
        private String name;
        private String ups;
        private String manufacturer;
        private int price;
        private int shelfLife;
        private int number;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUps() {
            return ups;
        }

        public void setUps(String ups) {
            this.ups = ups;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getShelfLife() {
            return shelfLife;
        }

        public void setShelfLife(int shelfLife) {
            this.shelfLife = shelfLife;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }


    }


    public class Main {

        public static void main(String[] args) {
            //список названий

            ArrayList<String> name = new ArrayList<>();
            name.add("Redmi 7");
            name.add("P 40 Pro");
            name.add("C9");
            name.add("Iphone 8");
            name.add("One");
            name.add("Galaxy A31");

            ArrayList<String> ups = new ArrayList<>();
            ups.add("23084571");
            ups.add("24574835");
            ups.add("01344543");
            ups.add("93497821");
            ups.add("34854922");
            ups.add("09489684");

            ArrayList<String> manufacturers = new ArrayList<>();
            manufacturers.add("Xiaomi");
            manufacturers.add("Huawey");
            manufacturers.add("Meizu");
            manufacturers.add("Apple");
            manufacturers.add("Motorolla");
            manufacturers.add("Samsung");

            ArrayList<Integer> prices = new ArrayList<>();
            prices.add(300);
            prices.add(450);
            prices.add(279);
            prices.add(720);
            prices.add(540);
            prices.add(700);

            ArrayList<Integer> shelfLifes = new ArrayList<>();
            shelfLifes.add(30);
            shelfLifes.add(30);
            shelfLifes.add(30);
            shelfLifes.add(30);
            shelfLifes.add(30);
            shelfLifes.add(30);

            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(30);
            numbers.add(15);
            numbers.add(8);
            numbers.add(45);
            numbers.add(2);
            numbers.add(32);

            // write your code here
            Product product1 = new Product();
            Product product2 = new Product();
            Product product3 = new Product();
            Product product4 = new Product();
            Product product5 = new Product();
            Product product6 = new Product();

            product1.setId(1);
            product1.setName(name.get(0));
            product1.setUps(ups.get(0));
            product1.setManufacturer(manufacturers.get(0));
            product1.setPrice(prices.get(0));
            product1.setShelfLife(shelfLifes.get(0));
            product1.setNumber(numbers.get(0));

            product2.setId(2);
            product2.setName(name.get(1));
            product2.setUps(ups.get(1));
            product2.setManufacturer(manufacturers.get(1));
            product2.setPrice(prices.get(1));
            product2.setShelfLife(shelfLifes.get(1));
            product2.setNumber(numbers.get(1));

            product3.setId(3);
            product3.setName(name.get(2));
            product3.setUps(ups.get(2));
            product3.setManufacturer(manufacturers.get(2));
            product3.setPrice(prices.get(2));
            product3.setShelfLife(shelfLifes.get(2));
            product3.setNumber(numbers.get(2));

            product4.setId(4);
            product4.setName(name.get(3));
            product4.setUps(ups.get(3));
            product4.setManufacturer(manufacturers.get(3));
            product4.setPrice(prices.get(3));
            product4.setShelfLife(shelfLifes.get(3));
            product4.setNumber(numbers.get(3));

            product5.setId(5);
            product5.setName(name.get(4));
            product5.setUps(ups.get(4));
            product5.setManufacturer(manufacturers.get(4));
            product5.setPrice(prices.get(4));
            product5.setShelfLife(shelfLifes.get(4));
            product5.setNumber(numbers.get(4));

            product6.setId(6);
            product6.setName(name.get(5));
            product6.setUps(ups.get(5));
            product6.setManufacturer(manufacturers.get(5));
            product6.setPrice(prices.get(5));
            product6.setShelfLife(shelfLifes.get(5));
            product6.setNumber(numbers.get(5));


            System.out.println("Добро пожаловать");
            System.out.println("Введите 1 - чтобы просмотреть всю продукцию на складе");
            System.out.println("Введите 2 - чтобы задать наименование и вывести соответствующий список товаров");
            System.out.println("Введите 3 - чтобы задать наименование и максимальную цену, и вывести список подходящих товаров");
            System.out.println("Введите 4 - чтобы вывести список товаров, которые залежались на складе");
            System.out.println("Введите 5 - чтобы завершить работу");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                {
                        System.out.println("Id: "+product1.getId()+", name: "+product1.getName()+", ups: "+product1.getUps()+", manufacturer: "+ product1.getManufacturer()+", price: "+product1.getPrice()+", shelf life: "+product1.getShelfLife()+", number: "+product1.getNumber());
                        System.out.println("Id: "+product2.getId()+", name: "+product2.getName()+", ups: "+product2.getUps()+", manufacturer: "+ product2.getManufacturer()+", price: "+product2.getPrice()+", shelf life: "+product2.getShelfLife()+", number: "+product2.getNumber());
                        System.out.println("Id: "+product3.getId()+", name: "+product3.getName()+", ups: "+product3.getUps()+", manufacturer: "+ product3.getManufacturer()+", price: "+product3.getPrice()+", shelf life: "+product3.getShelfLife()+", number: "+product3.getNumber());
                        System.out.println("Id: "+product4.getId()+", name: "+product4.getName()+", ups: "+product4.getUps()+", manufacturer: "+ product4.getManufacturer()+", price: "+product4.getPrice()+", shelf life: "+product4.getShelfLife()+", number: "+product4.getNumber());
                        System.out.println("Id: "+product5.getId()+", name: "+product5.getName()+", ups: "+product5.getUps()+", manufacturer: "+ product5.getManufacturer()+", price: "+product5.getPrice()+", shelf life: "+product5.getShelfLife()+", number: "+product5.getNumber());
                        System.out.println("Id: "+product6.getId()+", name: "+product6.getName()+", ups: "+product6.getUps()+", manufacturer: "+ product6.getManufacturer()+", price: "+product6.getPrice()+", shelf life: "+product6.getShelfLife()+", number: "+product6.getNumber());

                    break;
                }
                case 2:{
                    Scanner scanner2 = new Scanner(System.in);
                    String specName = scanner2.nextLine();
                    if(product1.getName().equals(specName))
                        System.out.println("Id: "+product1.getId()+", name: "+product1.getName()+", ups: "+product1.getUps()+", manufacturer: "+ product1.getManufacturer()+", price: "+product1.getPrice()+", shelf life: "+product1.getShelfLife()+", number: "+product1.getNumber());
                    if(product2.getName().equals(specName))
                        System.out.println("Id: "+product2.getId()+", name: "+product2.getName()+", ups: "+product2.getUps()+", manufacturer: "+ product2.getManufacturer()+", price: "+product2.getPrice()+", shelf life: "+product2.getShelfLife()+", number: "+product2.getNumber());
                    if(product3.getName().equals(specName))
                        System.out.println("Id: "+product3.getId()+", name: "+product3.getName()+", ups: "+product3.getUps()+", manufacturer: "+ product3.getManufacturer()+", price: "+product3.getPrice()+", shelf life: "+product3.getShelfLife()+", number: "+product3.getNumber());
                    if(product4.getName().equals(specName))
                        System.out.println("Id: "+product4.getId()+", name: "+product4.getName()+", ups: "+product4.getUps()+", manufacturer: "+ product4.getManufacturer()+", price: "+product4.getPrice()+", shelf life: "+product4.getShelfLife()+", number: "+product4.getNumber());
                    if(product5.getName().equals(specName))
                        System.out.println("Id: "+product5.getId()+", name: "+product5.getName()+", ups: "+product5.getUps()+", manufacturer: "+ product5.getManufacturer()+", price: "+product5.getPrice()+", shelf life: "+product5.getShelfLife()+", number: "+product5.getNumber());
                    if(product6.getName().equals(specName))
                        System.out.println("Id: "+product6.getId()+", name: "+product6.getName()+", ups: "+product6.getUps()+", manufacturer: "+ product6.getManufacturer()+", price: "+product6.getPrice()+", shelf life: "+product6.getShelfLife()+", number: "+product6.getNumber());
                    break;
                }
                case 3:{
                    Scanner scanner2 = new Scanner(System.in);
                    String specName = scanner2.nextLine();
                    Scanner scanner3 = new Scanner(System.in);
                    int specPrice = scanner3.nextInt();
                    if(product1.getName().equals(specName)&&product1.getPrice()<=specPrice)
                        System.out.println("Id: "+product1.getId()+", name: "+product1.getName()+", ups: "+product1.getUps()+", manufacturer: "+ product1.getManufacturer()+", price: "+product1.getPrice()+", shelf life: "+product1.getShelfLife()+", number: "+product1.getNumber());
                    if(product2.getName().equals(specName)&&product2.getPrice()<=specPrice)
                        System.out.println("Id: "+product2.getId()+", name: "+product2.getName()+", ups: "+product2.getUps()+", manufacturer: "+ product2.getManufacturer()+", price: "+product2.getPrice()+", shelf life: "+product2.getShelfLife()+", number: "+product2.getNumber());
                    if(product3.getName().equals(specName)&&product3.getPrice()<=specPrice)
                        System.out.println("Id: "+product3.getId()+", name: "+product3.getName()+", ups: "+product3.getUps()+", manufacturer: "+ product3.getManufacturer()+", price: "+product3.getPrice()+", shelf life: "+product3.getShelfLife()+", number: "+product3.getNumber());
                    if(product4.getName().equals(specName)&&product4.getPrice()<=specPrice)
                        System.out.println("Id: "+product4.getId()+", name: "+product4.getName()+", ups: "+product4.getUps()+", manufacturer: "+ product4.getManufacturer()+", price: "+product4.getPrice()+", shelf life: "+product4.getShelfLife()+", number: "+product4.getNumber());
                    if(product5.getName().equals(specName)&&product5.getPrice()<=specPrice)
                        System.out.println("Id: "+product5.getId()+", name: "+product5.getName()+", ups: "+product5.getUps()+", manufacturer: "+ product5.getManufacturer()+", price: "+product5.getPrice()+", shelf life: "+product5.getShelfLife()+", number: "+product5.getNumber());
                    if(product6.getName().equals(specName)&&product6.getPrice()<=specPrice)
                        System.out.println("Id: "+product6.getId()+", name: "+product6.getName()+", ups: "+product6.getUps()+", manufacturer: "+ product6.getManufacturer()+", price: "+product6.getPrice()+", shelf life: "+product6.getShelfLife()+", number: "+product6.getNumber());
                    break;
                }
                case 4:{
                    if(product1.getShelfLife()>45)
                        System.out.println("Id: "+product1.getId()+", name: "+product1.getName()+", ups: "+product1.getUps()+", manufacturer: "+ product1.getManufacturer()+", price: "+product1.getPrice()+", shelf life: "+product1.getShelfLife()+", number: "+product1.getNumber());
                    if(product2.getShelfLife()>45)
                        System.out.println("Id: "+product2.getId()+", name: "+product2.getName()+", ups: "+product2.getUps()+", manufacturer: "+ product2.getManufacturer()+", price: "+product2.getPrice()+", shelf life: "+product2.getShelfLife()+", number: "+product2.getNumber());
                    if(product3.getShelfLife()>45)
                        System.out.println("Id: "+product3.getId()+", name: "+product3.getName()+", ups: "+product3.getUps()+", manufacturer: "+ product3.getManufacturer()+", price: "+product3.getPrice()+", shelf life: "+product3.getShelfLife()+", number: "+product3.getNumber());
                    if(product4.getShelfLife()>45)
                        System.out.println("Id: "+product4.getId()+", name: "+product4.getName()+", ups: "+product4.getUps()+", manufacturer: "+ product4.getManufacturer()+", price: "+product4.getPrice()+", shelf life: "+product4.getShelfLife()+", number: "+product4.getNumber());
                    if(product5.getShelfLife()>45)
                        System.out.println("Id: "+product5.getId()+", name: "+product5.getName()+", ups: "+product5.getUps()+", manufacturer: "+ product5.getManufacturer()+", price: "+product5.getPrice()+", shelf life: "+product5.getShelfLife()+", number: "+product5.getNumber());
                    if(product6.getShelfLife()>45)
                        System.out.println("Id: "+product6.getId()+", name: "+product6.getName()+", ups: "+product6.getUps()+", manufacturer: "+ product6.getManufacturer()+", price: "+product6.getPrice()+", shelf life: "+product6.getShelfLife()+", number: "+product6.getNumber());
                    break;
                }
                case 5:{
                    break;
                }
            }
        }
    }
