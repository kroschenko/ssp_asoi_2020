import java.util.ArrayList;
import java.util.Scanner;

class Product {

    private String name, ups, manufacturer;
    private int id, price, shelfLife, amount;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUps() { return ups; }

    public void setUps(String ups) { this.ups = ups; }

    public String getManufacturer() { return manufacturer; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getShelfLife() { return shelfLife; }

    public void setShelfLife(int shelfLife) { this.shelfLife = shelfLife; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }
}

public class task2 {

    public static void main(String[] args) {

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Note 9 Pro");
        nameList.add("V20 SE");
        nameList.add("Galaxy S10");
        nameList.add("30 Premium");
        nameList.add("iPhone 12 Pro Max");

        ArrayList<String> upsList = new ArrayList<>();
        upsList.add("1245443220981");
        upsList.add("1748642140582");
        upsList.add("1954551458684");
        upsList.add("1116863922921");
        upsList.add("1666148228101");

        ArrayList<String> manufacturerList = new ArrayList<>();
        manufacturerList.add("Redmi");
        manufacturerList.add("VIVO");
        manufacturerList.add("Samsung");
        manufacturerList.add("HONOR");
        manufacturerList.add("Apple");

        ArrayList<Integer> priceList = new ArrayList<>();
        priceList.add(749);
        priceList.add(729);
        priceList.add(2449);
        priceList.add(1499);
        priceList.add(5399);

        ArrayList<Integer> shellLifeList = new ArrayList<>();
        shellLifeList.add(6);
        shellLifeList.add(26);
        shellLifeList.add(10);
        shellLifeList.add(15);
        shellLifeList.add(3);

        ArrayList<Integer> amountList = new ArrayList<>();
        amountList.add(250);
        amountList.add(189);
        amountList.add(121);
        amountList.add(154);
        amountList.add(24);

        Product product1 = new Product(),
                product2 = new Product(),
                product3 = new Product(),
                product4 = new Product(),
                product5 = new Product();

        product1.setId(1);
        product1.setName(nameList.get(0));
        product1.setUps(upsList.get(0));
        product1.setManufacturer(manufacturerList.get(0));
        product1.setPrice(priceList.get(0));
        product1.setShelfLife(shellLifeList.get(0));
        product1.setAmount(amountList.get(0));

        product2.setId(2);
        product2.setName(nameList.get(1));
        product2.setUps(upsList.get(1));
        product2.setManufacturer(manufacturerList.get(1));
        product2.setPrice(priceList.get(1));
        product2.setShelfLife(shellLifeList.get(1));
        product2.setAmount(amountList.get(1));

        product3.setId(3);
        product3.setName(nameList.get(2));
        product3.setUps(upsList.get(2));
        product3.setManufacturer(manufacturerList.get(2));
        product3.setPrice(priceList.get(2));
        product3.setShelfLife(shellLifeList.get(2));
        product3.setAmount(amountList.get(2));

        product4.setId(4);
        product4.setName(nameList.get(3));
        product4.setUps(upsList.get(3));
        product4.setManufacturer(manufacturerList.get(3));
        product4.setPrice(priceList.get(3));
        product4.setShelfLife(shellLifeList.get(3));
        product4.setAmount(amountList.get(3));

        product5.setId(5);
        product5.setName(nameList.get(4));
        product5.setUps(upsList.get(4));
        product5.setManufacturer(manufacturerList.get(4));
        product5.setPrice(priceList.get(4));
        product5.setShelfLife(shellLifeList.get(4));
        product5.setAmount(amountList.get(4));

        System.out.println("\nСмартСклад v0.1");
        System.out.println("1 - список товаров");
        System.out.println("2 - список товаров для заданного наименования");
        System.out.println("3 - список товаров для заданного наименования с фильтром цены");
        System.out.println("4 - список товаров с истекшим сроком хранения");
        System.out.println("0 - выход из программы");

        Scanner numScanner = new Scanner(System.in);
        System.out.print("\nВведите, чтобы продолжить: ");
        int num = numScanner.nextInt();

        switch (num) {
            case 1: {
                System.out.println("\nID: " + product1.getId() + "\nНазвание: " + product1.getName() + "\nUPS: "
                        + product1.getUps() + "\nПроизводитель: " + product1.getManufacturer() + "\nЦена: "
                        + product1.getPrice() + " руб\nСрок хранения: " + product1.getShelfLife() + " месяцев(-а)\nКоличество: "
                        + product1.getAmount() + " шт");
                System.out.println("\nID: " + product2.getId() + "\nНазвание: " + product2.getName() + "\nUPS: "
                        + product2.getUps() + "\nПроизводитель: " + product2.getManufacturer() + "\nЦена: "
                        + product2.getPrice() + " руб\nСрок хранения: " + product2.getShelfLife() + " месяцев(-а)\nКоличество: "
                        + product2.getAmount() + " шт");
                System.out.println("\nID: " + product3.getId() + "\nНазвание: " + product3.getName() + "\nUPS: "
                        + product3.getUps() + "\nПроизводитель: " + product3.getManufacturer() + "\nЦена: "
                        + product3.getPrice() + " руб\nСрок хранения: " + product3.getShelfLife() + " месяцев(-а) \nКоличество: "
                        + product3.getAmount() + " шт");
                System.out.println("\nID: " + product4.getId() + "\nНазвание: " + product4.getName() + "\nUPS: "
                        + product4.getUps() + "\nПроизводитель: " + product4.getManufacturer() + "\nЦена: "
                        + product4.getPrice() + " руб\nСрок хранения: " + product4.getShelfLife() + " месяцев(-а) \nКоличество: "
                        + product4.getAmount() + " шт");
                System.out.println("\nID: " + product5.getId() + "\nНазвание: " + product5.getName() + "\nUPS: "
                        + product5.getUps() + "\nПроизводитель: " + product5.getManufacturer() + "\nЦена: "
                        + product5.getPrice() + " руб\nСрок хранения: " + product5.getShelfLife() + " месяцев(-а) \nКоличество: "
                        + product5.getAmount()+ " шт");
                break;
            }
            case 2: {
                Scanner nameScanner = new Scanner(System.in);
                System.out.print("Введите название модели: ");
                String nameSearch = nameScanner.nextLine();

                if (product1.getName().equals(nameSearch))
                    System.out.println("\nID: " + product1.getId() + "\nНазвание: " + product1.getName() + "\nUPS: "
                            + product1.getUps() + "\nПроизводитель: " + product1.getManufacturer() + "\nЦена: "
                            + product1.getPrice() + " руб\nСрок хранения: " + product1.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product1.getAmount() + " шт");
                else if (product2.getName().equals(nameSearch))
                    System.out.println("\nID: " + product2.getId() + "\nНазвание: " + product2.getName() + "\nUPS: "
                            + product2.getUps() + "\nПроизводитель: " + product2.getManufacturer() + "\nЦена: "
                            + product2.getPrice() + " руб\nСрок хранения: " + product2.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product2.getAmount() + " шт");
                else if (product3.getName().equals(nameSearch))
                    System.out.println("\nID: " + product3.getId() + "\nНазвание: " + product3.getName() + "\nUPS: "
                            + product3.getUps() + "\nПроизводитель: " + product3.getManufacturer() + "\nЦена: "
                            + product3.getPrice() + " руб\nСрок хранения: " + product3.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product3.getAmount() + " шт");
                else if (product4.getName().equals(nameSearch))
                    System.out.println("\nID: " + product4.getId() + "\nНазвание: " + product4.getName() + "\nUPS: "
                            + product4.getUps() + "\nПроизводитель: " + product4.getManufacturer() + " год(-а)\nЦена: "
                            + product4.getPrice() + " руб\nСрок хранения: " + product4.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product4.getAmount() + " шт");
                else if (product5.getName().equals(nameSearch))
                    System.out.println("\nID: " + product5.getId() + "\nНазвание: " + product5.getName() + "\nUPS: "
                            + product5.getUps() + "\nПроизводитель: " + product5.getManufacturer() + "\nЦена: "
                            + product5.getPrice() + " руб\nСрок хранения: " + product5.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product5.getAmount() + " шт");
                else System.out.println("Товары не найдены");
                break;
            }
            case 3: {
                Scanner nameScanner = new Scanner(System.in);
                System.out.print("Введите название модели: ");
                String nameSearch = nameScanner.nextLine();
                Scanner priceScanner = new Scanner(System.in);
                System.out.print("Введите цену (верхний порог): ");
                int priceSearch = priceScanner.nextInt();

                if (product1.getName().equals(nameSearch) && product1.getPrice() <= priceSearch)
                    System.out.println("\nID: " + product1.getId() + "\nНазвание: " + product1.getName() + "\nUPS: "
                            + product1.getUps() + "\nПроизводитель: " + product1.getManufacturer() + "\nЦена: "
                            + product1.getPrice() + "\nСрок хранения: " + product1.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product1.getAmount() + " шт");
                else if (product2.getName().equals(nameSearch) && product2.getPrice() <= priceSearch)
                    System.out.println("\nID: " + product2.getId() + "\nНазвание: " + product2.getName() + "\nUPS: "
                            + product2.getUps() + "\nПроизводитель: " + product2.getManufacturer() + "\nЦена: "
                            + product2.getPrice() + "\nСрок хранения: " + product2.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product2.getAmount() + " шт");
                else if (product3.getName().equals(nameSearch) && product3.getPrice() <= priceSearch)
                    System.out.println("\nID: " + product3.getId() + "\nНазвание: " + product3.getName() + "\nUPS: "
                            + product3.getUps() + "\nПроизводитель: " + product3.getManufacturer() + "\nЦена: "
                            + product3.getPrice() + "\nСрок хранения: " + product3.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product3.getAmount() + " шт");
                else if (product4.getName().equals(nameSearch) && product4.getPrice() <= priceSearch)
                    System.out.println("\nID: " + product4.getId() + "\nНазвание: " + product4.getName() + "\nUPS: "
                            + product4.getUps() + "\nПроизводитель: " + product4.getManufacturer() + "\nЦена: "
                            + product4.getPrice() + "\nСрок хранения: " + product4.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product4.getAmount() + " шт");
                else if (product5.getName().equals(nameSearch) && product5.getPrice() <= priceSearch)
                    System.out.println("\nID: " + product5.getId() + "\nНазвание: " + product5.getName() + "\nUPS: "
                            + product5.getUps() + "\nПроизводитель: " + product5.getManufacturer() + "\nЦена: "
                            + product5.getPrice() + "\nСрок хранения: " + product5.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product5.getAmount() + " шт");
                else System.out.println("Товары не найдены");
                break;
            }
            case 4: {
                if (product1.getShelfLife() > 25)
                    System.out.println("\nID: " + product1.getId() + "\nНазвание: " + product1.getName() + "\nUPS: "
                            + product1.getUps() + "\nПроизводитель: " + product1.getManufacturer() + "\nЦена: "
                            + product1.getPrice() + "\nСрок хранения: " + product1.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product1.getAmount() + " шт");
                if (product2.getShelfLife() > 25)
                    System.out.println("\nID: " + product2.getId() + "\nНазвание: " + product2.getName() + "\nUPS: "
                            + product2.getUps() + "\nПроизводитель: " + product2.getManufacturer() + "\nЦена: "
                            + product2.getPrice() + "\nСрок хранения: " + product2.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product2.getAmount() + " шт");
                if (product3.getShelfLife() > 25)
                    System.out.println("\nID: " + product3.getId() + "\nНазвание: " + product3.getName() + "\nUPS: "
                            + product3.getUps() + "\nПроизводитель: " + product3.getManufacturer() + "\nЦена: "
                            + product3.getPrice() + "\nСрок хранения: " + product3.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product3.getAmount() + " шт");
                if (product4.getShelfLife() > 25)
                    System.out.println("\nID: " + product4.getId() + "\nНазвание: " + product4.getName() + "\nUPS: "
                            + product4.getUps() + "\nПроизводитель: " + product4.getManufacturer() + "\nЦена: "
                            + product4.getPrice() + "\nСрок хранения: " + product4.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product4.getAmount() + " шт");
                if (product5.getShelfLife() > 25)
                    System.out.println("\nID: " + product5.getId() + "\nНазвание: " + product5.getName() + "\nUPS: "
                            + product5.getUps() + "\nПроизводитель: " + product5.getManufacturer() + "\nЦена: "
                            + product5.getPrice() + "\nСрок хранения: " + product5.getShelfLife() + " месяцев(-а)\nКоличество: "
                            + product5.getAmount() + " шт");
                break;
            }
            case 0: break;
            default: System.out.println("Ошибка. Неверное значение");
        }
    }
}