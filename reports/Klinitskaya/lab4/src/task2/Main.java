package com.company;
import java.util.ArrayList;

//создали класс для слова
//слово можно задавать при инициализации класа или задавать
//так же выводить на печать.
class Word {

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
    //т.к. класс - слово, то заданная строка обязана содержать неразрывные буквы
    public boolean isCorrectWord(){
        //если больше одного слова (пошли на улицу), то мы определяем это по пробелам
        String[] temp = word.split(" ");
        if(temp.length==1)
            return true;
        else
            return false;
    }
}
//создаем класс Абзаца
class Paragraph {
    //создаем список абзаца из слов
    ArrayList<Word> paragraph = new ArrayList<Word>();
    //отступ
    int margin = 5;

    public void setMargin(int margin){
        this.margin = margin;
    }
    //добавить слово в абзац
    public boolean addWord(String word){
        Word temp = new Word(word);
        if(!temp.isCorrectWord())
            return false;

        paragraph.add(temp);
        return true;
    }
    //вывести абзац на печать
    public void print(){
        if(paragraph.size()==0)
            System.out.println("Пустой абзац");
        else
        {
            for(int i=0; i<margin; i++)
                System.out.print(" ");
            for(int i = 0; i< paragraph.size(); i++) {
                paragraph.get(i).print();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
public class Main {

    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph();
        paragraph.addWord("This");
        paragraph.addWord("is");
        paragraph.addWord("test");
        paragraph.addWord("start");
        paragraph.addWord("aaa aaa aaa");
        paragraph.addWord("!");
        paragraph.print();
    }
}
