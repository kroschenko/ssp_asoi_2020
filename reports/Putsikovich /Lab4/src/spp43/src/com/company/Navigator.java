package com.company;

public class Navigator extends Worker {
    private int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void work(){
        System.out.println("Штурман работает!");
    }

    public void show(){
        System.out.println("Штурман:");
        super.show();
        System.out.println("experience: "+experience);
    }

    public Navigator(int id, String fio, int experience){
        super(id, fio);
        this.experience = experience;
    }
}
