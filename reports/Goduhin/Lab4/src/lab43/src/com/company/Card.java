package com.company;

public class Card {
    private int id;
    private Chip chip;
    private double dept = 0;
    private double maxDept;
    private boolean isBlocked = false;

    public Card(int id, double maxDept, Chip chip) {
        this.id = id;
        this.maxDept = maxDept;
        this.chip = chip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDept() {
        return dept;
    }

    public void setDept(double dept) {
        this.dept = dept;
    }

    public double getMaxDept() {
        return maxDept;
    }

    public void setMaxDept(double maxDept) {
        this.maxDept = maxDept;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
