package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RecordBook recordBook = new RecordBook();
        ArrayList<RecordBook.Session.SessionField> data = new ArrayList<RecordBook.Session.SessionField>();
        data.add(new RecordBook().new Session().new SessionField(1,"Математика",3,"Экзамен"));
        data.add(new RecordBook().new Session().new SessionField(2,"Физика",7,"Зачет"));
        recordBook.sessionsList.add(new RecordBook().new Session(1,data));
        data.clear();
        data.add(new RecordBook().new Session().new SessionField(1,"Математика",6,"Экзамен"));
        data.add(new RecordBook().new Session().new SessionField(3,"Астрономия",9,"Зачет"));
        recordBook.sessionsList.add(new RecordBook().new Session(2,data));
        recordBook.showRecordBook();
    }
}

