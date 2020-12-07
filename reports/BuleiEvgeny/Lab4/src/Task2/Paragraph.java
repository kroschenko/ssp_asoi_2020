import java.util.ArrayList;

public class Paragraph {
    ArrayList<Line> paragraph;

    public Paragraph(){
        paragraph = new ArrayList<>();
    }

    public void addLine(){
        Line line = new Line();
        paragraph.add(line);
    }

    public void print(){
        for(Line line : paragraph){
            line.print();
        }
        System.out.println("");
    }

    public void addCountLine(int count){
        for(int i = 0; i<count; i++){
            this.addLine();
        }

    }
}
