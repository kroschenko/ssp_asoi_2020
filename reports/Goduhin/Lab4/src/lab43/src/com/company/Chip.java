package com.company;

public class Chip {
    private int id;
    private String producer;

    public Chip(int id, String producer) {
        this.id = id;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
