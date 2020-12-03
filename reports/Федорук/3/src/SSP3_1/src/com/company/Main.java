package com.company;

import java.util.ArrayList;

class Set {
    private int power = 0;
    private ArrayList<Double> numbers;

    public Set(){
        numbers = new ArrayList<Double>();
    }

    public Double getElement(int index){
        return numbers.get(index);
    }

    public int getPower(){
        return power;
    }

    public boolean checkExistElement(double element){
        if(numbers.contains(element))
            return true;
        else
            return false;
    }

    public void addElement(double element){
        numbers.add(element);
    }

    public void removeElement(double element){
        numbers.remove(element);
    }

    public ArrayList intersection(Set set) {
        ArrayList<Double> addedNumbers = new ArrayList<>();

        for (double element: numbers
             ) {
                if(set.numbers.contains(element))
                    addedNumbers.add(element);
        }
       return addedNumbers;
    }
    
    public void print(){
        System.out.print("Set: ");

        for (double element: numbers
             ) {
            System.out.print(element+",");
        }
    }

    public boolean equals(Set set){
        if(set.getPower() != power)
            return false;

        for (double element: numbers
             ) {
            if (!set.checkExistElement(element))
                return false;
        }
        return true;
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("Set: ");
        for (double element: numbers
             ) {
            str.append(element);
            str.append(",");
        }
        return str.toString();
    }

}
public class Main {

    public static void main(String[] args) {
	Set set1 = new Set();
	for(int i = 0; i < 5 ; i++){
	    double random = Math.random()*100;
        set1.addElement(random);
    }
	set1.addElement(2.0);

	Set set2 = new Set();
	for(int i = 0; i < 5 ; i++){
	    double random = Math.random()*100;
	    set2.addElement(random);
	}
	set2.addElement(2.0);

	System.out.print("Set1 to string format: ");
	System.out.println(set1.toString());

	System.out.print("Set2 to string format: ");
    System.out.println(set2.toString());

    ArrayList<Double> result = set2.intersection(set1);
        System.out.print("Result intersection set2 <- set1:");

        for (double element: result
             ) {
            System.out.print(element+",");
        }
    set1.removeElement(2.0);
    set2.removeElement(2.0);
    System.out.print("\nSet2 after remove 2.0: ");
    set1.print();
    System.out.println("\nSet1 exist 93.7?: " + set1.checkExistElement(93.7));
    set1.addElement(93.7);
    System.out.println("Set1 exist 93.7? " + set1.checkExistElement(93.7));
    System.out.println("Set1 equals Set2? " + set1.equals(set2));
    }
}
