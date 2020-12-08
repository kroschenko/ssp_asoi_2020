import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class task1 {
    public static String[] ReadWrite(String str, BufferedReader bufReader, FileReader fileReader,
                                     ArrayList<String> arList, String[] string) throws IOException {
        bufReader = new BufferedReader(fileReader);
        arList = new ArrayList<>();

        while((str = bufReader.readLine()) != null ) {
            if (!str.isEmpty()) arList.add(str);
        }

        string = arList.toArray(new String[0]);
        return string;
    }

    public static void main(String[] args) throws IOException {
        FileReader nounReader = new FileReader("noun.txt"),
                verbReader = new FileReader("verb.txt"),
                prepReader = new FileReader("preposition.txt"),
                adjReader = new FileReader("adjective.txt");

        BufferedReader bufNounReader = new BufferedReader(nounReader),
                bufVerbReader = new BufferedReader(verbReader),
                bufPrepReader = new BufferedReader(prepReader),
                bufAdjReader = new BufferedReader(adjReader);

        ArrayList<String> nounList = new ArrayList<>(),
                verbList = new ArrayList<>(),
                prepList = new ArrayList<>(),
                adjList = new ArrayList<>();

        String nounStr = "", verbStr = "", prepStr = "", adjStr = "";

        String[] nouns = new String[0],
                verbs = new String[0],
                prepositions = new String[0],
                adjectives = new String[0];

        String [] noun = ReadWrite(nounStr, bufNounReader, nounReader, nounList, nouns),
                verb = ReadWrite(verbStr, bufVerbReader, verbReader, verbList, verbs),
                preposition = ReadWrite(prepStr, bufPrepReader, prepReader, prepList, prepositions),
                adjective = ReadWrite(adjStr, bufAdjReader, adjReader, adjList, adjectives);

        for (int i=0; i<20; i++) {
            int num1 = (int) (Math.random()*10),
            num2 = (int) (Math.random()*10),
            num3 = (int) (Math.random()*10),
            num4 = (int) (Math.random()*10),
            num5 = (int) (10 + Math.random()*10);

            System.out.println(noun[num1] + " "
                    + verb[num2]+ " "
                    + preposition[num3] + " "
                    + adjective[num4]+ " "
                    + noun[num5]+ ".");
        }
    }
}