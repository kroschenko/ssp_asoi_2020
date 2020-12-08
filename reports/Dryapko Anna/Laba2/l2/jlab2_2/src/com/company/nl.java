package com.company;

import java.io.*;
import java.nio.charset.*;
import java.util.ArrayList;
import java.util.Scanner;

public class nl {

    public static ArrayList<String> FileToStrList(String path) {
        ArrayList<String> text = new ArrayList<String>();
        try {
            File file = new File(path);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            text.add(line);
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                text.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text.remove(text.size()-1);
        return text;
    }
    public static ArrayList<String> InputToStrList() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<String>();
        boolean cont = true;
        while(cont == true) {
            System.out.println("Enter new line: ");
            String line = in.nextLine();
            text.add(line);
            System.out.println("Continue? [y]: ");
            String answ = in.nextLine();
            if(!answ.equals("y")) {
                cont = false;
            }
        }

        return text;
    }
    public static String addNum(String text, int textlen, char side, char zeros, int counter ,int inc) {
        String numformat = String.valueOf(counter);
        if(textlen > 9 && zeros == 'z') {
            String countzeros = "%0"+String.valueOf(inc*textlen).length()+"d";
            numformat = String.format(countzeros,counter);
        }
        StringBuffer sb = new StringBuffer(text);
        int pos = 0;
        if(side == 'l') {
            pos = 0;
        } else {
            pos = text.length();
        }
        String nsb = sb.insert(pos,numformat).toString();
        return nsb;
    }
    public static String printText(String text, int textlen,char side, char zeros, int counter, int inc, int addnum) {
        String newline;
        if(addnum == 1) {
            newline = addNum(text, textlen, side, zeros,counter,inc);

        } else {
            newline = text;
        }
        return newline;
    }
    public static ArrayList<String> numStrList(ArrayList<String> text, String arg1, int arg2, String arg3, int arg4, String arg5, String arg6) {
        ArrayList<String> newtext = new ArrayList<String>();
        if(arg1.equals("-i") && arg3.equals("-l") && arg5.equals("-n")) {
            int textlen = text.size();
            char side = arg6.charAt(0);
            char zeros = arg6.charAt(1);
            int emptycounter = 0;
            int counter = 1;
            for(int i=0;i<textlen;i++) {
                if(text.get(i).length() == 0 && arg4 == 0) {
                    emptycounter=emptycounter+arg2;
                    newtext.add(printText(text.get(i),textlen,side,zeros,counter-emptycounter,arg2,0));
                } else {
                    newtext.add(printText(text.get(i),textlen,side,zeros,counter-emptycounter,arg2,1));
                }
                counter = counter+arg2;
            }
        } else{
            System.out.println("Вы неверно указали параметры");
        }
        return newtext;

    }

    public static void main(String[] args) {
	    System.out.print("Input arguments: ");
	    for(String el : args) {
	        System.out.print(el+" ");
        }
	    System.out.println();
        ArrayList<String> finaltext = new ArrayList<String>();
	    if(args[0].equals("nl")) {
	        if(args.length > 7) {
	            if(args[7].equals("-")) {
                    ArrayList<String> text = new ArrayList<String>(InputToStrList());
                    finaltext = numStrList(text,args[1],Integer.parseInt(args[2]) ,args[3],Integer.parseInt(args[4]),args[5],args[6]);
                } else {
                    ArrayList<String> text = new ArrayList<String>(FileToStrList(args[7]));
                    finaltext = numStrList(text,args[1],Integer.parseInt(args[2]) ,args[3],Integer.parseInt(args[4]),args[5],args[6]);
                }
            } else {
                ArrayList<String> text = new ArrayList<String>(InputToStrList());
                finaltext = numStrList(text,args[1],Integer.parseInt(args[2]) ,args[3],Integer.parseInt(args[4]),args[5],args[6]);
            }

        } else {
	        System.out.println("Вы неверно ввели название утилиты");
        }
	    if(args.length > 8) {
            try(FileWriter writer = new FileWriter(args[8], true))
            {
                for(String line : finaltext) {
                    writer.write(line);
                    writer.write("\n");
                    writer.flush();
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        } else {
            for(String line : finaltext) {
                System.out.println(line);
            }
        }

    }
}
