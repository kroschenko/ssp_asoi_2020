package com.company;

public class Chassis {
    private String producer;
    private int size;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void show(){
        System.out.println("Шасси: ");
        System.out.println("producer: "+producer);
        System.out.println("size: "+size);
    }

    public Chassis(String producer, int size) {
        this.producer = producer;
        this.size = size;
    }
}
