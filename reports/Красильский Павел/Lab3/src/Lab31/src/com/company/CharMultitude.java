package com.company;

import java.util.*;

public class CharMultitude {
    private int power;
    private Character [] list;

    public CharMultitude(int power, Character[] list) {
        Set<Character> uniq = new HashSet<Character>();
        uniq.addAll(Arrays.asList(list));
        list = uniq.toArray(new Character[0]);
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
        Set<Character> buff = new HashSet<>();
        if (this.list.length == power) {
            System.out.println("Мощность вашего множества достигла ограничения, добавить символ нельзя");
        } else {
            for (Character ch :list) {
                buff.add(ch);
            }
            buff.add(a);
            list = buff.toArray(new Character[0]);
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

    public static CharMultitude union(CharMultitude a, CharMultitude b) {
        Set<Character> setA = new HashSet<>();
        setA.addAll(Arrays.asList(a.list));
        Set<Character> setB = new HashSet<>();
        setB.addAll(Arrays.asList(b.list));
        Set<Character> unionSet = new HashSet<>();
        unionSet.addAll(setA);
        unionSet.addAll(setB);
        Character [] out = new Character[unionSet.size()];
        int i = 0;
        for (char ch : unionSet) {
            out[i] = ch;
            i++;
        }

        CharMultitude output = new CharMultitude(a.power+b.power, out);
        return output;
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
