package com.company;

public class Main {
    public static void main(String[] args) {
        myset arr = new myset(1,2,3,4,5);
        myset arr2 = new myset(1,6,7,4,5);
        arr.add(10);
        PrintSet("First set", arr);
        Checker(arr, 2);
        arr.delete(2);
        Checker(arr, 2);
        PrintSet("First set", arr);
        System.out.println("Set power is " + arr.size());
        arr.join(arr2);
        PrintSet("First set", arr);
        System.out.println("Set power is " + arr.size());
        System.out.println("toString check: " + arr.toString());
        PrintSet("First set", arr);
        PrintSet("Second set", arr2);
        System.out.print("Sets are " + (arr.equals(arr2) ? "equal" : "not equal"));
    }
    public static void Checker(myset s, Object o){
        if(s.has(o))
            System.out.println("Set includes " + o);
        else
            System.out.println("Set does not include " + o);
    }
    public static void PrintSet(String name, myset set){
        System.out.println(name);
        set.print();
    }

}

class myset<T> {
    private T[] mset;
    private int size;
    public myset(T ... elements){
        size = elements.length;
        mset = (T[]) new Object[size];
        for(int i = 0; i<size; i++)
            mset[i] = elements[i];
    }
    public T[] getElements(){
        return mset;
    }
    public boolean has(Object element){
        for(T i : mset)
            if(element.equals(i))
                return true;
        return false;
    }
    public void add(Object element){
        if(has(element))
            return;
        T[] temp = (T[]) new Object[size+1];
        for(int i = 0; i<size; i++){
            temp[i] = mset[i];
        }
        temp[size] = (T) element;
        size++;
        mset = temp;
    }
    public myset join(myset secondSet){
        for(Object i : secondSet.getElements())
            if(!has(i))
                add(i);
        return this;
    }
    public void delete(Object element){
        if(has(element)){
            T[] temp = (T[]) new Object[size-1];
            for(int i = 0, j = 0; i<size; i++, j++){
                if(!mset[i].equals(element))
                    temp[j] = mset[i];
                else
                    j--;
            }
            size--;
            mset = temp;
        }
    }
    public boolean equals(myset secondSet){
        if(this.size != secondSet.size)
            return false;
        for(T i : mset){
            if(secondSet.has(i) == false){
                return false;
            }
        }
        return true;
    }
    public void print(){
        for(T i : mset){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public String toString(){
        String str = "";
        for(T elem : mset){
            str += elem.toString() + " ";
        }
        return str;
    }
    public int size(){
        return size;
    }
}
