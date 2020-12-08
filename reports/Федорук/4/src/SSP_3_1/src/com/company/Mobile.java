package com.company;

import java.util.*;

class Mobile{

    static class NewPhone {
        private int id;
        private String manufacturer;
        private String name;
        private int OZU;
        private int memory;
        private int price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public NewPhone(int id, String manufacturer, String name, int OZU, int memory, int price) {
            this.id = id;
            this.manufacturer = manufacturer;
            this.name = name;
            this.OZU = OZU;
            this.memory = memory;
            this.price = price;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOZU() {
            return OZU;
        }

        public void setOZU(int OZU) {
            this.OZU = OZU;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void print(){
            System.out.println("Название: " + name + ", Количество оперативной памяти: " + OZU + ", Количество общей памяти: " + memory + ", Цена: " + price);
        }
    }
    private ArrayList<NewPhone> phones = new ArrayList();
    public Mobile(){
        phones.add(new NewPhone(1,"Xiaomi","Redmi 7A", 6, 64, 350));
        phones.add(new NewPhone(2,"Motorolla","One", 4, 32, 300));
        phones.add(new NewPhone(3,"Samsung","Galaxy", 6, 128, 550));
        phones.add(new NewPhone(4,"Apple","Iphone X", 6, 64, 850));
        phones.add(new NewPhone(5,"HTC","Desire", 3, 32, 250));
    }

    public void printMobile(){
        for (int i = 0 ; i < phones.size(); i++){
            phones.get(i).print();
        }
    }
    private Map<Integer,Integer> prices = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> ozu = new HashMap<>();
    private Map<Integer, Integer> memory = new HashMap<>();
    private Map<Integer,Integer> count = new HashMap<>();

    public void sortFromPrice(){
        for (int i = 0 ; i < phones.size(); i++){
            prices.put(phones.get(i).getPrice(),phones.get(i).getId());
        }
        Map<Integer, Integer> sortPrice = new TreeMap<Integer,Integer>(prices);
        for (Map.Entry<Integer, Integer> entry : sortPrice.entrySet()){
            for (int j = 0 ; j < phones.size(); j++){
                if(entry.getValue()==phones.get(j).getId()){
                    phones.get(j).print();
                };
            }
        }
    }
    public void sort(){
        System.out.println("1 - Вывести в порядке возрастания ОЗУ");
        System.out.println("2 - Вывести в порядке возрастания количества памяти");
        System.out.println("3 - Уникальный механизм, выводящий в порядке выгодности предложений");
        Scanner input = new Scanner(System.in);
        int menu = input.nextInt();
        switch (menu){
            case 1:{
                for (int i = 0 ; i < phones.size(); i++){
                    ozu.put(phones.get(i).getOZU(), phones.get(i).getId());
                }
                Map<Integer, Integer> sortOZU = new TreeMap<Integer,Integer>(ozu);
                for (Map.Entry<Integer, Integer> entry : sortOZU.entrySet()){
                    for (int i = 0 ; i < phones.size(); i++){
                        if(entry.getValue()==phones.get(i).getId()){
                            phones.get(i).print();
                        };
                    }
                }
                break;
            }
            case 2:{
                for (int i = 0 ; i < phones.size(); i++){
                    memory.put(phones.get(i).getMemory(),phones.get(i).getId());
                }
                Map<Integer, Integer> sortMemory = new TreeMap<Integer,Integer>(memory);
                for (Map.Entry<Integer, Integer> entry : sortMemory.entrySet()){
                    for (int i = 0 ; i < phones.size(); i++){
                        if(entry.getValue()==phones.get(i).getId()){
                            phones.get(i).print();
                        };
                    }
                }
                break;
            }
            case 3:{
                for (int i = 0 ; i < phones.size(); i++){
                    int counts = 1000 - phones.get(i).getPrice() + phones.get(i).getOZU()*100 + phones.get(i).getMemory()*10;
                    count.put(counts,phones.get(i).getId());
                }
                Map<Integer, Integer> sortCount = new TreeMap<Integer,Integer>(count);
                for (Map.Entry<Integer, Integer> entry : sortCount.entrySet()){
                    for (int i = 0 ; i < phones.size(); i++){
                        if(entry.getValue()==phones.get(i).getId()){
                            phones.get(i).print();
                            System.out.println("Набрано очков " + entry.getKey());
                        };
                    }
                }
                break;
            }
        }
    }
}
