package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static String FileToStr(String path) {
        String str = "";
        try(FileReader reader = new FileReader(path))
        {
            // Читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                str = str+String.valueOf((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return str;
    }
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        //1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        //2. Sort list with Collections.sort(), provide a custom Comparator
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        //3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
         return sortedMap;
    }
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue());
            System.out.print(entry.getKey());
            System.out.println();
        }
    }
    public static void StrToWords(String str) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String words[] = str.replaceAll("[^аa-яzАA-ЯZ\\s+]", "").toLowerCase().split("\\s+");
        int val = 0;
        for(String e : words) {
            if(map.containsKey(e) == true) {
                val = map.get(e);
                map.replace(e,val+1);
            } else {
                map.put(e,1);
            }
        }
        Map<String, Integer> sortedMap = sortByValue(map);
        printMap(sortedMap);
    }
    public static void main(String[] args) {
        String str = FileToStr("test.txt");;
        System.out.println(str);
        StrToWords(str);
    }
}
