package com.company;

public class Main {

    public static void main(String[] args) throws Exception{
        if (args.length==0)
            throw new Exception("Count of arguments must be greater then 0");
        int shift= Integer.parseInt(args[args.length-1]);
        String buf="";
        int pos=0;
        for(int i=0; i<args.length-1; i++) {
            buf += args[i];
            if (i!=args.length-2) buf+=' ';
        }
        String str=shiftRight(buf,shift);
        System.out.println(str);
    }
    public static String shiftRight(String str, int shift) throws  Exception
    {
        shift%=str.length();
        if (str==null)
            return null;
        String result="";
        if (shift==0)
            return str;
        else if (shift<0)
        {
            for (int i=-shift; i<str.length();i++)
                result+=str.charAt(i);
            for (int i=0; i<-shift; i++)
                result+=str.charAt(i);
        }
        else
        {
            for (int i=str.length()-shift; i<str.length(); i++)
                result+=str.charAt(i);
            for (int i=0; i<str.length()-shift; i++)
                result+=str.charAt(i);
        }
        return result;
    }
}
