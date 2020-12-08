import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task2 {

        public static void main(String[] args) throws IOException {
            List<String> firstFile = Files.readAllLines(Paths.get("f1.txt"), Charset.defaultCharset()),
                    secondFile = Files.readAllLines(Paths.get("f2.txt"), Charset.defaultCharset());

            FileWriter writer = new FileWriter("f3.txt");

            int firstField = Integer.parseInt(args[1]), secondField = Integer.parseInt(args[2]),
                    length = firstFile.size(), length1 = 0, length2 = 0;

            String field1, field2;

            int index1, index2;

            char[] st1_11 = new char[10], st1_12 = new char[10], st1_21 = new char[10], st1_22 = new char[10],
                    st2_11 = new char[10], st2_12 = new char[10], st2_21 = new char[10], st2_22 = new char[10],
                    st3_11 = new char[10], st3_12 = new char[10], st3_21 = new char[10], st3_22 = new char[10],
                    st4_11 = new char[10], st4_12 = new char[10], st4_21 = new char[10], st4_22 = new char[10];

            for (String str : args) System.out.print(str + " ");
            System.out.println("");

            if (firstField == 1 && secondField == 1) {
                for (int i = 0; i < length; i++) {
                    field1 = firstFile.get(i);
                    field2 = secondFile.get(i);
                    length1 = field1.length();
                    length2 = field2.length();
                    index1 = field1.indexOf(' ');
                    index2 = field2.indexOf(' ');
                    field1.getChars(0, index1, st1_11, 0);
                    field2.getChars(0, index2, st1_21, 0);
                    field1.getChars(index1, length1, st1_12, 0);
                    field2.getChars(index2, length2, st1_22, 0);
                    if (Arrays.equals(st1_11, st1_21)) {
                        System.out.print(st1_11);
                        System.out.print(" ");
                        System.out.print(st1_12);
                        System.out.print(" ");
                        System.out.print(st1_22);
                        writer.write(st1_11);
                        writer.write(st1_12);
                        writer.write(st1_22);
                        writer.write("\n");
                    }
                }
            }

            if (firstField == 1 && secondField == 2) {
                for (int i = 0; i < length; i++) {
                    field1 = firstFile.get(i);
                    field2 = secondFile.get(i);
                    length1 = field1.length();
                    length2 = field2.length();
                    index1 = field1.indexOf(' ');
                    index2 = field2.indexOf(' ');
                    field1.getChars(0, index1, st2_11, 0);
                    field2.getChars(0, index2, st2_21, 0);
                    field1.getChars(index1 + 1, length1, st2_12, 0);
                    field2.getChars(index2 + 1, length2, st2_22, 0);
                    if (Arrays.equals(st2_11, st2_22)) {
                        System.out.print(st2_11);
                        System.out.print(" ");
                        System.out.print(st2_12);
                        System.out.print(" ");
                        System.out.print(st2_21);
                        writer.write(st2_11);
                        writer.write(st2_12);
                        writer.write(st2_22);
                        writer.write("\n");
                    }
                }
            }

            if (firstField == 2 && secondField == 1) {
                for (int i = 0; i < length; i++) {
                    field1 = firstFile.get(i);
                    field2 = secondFile.get(i);
                    length1 = field1.length();
                    length2 = field2.length();
                    index1 = field1.indexOf(' ');
                    index2 = field2.indexOf(' ');
                    field1.getChars(0, index1, st3_11, 0);
                    field2.getChars(0, index2, st3_21, 0);
                    field1.getChars(index1 + 1, length1, st3_12, 0);
                    field2.getChars(index2, length2, st3_22, 0);
                    if (Arrays.equals(st3_12, st3_21)) {
                        System.out.print(st3_12);
                        System.out.print(" ");
                        System.out.print(st3_11);
                        System.out.print(" ");
                        System.out.print(st3_22);
                        writer.write(st3_12);
                        writer.write(st3_11);
                        writer.write(st3_22);
                        writer.write("\n");
                    }
                }
            }

            if (firstField == 2 && secondField == 2) {
                for (int i = 0; i < length; i++) {
                    field1 = firstFile.get(i);
                    field2 = secondFile.get(i);
                    length1 = field1.length();
                    length2 = field2.length();
                    index1 = field1.indexOf(' ');
                    index2 = field2.indexOf(' ');
                    field1.getChars(0, index1, st4_11, 0);
                    field2.getChars(0, index2, st4_21, 0);
                    field1.getChars(index1 + 1, length1, st4_12, 0);
                    field2.getChars(index2 + 1, length2, st4_22, 0);
                    if (Arrays.equals(st4_12, st4_22)) {
                        System.out.print(st4_12);
                        System.out.print(" ");
                        System.out.print(st4_11);
                        System.out.print(" ");
                        System.out.print(st4_21);
                        writer.write(st4_12);
                        writer.write(st4_11);
                        writer.write(st4_21);
                        writer.write("\n");
                    }
                }
            }

            writer.close();

            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            System.out.println(s);
        }
    }