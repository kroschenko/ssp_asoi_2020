package com.company;

class Set {
    private int maxPower;
    private int power = 0;
    private int[] elements;

    public Set(int maxPower) {
        this.maxPower = maxPower;
        elements = new int[maxPower];
    }

    public Set() {
        this.maxPower = 10;
        elements = new int[maxPower];
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getElement(int index) {
        return elements[index];
    }

    public int getPower() {
        return power;
    }

    public boolean checkExistElement(int element) {
        for (int i = 0; i < power; i++)
            if (elements[i] == element)
                return true;

        return false;
    }

    public void addElement(int element) {
        if (power == maxPower)
            return;

        for (int i = 0; i < power; i++)
            if (elements[i] == element)
                return;

        elements[power] = element;
        power++;
    }

    public void removeElement(int element) {
        for (int i = 0; i < power; i++)
            if (elements[i] == element) {
                for (int j = i; j < power - 1; j++)
                    elements[j] = elements[j + 1];

                power--;
                return;
            }
    }

    public boolean union(Set set) {
        int[] addedElements = new int[set.getMaxPower()];
        int addedElementsLength = 0;

        for (int i = 0; i < set.getPower(); i++) {
            if (!checkExistElement(set.getElement(i))) {
                addedElements[addedElementsLength] = set.getElement(i);
                addedElementsLength++;
            }
        }

        if (power + addedElementsLength > maxPower)
            return false;

        for (int i = 0; i < addedElementsLength; i++)
            addElement(addedElements[i]);

        return true;
    }

    public void print() {
        System.out.print("Set: ");

        for (int i = 0; i < power; i++) {
            System.out.print(elements[i]);
            if (i + 1 != power)
                System.out.print(",");
        }

        System.out.println();
    }

    public boolean equals(Set set) {
        if (set.getPower() != power)
            return false;

        for (int i = 0; i < power; i++)
            if (!set.checkExistElement(elements[i]))
                return false;

        return true;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Set: ");

        for (int i = 0; i < power; i++) {
            str.append(elements[i]);
            if (i + 1 != power)
                str.append(",");
        }

        return str.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        Set set1 = new Set();
        for (int i = 0; i < 10; i++)
            set1.addElement(i);

        Set set2 = new Set(15);

        for (int i = 0; i < 10; i++)
            set2.addElement(i + 5);

        System.out.print("Set1 to string format: ");
        System.out.println(set1.toString());

        System.out.print("Set2 to string format: ");
        System.out.println(set2.toString());

        boolean result = set2.union(set1);

        if (!result)
            System.out.println("error union set2 <- set1.");
        else {
            System.out.print("Result union set2 <- set1: ");
            set2.print();
        }

        result = set1.union(set2);

        if (!result)
            System.out.println("error union set1 <- set2.");
        else {
            System.out.print("Result union set1 <- set2: ");
            set1.print();
        }

        set1.removeElement(5);
        set1.removeElement(7);
        set1.addElement(12);

        System.out.print("Set1 after remove 5, 7 and add 12: ");
        set1.print();

        System.out.println("Set1 exists 1? " + set1.checkExistElement(1));
        System.out.println("Set1 exists 11? " + set1.checkExistElement(11));

        System.out.println("Set1 equals Set2? " + set1.equals(set2));

        Set set3 = new Set(20);

        for (int i = 0; i < 5; i++)
            set3.addElement(i);

        set3.addElement(6);
        set3.addElement(8);
        set3.addElement(9);
        set3.addElement(12);

        System.out.print("Set3 to string format: ");
        System.out.println(set3.toString());

        System.out.println("Set1 equals Set3? " + set1.equals(set3));
    }
}
