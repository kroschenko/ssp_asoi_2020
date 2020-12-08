package com.company;

public class Word {

    String word;

    public Word(String word){
        this.word = word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public void print(){
        System.out.print(word);
    }

    public boolean checkIsCorrect(){
        String[] temp = word.split(" ");
        if(temp.length==1)
            return true;
        else
            return false;
    }
}
