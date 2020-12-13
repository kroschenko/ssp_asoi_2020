package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Please, input params by pattern ([-c | -d | -u] [-i] [Path_input_file [Path_output_file]])\nFor example: uniq -c -i file1.txt file2.txt");
        Scanner scanner = new Scanner(System.in);
        String input;
        List<String> defInput = new ArrayList<>();
        String defOutput = "File2.txt";
        List <String> params;
        int i =0;
        input = scanner.nextLine();
        params = Arrays.asList(input.split(" "));
        if (params.size()>=2 && params.size()<=5) {
        if(params.get(0).equals("uniq") && (params.get(1).equals("-c") || params.get(1).equals("-d") || params.get(1).equals("-u"))) {
            switch (params.get(1)) {
                case "-c":
                    if (params.size() == 5) {
                        if (params.get(2).equals("-i")) {
                            if (params.get(3).equals("-")) {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                                uniqC(defInput, params.get(4), true); // -i - out
                            } else {
                                uniqC(params.get(3), params.get(4), true); // -i in out
                            }
                        }
                    } else if (params.size() == 4) {
                        if (params.get(2).equals("-i")) {
                            if (params.get(3).equals("-")) {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqC(defInput, defOutput, true); //-i -
                            } else {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqC(defInput, params.get(3), true); //-i out
                            }
                        } else if (params.get(2).equals("-")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqC(defInput, params.get(3), false); //- out
                        } else {
                            uniqC(params.get(2), params.get(3), false); //in out
                        }
                    } else if (params.size() == 3) {
                        if (params.get(2).equals("-i")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqC(defInput, defOutput, true); //-i
                        } else if (params.get(2).equals("-")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqC(defInput, defOutput, false); //-
                        } else {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqC(defInput, params.get(2), false); //out
                        }
                    } else if (params.size() == 2) {
                        System.out.println("Input number your strings: ");
                        i=Integer.parseInt(scanner.next());
                        System.out.println("Enter your strings: ");
                        for (int j=0; j<i;j++)
                            defInput.add(scanner.next());
                        uniqC(defInput, defOutput, false); //
                    }
                    break;
                case "-d":
                    if (params.size() == 5) {
                        if (params.get(2).equals("-i")) {
                            if (params.get(3).equals("-")) {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqD(defInput, params.get(4), true); // -i - out
                            } else {
                                uniqD(params.get(3), params.get(4), true); // -i in out
                            }
                        }
                    } else if (params.size() == 4) {
                        if (params.get(2).equals("-i")) {
                            if (params.get(3).equals("-")) {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqD(defInput, defOutput, true); //-i -
                            } else {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqD(defInput, params.get(3), true); //-i out
                            }
                        } else if (params.get(2).equals("-")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqD(defInput, params.get(3), false); //- out
                        } else {
                            uniqD(params.get(2), params.get(3), false); //in out
                        }
                    } else if (params.size() == 3) {
                        if (params.get(2).equals("-i")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqD(defInput, defOutput, true); //-i
                        } else if (params.get(2).equals("-")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqD(defInput, defOutput, false); //-
                        } else {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqD(defInput, params.get(2), false); //out
                        }
                    } else if (params.size() == 2) {
                        System.out.println("Input number your strings: ");
                        i=Integer.parseInt(scanner.next());
                        System.out.println("Enter your strings: ");
                        for (int j=0; j<i;j++)
                            defInput.add(scanner.next());
                        uniqD(defInput, defOutput, false); //
                    }
                    break;
                case "-u":
                    if (params.size() == 5) {
                        if (params.get(2).equals("-i")) {
                            if (params.get(3).equals("-")) {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqU(defInput, params.get(4), true); // -i - out
                            } else {
                                uniqU(params.get(3), params.get(4), true); // -i in out
                            }
                        }
                    } else if (params.size() == 4) {
                        if (params.get(2).equals("-i")) {
                            if (params.get(3).equals("-")) {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqU(defInput, defOutput, true); //-i -
                            } else {
                                System.out.println("Input number your strings: ");
                                i=Integer.parseInt(scanner.next());
                                System.out.println("Enter your strings: ");
                                for (int j=0; j<i;j++)
                                    defInput.add(scanner.next());
                                uniqU(defInput, params.get(3), true); //-i out
                            }
                        } else if (params.get(2).equals("-")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqU(defInput, params.get(3), false); //- out
                        } else {
                            uniqU(params.get(2), params.get(3), false); //in out
                        }
                    } else if (params.size() == 3) {
                        if (params.get(2).equals("-i")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqU(defInput, defOutput, true); //-i
                        } else if (params.get(2).equals("-")) {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqU(defInput, defOutput, false); //-
                        } else {
                            System.out.println("Input number your strings: ");
                            i=Integer.parseInt(scanner.next());
                            System.out.println("Enter your strings: ");
                            for (int j=0; j<i;j++)
                                defInput.add(scanner.next());
                            uniqU(defInput, params.get(2), false); //out
                        }
                    } else if (params.size() == 2) {
                        System.out.println("Input number your strings: ");
                        i=Integer.parseInt(scanner.next());
                        System.out.println("Enter your strings: ");
                        for (int j=0; j<i;j++)
                            defInput.add(scanner.next());
                        uniqU(defInput, defOutput, false); //
                    }
                    break;
                default:
                    System.out.println("Not correct param for read");
                    break;
            }
        } else {
            System.out.println("Not correct param/method");
        }
        } else if (params.size() == 1 && params.get(0).equals("uniq")) {
                System.out.println("Please, input at least 1 param");
        } else {
            System.out.println("Not correct method, try again");
        }
        scanner.close();

    }

    static void uniqU(String inputPath, String outputPath, boolean ignoreCase) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputPath), StandardCharsets.UTF_8);
        int i =0;
        for(String line: lines){
            if (ignoreCase) {
                lines.set(i,line.toLowerCase());
            }
            i++;
        }
        Set<String> s = new LinkedHashSet<>(lines);
        Files.write(Path.of(outputPath),s);
        if (ignoreCase)
            System.out.println("Util uniq with keys -u, -i is successfully completed");
        else
            System.out.println("Util uniq with key -u is successfully completed");
    }

    static void uniqU(List<String> lines, String outputPath, boolean ignoreCase) throws IOException {
        int i =0;
        for(String line: lines){
            if (ignoreCase) {
                lines.set(i,line.toLowerCase());
            }
            i++;
        }
        Set<String> s = new LinkedHashSet<>(lines);
        Files.write(Path.of(outputPath),s);
        if (ignoreCase)
            System.out.println("Util uniq with keys -u, -i is successfully completed");
        else
            System.out.println("Util uniq with key -u is successfully completed");
    }

    static void uniqD(String inputPath, String outputPath, boolean ignoreCase) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputPath), StandardCharsets.UTF_8);
        List<String> outLines = new ArrayList<>();
        int i = 0;
        for (String line : lines) {
            for (int j =0; j<lines.size();j++) {
                if (i!=j) {
                    if (ignoreCase){
                        if (line.equalsIgnoreCase(lines.get(j))) {
                            outLines.add(line);
                        }
                    } else {
                        if (line.equals(lines.get(j))) {
                            outLines.add(line);
                        }
                    }
                }
            }
            i++;
        }
        Set<String> s = new LinkedHashSet<>(outLines);
        Files.write(Path.of(outputPath),s);
        if (ignoreCase)
            System.out.println("Util uniq with keys -d, -i is successfully completed");
        else
            System.out.println("Util uniq with key -d is successfully completed");
    }

    static void uniqD(List<String> lines, String outputPath, boolean ignoreCase) throws IOException {
        List<String> outLines = new ArrayList<>();
        int i = 0;
        for (String line : lines) {
            for (int j =0; j<lines.size();j++) {
                if (i!=j) {
                    if (ignoreCase){
                        if (line.equalsIgnoreCase(lines.get(j))) {
                            outLines.add(line);
                        }
                    } else {
                        if (line.equals(lines.get(j))) {
                            outLines.add(line);
                        }
                    }
                }
            }
            i++;
        }
        Set<String> s = new LinkedHashSet<>(outLines);
        Files.write(Path.of(outputPath),s);
        if (ignoreCase)
            System.out.println("Util uniq with keys -d, -i is successfully completed");
        else
            System.out.println("Util uniq with key -d is successfully completed");
    }

    static void uniqC(String inputPath, String outputPath, boolean ignoreCase) throws IOException  {
        List<String> lines = Files.readAllLines(Paths.get(inputPath), StandardCharsets.UTF_8);
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            int repeats = 0;
            for (int j =0; j<lines.size();j++) {
                if (ignoreCase) {
                    if (line.equalsIgnoreCase(lines.get(j))) {
                        repeats++;
                    }
                } else {
                    if (line.equals(lines.get(j))) {
                        repeats++;
                    }
                }
                hashMap.put(line, repeats);
            }
        }
        for (String line : lines) {
            stringBuilder.append(hashMap.get(line)).append(" ").append(line).append("\n");
        }
        Files.write(Path.of(outputPath), Collections.singleton(stringBuilder));
        if (ignoreCase)
            System.out.println("Util uniq with keys -c, -i is successfully completed");
        else
            System.out.println("Util uniq with key -c is successfully completed");
    }

    static void uniqC(List<String> lines, String outputPath, boolean ignoreCase) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            int repeats = 0;
            for (int j =0; j<lines.size();j++) {
                if (ignoreCase) {
                    if (line.equalsIgnoreCase(lines.get(j))) {
                        repeats++;
                    }
                } else {
                    if (line.equals(lines.get(j))) {
                        repeats++;
                    }
                }
                hashMap.put(line, repeats);
            }
        }
        for (String line : lines) {
            stringBuilder.append(hashMap.get(line)).append(" ").append(line).append("\n");
        }
        Files.write(Path.of(outputPath), Collections.singleton(stringBuilder));
        if (ignoreCase)
            System.out.println("Util uniq with keys -c, -i is successfully completed");
        else
            System.out.println("Util uniq with key -c is successfully completed");
    }
}
