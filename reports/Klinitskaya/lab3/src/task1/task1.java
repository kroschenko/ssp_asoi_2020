import  java.io.*;
import java.lang.*;
class CustomArray {
    int power, pos;
    int[] customArray;

    //зададим конструктору изначальную инициализацию множества
    CustomArray(int power) {
        this.power = power;
        customArray = new  int[power];
        for (int i = 0; i < power; i++)
            customArray[i] = 0;
    }
    CustomArray(int power, int numb) {
        this.power = power;
        customArray = new  int[power];
        for(int i = 0; i < power; i++)
            customArray[i] = numb;
    }

    //создадим метод вывода множества на экран
    public void see() {
        System.out.print("\nArray power is: "+power+"\nArray consists of: ");
        for(int i = 0; i < power - 1; i++)
            System.out.print("["+customArray[i]+"], ");
        System.out.print("["+customArray[power - 1]+"] elements");
    }

    //определим методы добавления, получения и удаления элемента в множество и из него
    public void setEl(int position, int number) {
        this.pos = position;
        customArray[pos] = number;
    }
    public int getEl(int pos)
    {
        return customArray[pos];
    }
    public int getPos(int numb){
        for(int i = 0; i < power; i++){
            if(customArray[i] == numb) this.pos = i;
        }
        return pos;
    }

    //удаление элемента как по заданной позиции, так и по конкретному числу
    public void deleteElPos(int position){
        for(int i = position; i < power - 1; i++){
            customArray[position] = customArray[position + 1];
        }
        this.power--;
    }

    public void deleteElNumb(int numb){
        for(int i = 0; i < power; i++) {
            if (customArray[i] == numb) this.pos = i;
        }
        for(int i = pos; i < power - 1; i++){
            customArray[pos] = customArray[pos + 1];
        }
        this.power--;
    }

    //проверка наличия элемента в массиве
    public boolean isExist(int numb)
    {
        for(int i = 0; i < power; i++){
            if(customArray[i] == numb) return true;
        }
        return false;
    }

    //сравнение мощностей множеств. 1 - больше, 0 - равны, -1 - меньше
    public int compareArr(CustomArray customArray){
        if(this.power > customArray.power) return 1;
        if(this.power < customArray.power) return -1;
        return 0;
    }

    //сравнение элементов множеств.
    public int compareElArr(CustomArray customArray){
        if(this.power != customArray.power)
            return -1;
            for(int i = 0; i < power; i++){
                if(this.customArray[i] != customArray.getEl(i))
                    return -1;
            }
        return 1;
    }
}
//демонстрация работы пользовательского класса
public class task1{
    public static void main(String[] args)
    {
        CustomArray myArray1 = new CustomArray(5);
        myArray1.see();
        CustomArray myArr2 = new CustomArray(5,2);
        myArr2.see();
        myArr2.setEl(1, 4);
        System.out.println("\nDoes numb 4 exist in this array? "+myArr2.isExist(4));
        myArr2.deleteElNumb(4);
        myArr2.see();
        System.out.println("\nDoes first array have more power than second for now? " + myArray1.compareArr(myArr2));
        myArray1.setEl(4,3);
        System.out.println("Which pos number 3 is on? " + myArray1.getPos(3));
        CustomArray testarr = new CustomArray(5);
        myArray1.see();
        testarr.see();
        System.out.println("\nCompare elemets of 2 arrays: "+testarr.compareElArr(myArray1));
    }
}