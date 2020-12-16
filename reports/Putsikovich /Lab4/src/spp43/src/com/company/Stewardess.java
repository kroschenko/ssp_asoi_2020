package com.company;

public class Stewardess extends Worker {
    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void work(){
        System.out.println("Стюардесса работает!");
    }

    public void show(){
        System.out.println("Стюардесса:");
        super.show();
        System.out.println("category: "+category);
    }

    public Stewardess(int id, String fio, int category){
        super(id, fio);
        this.category = category;
    }
}
