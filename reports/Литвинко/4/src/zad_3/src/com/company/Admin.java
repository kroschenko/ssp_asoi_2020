package com.company;

public class Admin extends Person {

    public Admin(int id, String fio) {
        super(id, fio);
    }

    public void addToBlacklist(Reader reader){
        reader.setBlacklist(true);
    }
}
