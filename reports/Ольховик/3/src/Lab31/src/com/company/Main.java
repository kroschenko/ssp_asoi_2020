package com.company;

public class Main {

    public static void main(String[] args) {
        CharMultitude firstSet = new CharMultitude(10,new Character[]{'a','a','b','c','a','a','b','c','a','a','a'});
        CharMultitude secondSet = new CharMultitude(10,new Character[]{'a','d','f'});
        System.out.println(firstSet);
        System.out.println(secondSet);
        System.out.println("Объединение множеств");
        System.out.println(CharMultitude.union(firstSet, secondSet));
        System.out.println("Добавление");
        secondSet.add('1');
        System.out.println(secondSet);
        System.out.println("Удаление");
        secondSet.remove('f');
        System.out.println(secondSet);
        CharMultitude firstEq = new CharMultitude(10, new Character[]{'a','d','f'});
        CharMultitude secondEq = new CharMultitude(10, new Character[]{'a','d','c'});
        CharMultitude thirdEq = new CharMultitude(1, new Character[]{'a','d','f'});
        System.out.println(firstEq.toString() + " == " + secondEq.toString() + " "+ firstEq.equals(secondEq));
        System.out.println(firstEq.toString() + " == " + thirdEq.toString() + " "+ firstEq.equals(thirdEq));
    }
}
