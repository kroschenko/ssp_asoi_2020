package com.company;

public class Admin extends People implements AdminInterface {

    public Admin(int id, String fio) {
        super(id, fio);
    }

    public void blockCard(Card card){
        if(card.getDept()>card.getMaxDept())
            card.setBlocked(true);
    }
}
