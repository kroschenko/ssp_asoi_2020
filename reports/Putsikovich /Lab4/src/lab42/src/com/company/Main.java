package com.company;

class MyString{
    String text;
    boolean isUpperCase = false;

    public MyString(String text){
        this.text =text;
    }

    public void setIsUpperCase(boolean isUpperCase){
        this.isUpperCase = isUpperCase;
    }

    public String getText(){
        if(isUpperCase)
            return text.toUpperCase();
        else
            return text;
    }

    public void setText(String text){
        this.text = text;
    }
}

class Paragraph{
    MyString myString;
    int indent = 0;

    public Paragraph(String text){
        myString = new MyString(text);
    }

    public void setIndent(int indent){
        this.indent = indent;
    }

    public void setText(String text){
        myString.setText(text);
    }

    public void setIsUpperCase(boolean isUpperCase){
        myString.setIsUpperCase(isUpperCase);
    }

    public void print(){
        for(int i=0; i<indent; i++)
            System.out.print(" ");
        System.out.println(myString.getText());
    }
}

public class Main {

    public static void main(String[] args) {
	    Paragraph paragraph = new Paragraph("Hello world!");
	    paragraph.print();
	    paragraph.setIndent(5);
	    paragraph.setIsUpperCase(true);
        paragraph.print();
    }
}
