package com.company;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Str str=new Str();
        str.addStr("Hello World");
        str.addStr("How are you?");
        str.showString();
    }
    public static class Str
    {
        public ArrayList<Word> str=new ArrayList<Word>();
        public void addStr(String words)
        {
            Word temp=new Word();
            temp.addWords(words);
            str.add(temp);
        }
        public void showString()
        {
            for(Word item:str)
            {
                for(Word.Symbol item2:item.word)
                {
                    System.out.print(item2.symbol);
                }
                System.out.println();
            }
        }
    }
    public static class Word {
        //public String words;

        public ArrayList<Symbol> word = new ArrayList<Symbol>();

        public Word() {
        }

        public void addWords(String str) {
            for (String words:str.split(" ")) {
                for(String symbol:words.split(""))
                {
                    word.add(new Symbol(symbol));
                }
                word.add(new Symbol(" "));
            }
        }


        public class Symbol {
            String symbol;

            public Symbol(String symbol) {
                this.symbol = symbol;
            }
        }
    }
}
