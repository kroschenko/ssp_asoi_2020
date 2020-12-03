package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Text text = new Text();
        text.addPage(1,"Тест","Привет");
        text.addPage(2,"Вторая","Страница","Тут","Много","Слов");
        text.showText();
    }

    public static class Text {
        //Поля и методы класса Текст
        public ArrayList<Page> text = new ArrayList<Page>();

        public void addPage(int id,String...words) {
            Page temp = new Page(id);
            temp.addWords(words);
            text.add(temp);
        }
        public void showText() {
            for(Page item : text) {
                System.out.println("\nСтраница №"+item.pageNumber);
                for(Page.Word item2 : item.page) {
                    System.out.print(item2.word+" ");
                }
            }
        }

        public class Page {
            public int pageNumber;
            public ArrayList<Word> page = new ArrayList<Word>();

            public Page(int pageNumber) {
                this.pageNumber = pageNumber;
            }

            public void addWords(String...words){
                for (int i = 0; i < words.length; i++) {
                    page.add(new Word(words[i]));
                }
            }

            public class Word {
                public String word;

                public Word(String word) {
                    this.word = word;
                }
            }
        }
    }
}
