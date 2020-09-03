package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        String [] buff = new String[args.length];
        for (int i=0;i<args.length;i++)
            buff[i]=args[i];
        int length = 0;
        char symbol = '\0';
        String output;
        if ( args.length != 2 )
            throw new Exception ( "Wrong number of input arguments." );
        length = Integer.parseInt(buff[1]);
        symbol = buff[0].charAt(0);
        output = repeat(symbol,length);
        System.out.print(output);
    }
    public static String repeat(char ch, int repeat) {
        String stringch = new String();
        for (int i=0;i<repeat;i++)
            stringch+=ch;
        return stringch;
    }
}
