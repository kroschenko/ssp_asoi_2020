
import java.io.*;


import static java.lang.Integer.*;

public class Task2 {

    public static void main(String[] args) {

        if (args.length == 0 || !args[0].equals("tail")) {
            System.out.println("unknown command");
            return;
        }

        try {

            if (args[1].equals("-n")) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(args[3], "r");
                int numberLine = parseInt(args[2]);
                readLine(randomAccessFile, numberLine);
                return;
            }

            if (isDigit(args[1])) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(args[2], "r");
                int numberLine = parseInt(args[1]);
                readLine(randomAccessFile,numberLine);
                return;
            } else {
                RandomAccessFile randomAccessFile = new RandomAccessFile(args[1], "r");
                readLineD(randomAccessFile);
                return;
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }


    public static boolean isDigit(String str) {
        try {
            parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int lengFile(RandomAccessFile randomAccessFile) throws IOException {
        int count = 0;
        String line = randomAccessFile.readLine();
        while (line != null) {
            count++;
            line = randomAccessFile.readLine();
        }
        randomAccessFile.seek(0);
       return count;
    }

    public static void readLineD(RandomAccessFile randomAccessFile) {
        try {
            String line = randomAccessFile.readLine();
            int num = -1, leng = lengFile(randomAccessFile);
            while (line != null) {
                if (num > leng - 10) System.out.println(line);
                num++;
                line = randomAccessFile.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLine (RandomAccessFile randomAccessFile, int count) {
        try {
            String line = randomAccessFile.readLine();
            int num = -1, leng = lengFile(randomAccessFile);
            while (line != null) {
                if (num > leng - count) System.out.println(line);
                num++;
                line = randomAccessFile.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
