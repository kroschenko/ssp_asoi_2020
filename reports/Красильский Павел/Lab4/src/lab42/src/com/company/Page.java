package com.company;

public class Page {
    private String body = "";

    public void addBody(Word word) {
        body += " " + word.getValue();
    }

    public void addBodyNL(Word word) {
        body += "\n " + word.getValue();
    }

    public void addBody(Line line) {
        body += "\n" + line.getValue();
    }

    public String getBody() {
        return body;
    }
}
