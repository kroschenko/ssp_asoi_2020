
public class Word{
  private String word;
  private Byte[] meta;

  public Word(String _word){
    word = _word;
    //some meta
  }

  public String toUpper(){
    String w = "";
    for(int i = 0; i<word.length(); i++){
      w += Character.toUpperCase(word.charAt(i));
    }
    return w;
  }
  public String firstToUpper(){
    String w = word;
    char[] cw = w.toCharArray();
    cw[0] = Character.toUpperCase(word.charAt(0));
    w = String.valueOf(cw);
    return w;
  }
  public String toLower(){
    String w = "";
    for(int i = 0; i<word.length(); i++){
      w += Character.toLowerCase(word.charAt(i));
    }
    return w;
  }
  public void print(){
    System.out.println(word);
  }
  public String toString(){
    return word;
  }
}