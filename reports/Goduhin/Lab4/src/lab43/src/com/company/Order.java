package com.company;

public class Order {
    private int id;
    private String receiver;
    private double sum;
    private boolean isPayed;

    public Order(int id, String receiver, double sum, boolean isPayed) {
        this.id = id;
        this.receiver = receiver;
        this.sum = sum;
        this.isPayed = isPayed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}
