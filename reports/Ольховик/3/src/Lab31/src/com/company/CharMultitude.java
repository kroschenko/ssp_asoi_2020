package com.company;

import java.util.*;

public class CharMultitude {
    private int power;
    private Character [] list;

    public CharMultitude(int power, Character[] list) {
        this.power = power;
        if (power>= list.length)
            this.list = list;
        else {
            String str = String.format("Мощность указана меньше требуемой, будут использованы символы только до указаной мощности %d, у множества %s", this.power,Arrays.toString(list));
            System.out.println(str);
            List<Character> buff = new ArrayList<>(Arrays.asList(list));
            for (int i = power; i< list.length;i++)
                buff.remove(power);
            this.list = buff.toArray(new Character[this.power]);
        }
    }

    public void add(char a) {
        boolean full = true;
        Character [] buf = new Character[list.length+1];
        int i = 0;
        if (this.list.length == power) {
            System.out.println("Мощность вашего множества достигла ограничения, добавить символ нельзя");
        } else {
            for (Character ch :list) {
                buf[i] = ch;
                i++;
            }
            int id = this.list.length;
            buf[id] = a;
            list = buf;
        }
    }

    public void remove(char a) {
        List<Character> buff = new ArrayList<>(Arrays.asList(this.list));
        if (buff.contains(a)) {
            int id = buff.indexOf(a);
            buff.remove(id);
            list = buff.toArray(new Character[this.list.length-1]);
        }
    }

    public static String union(CharMultitude a, CharMultitude b) {
        Character[] union = new Character[a.list.length+b.list.length];
        int i=0;
        int j=a.list.length;
        for (Character ch : a.list) {
                union[i]=ch;
                i++;
        }
        for (Character ch : b.list) {
                union[j]=ch;
                j++;
        }
        return Arrays.toString(union);
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CharMultitude that = (CharMultitude) obj;

        if(this.power != that.power)
            return false;
        if (this.list.length != that.list.length)
            return false;
        for (int i=0; i < Math.min(this.list.length,that.list.length); i++) {
            if(this.list[i] != that.list[i])
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for(Character character : this.list)
            stringBuilder.append(" "+character+ ", ");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

}
