package com.company;


public class Main {

    public static void main(String[] args) {
	    Word word = new Word("Hello");
	    Word word1 = new Word("world");
	    Word word2 = new Word("it`s");
	    Word word3 = new Word("test");

	    Line line = new Line();
	    line.addValue(word);
	    line.addValue(word1);
	    Line line1 = new Line();
	    line1.addValue(word2);
	    line1.addValue(word3);

	    Page page = new Page();
	    page.addBody(line);
	    page.addBody(line1);
        page.addBody(word1);
        page.addBodyNL(word3);

        System.out.println("Our page: " + page.getBody());
    }
}
