package com.company;

public class Main {

    public static void main(String[] args) {
        Indent indent = new Indent();
        System.out.println(indent.addWord("Получился"));
        System.out.println(indent.addWord("это слово не вставится"));
        System.out.println(indent.addWord("тестовый"));
        System.out.println(indent.addWord("абзац"));
        indent.print();
    }
}
