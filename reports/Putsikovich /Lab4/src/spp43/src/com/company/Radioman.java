package com.company;

public class Radioman extends Worker{

    private String radioRange;

    public String getRadioRange() {
        return radioRange;
    }

    public void setRadioRange(String radioRange) {
        this.radioRange = radioRange;
    }

    public void work(){
        System.out.println("Радист работает!");
    }

    public void show(){
        System.out.println("Радист:");
        super.show();
        System.out.println("radioRange: "+radioRange);
    }

    public Radioman(int id, String fio, String radioRange){
        super(id, fio);
        this.radioRange = radioRange;
    }
}
