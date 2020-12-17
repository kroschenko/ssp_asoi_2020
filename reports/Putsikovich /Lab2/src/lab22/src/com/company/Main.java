package com.company;

import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws Exception {
        int count = 10;

        if (args.length == 2)
        {
            try {
                count = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("error");
                return;
            }
        }
        else if (args.length == 3)
        {
            try {
                count = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("error");
                return;
            }
            if (!args[0].equals("-n")) {
                System.out.println("error");
                return;
            }
        }


        if (args.length == 0 || args.length > 3)
        {
            System.out.println("error");
            return;
        }

        RandomAccessFile file = new RandomAccessFile(args[args.length - 1], "r");

        int currentLine = 0;

        long p = file.length() - 1;

        while(p>0)
        {
            file.seek(p);
            char c = (char) file.readByte();
            if (c == '\n')
                currentLine++;

            if (currentLine == count)
                break;

            p--;
        }

        if(p>0)
            p++;

        file.seek(p);

        for(currentLine=0; currentLine<count; currentLine++)
        {
           String line = file.readLine();

           if(line==null)
               break;
           else
               System.out.println(line);
        }


    }
}
