package com.company;

import java.util.ArrayList;

public class Indent {

    ArrayList<Word> words = new ArrayList<Word>();
    int margin = 5;

    public void setMargin(int margin){
        this.margin = margin;
    }

    public boolean addWord(String word){
        Word temp = new Word(word);
        if(!temp.checkIsCorrect())
            return false;

        words.add(temp);
        return true;
    }

    public void print(){
        if(words.size()==0)
            System.out.println("Пустой абзац");
        else
        {
            for(int i=0; i<margin; i++)
                System.out.print(" ");
            for(int i=0; i<words.size(); i++) {
                words.get(i).print();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
