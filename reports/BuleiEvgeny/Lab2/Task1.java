import java.io.*;

public class Task1 {
    public static void main(String[] args){
        try {
            File file = new File("text.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null){
                line = line.replaceAll("[^a-zA-Z]|\\s"," ");
                String[] words = line.split(" ");
                for(int i = words.length-1;i>-1;i--)
                    System.out.print(words[i]+" ");
                System.out.println();
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
