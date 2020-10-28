package com.company;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("file1.txt"), StandardCharsets.UTF_8);
        HashMap<Integer,Integer> map = new HashMap<>();
        String regex = "[0-9]+";
        int count = 0;
        int numline = 0;
        for(String line: lines){
            numline++;
            for (String symbol : line.split("")) {
                if (symbol.matches(regex)) {
                    count++;
                    map.put(count,numline);
                }
            }

        }
        int pointer = count /2;
        System.out.println(lines.get(map.get(pointer)-1));

    }
}
