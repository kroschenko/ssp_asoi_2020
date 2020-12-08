import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Line{

    private String line;

    public Line() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            line = bufferedReader.readLine();
            if(!(line.endsWith("!") || line.endsWith(".") || line.endsWith("?"))){
                StringBuilder stringBuilder = new StringBuilder(line);
                stringBuilder.insert(line.length(),".");
                line = stringBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int length(){
        return line.length();
    }

    public boolean isEmpty(){
        return line.isEmpty();
    }

    public void print(){
        System.out.print(line);
    }
}
