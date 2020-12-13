import java.util.*;

public class Abzac{
  public Abzac(){
    words = new Vector<>();
  }
  public Abzac(Word ..._words){
    words = new Vector<>();
    for(Word word : _words)
      words.addElement(word);
    words_count = words.size();
  }

  public void print(){
    if(words_count < 1 ){
      System.out.println("Nothing to print");
      return;
    }
    for(int i = 0; i<words.size(); i++){
      if(i == 0){
        System.out.print(words.elementAt(i).firstToUpper() + " ");
      } else {
        System.out.print(words.elementAt(i).toString() + " ");
      }      
    }
    System.out.println();
  }
  public void addWord(String word){
    words.addElement(new Word(word));
    words_count = words.size();
  }
  public void addWord(Word word){
    words.addElement(word);
    words_count = words.size();
  }

  private Vector<Word> words;
  private int words_count;
}