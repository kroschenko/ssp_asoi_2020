package com.company;

public class Worker implements IWorker {
    private int id;
    private String fio;

    public void work(){
        System.out.println("Работник работает!");
    }

    public void show(){
        System.out.println("id: "+id);
        System.out.println("fio: "+fio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Worker(int id, String fio){
        this.id = id;
        this.fio = fio;
    }
}
