import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
                //Task1____________________________________
                Scanner scr = new Scanner(System.in);
        int max = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[0]);
        int buf;
                System.out.println("Hello world!");
                int len1 = args.length;
                //Here agrs are compare (find max and min args)
                for(int i = 0; i < len1; i++)
                {
                    buf = Integer.parseInt(args[i]);
                    if(buf > max)
                        max = buf;
                    if(buf < min)
                        min = buf;
                }
                //result of task 1
                int sweep = max - min;
                System.out.println("Sweep of sequence is: " + sweep);

        //Task 2___________________________________________
        System.out.println("Task 2");

        //Initialization of array and indexes
        System.out.print("Enter element you want to remove: ");
        int element = scr.nextInt();
        long[] array = new long[args.length];
        for(int i = 0; i < len1; i++)
        {
            array[i] = Long.parseLong(args[i]);
        }

        //result of Task2
        System.out.println("Result array is: ");
        array = removeElement(array, element, len1);
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        //Task 3_____________________________________
        System.out.println("\nTask 3 starts here");
        System.out.println("Enter lenght of string you want: ");
        int strLength = scr.nextInt();
        System.out.println("Do u want to generate ASCII only string?");
        System.out.println("1-Yes\n2-No");
        int flagCheck = scr.nextInt();
        boolean ASCIIonly;
        if(flagCheck == 1) ASCIIonly = true;
        else ASCIIonly = false;

        String[] srt = new String[len1];
        System.out.print("The start string is: srt = ");
        for(int i = 0; i < len1; i++)
        {
            srt[i] = args[i];
            System.out.print(srt[i] + ", ");
        }
        String[] task_3_String;
        task_3_String = randomString(strLength, ASCIIonly);
        System.out.println("Generated string is: srt = ");
        for(int i = 0; i < task_3_String.length; i++)
            System.out.print(task_3_String[i]);
    }

    //Task 2_________________________________________________________
    static long[] removeElement(long[] array, long element, int len1)
        {
        int countOfEl = 0;
        for(int i = 0; i < len1; i++){
            if(array[i] == element) countOfEl++;
        }
        int sizeOfResArray = len1 - countOfEl;
        long[] resArray = new long[sizeOfResArray];
        countOfEl = 0;
        for(int i = 0; i < len1; i++)
        {
            if(array[i] != element){
                resArray[countOfEl] = array[i];
                countOfEl++;
            }
        }
        return resArray;
    }

    //Task 3__________________________________________________________________
    static String[] randomString(int length, boolean ASCIIonly)
    {
        char generatedString;
        Random random = new Random();
        String[] resString = new String[length];
        int r = 0;
        for(int i = 0; i < length; i++){
            if(ASCIIonly) {
                r = random.nextInt(254) + 1;
                generatedString = (char) r;
                resString[i] = String.valueOf(generatedString);
            }
            else {
                r = random.nextInt(1024) + 1;
                generatedString = (char) r;
                resString[i] = String.valueOf(generatedString);
            }
        }
        return resString;
    }
}
