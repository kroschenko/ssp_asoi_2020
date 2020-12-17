package com.company;

import java.util.ArrayList;

public class Payment{

    private ArrayList<Tovar> tovarList;
    private ArrayList<Tovar> myTovarList;

    class Tovar{
        private int id;
        private String name;
        private double price;
        private Integer count=null;

        public Tovar(int id, String name, double price){
            this.id=id;
            this.name=name;
            this.price=price;
        }

        public void show(){
            System.out.print("id="+id+"; name="+name+"; cost="+price);

            if(count!=null)
                System.out.println(", count="+count+", sum: "+price*count);
            else
                System.out.println();
        }

        public Tovar copy(){
            Tovar tovar = new Tovar(id, name, price);
            tovar.count = count;
            return tovar;
        }
    }

    public Payment(){
        tovarList = new ArrayList<Tovar>();
        myTovarList = new ArrayList<Tovar>();
    }

    public void fill(){
        tovarList.add(new Tovar(15, "Масло сливочное", 3.1));
        tovarList.add(new Tovar(68, "Шампиньоны", 5.7));
        tovarList.add(new Tovar(23, "Морковь 1 кг", 2.4));
        tovarList.add(new Tovar(14, "Конфеты Микс 500г", 3.83));
        tovarList.add(new Tovar(10, "Мороженое Юкки", 1.76));
    }

    public void addTovar(int id, int count){
        if(count<1)
            return;

        for(int i=0; i<myTovarList.size(); i++)
            if(myTovarList.get(i).id == id)
            {
                myTovarList.get(i).count += count;
                return;
            }

        for(int i=0; i<tovarList.size(); i++)
            if(tovarList.get(i).id == id)
            {
                Tovar tovar = tovarList.get(i).copy();
                tovar.count = count;
                myTovarList.add(tovar);
                return;
            }
    }

    public void deleteTovar(int id){
        for(int i=0; i<myTovarList.size(); i++)
            if(myTovarList.get(i).id == id) {
                myTovarList.remove(i);
                return;
            }
    }

    public void showTovar(boolean my){
        if(my)
            for(int i=0; i<myTovarList.size(); i++)
                myTovarList.get(i).show();
        else
            for(int i=0; i<tovarList.size(); i++)
                tovarList.get(i).show();
    }

}
