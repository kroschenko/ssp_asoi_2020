import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Station {
  private String name;
  private String next;
  private HashMap<String, TreeSet<String>> train_table;

  public Station(String _name, String _next){
      name = _name;
      next = _next;
      train_table = new HashMap<>();
  }
  public void notificate(String current_time) throws ParseException{
    boolean isAnyAnnounce = false;
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    Date current = parser.parse(current_time);
    for(Map.Entry<String, TreeSet<String>> entry : train_table.entrySet()){
      for(String time : entry.getValue()){
        Date date = parser.parse(time);
        if( date.getTime() - current.getTime() <= 180000){
          System.out.println("Train \'" + entry.getKey() + "' departs in less than 3 minutes");
          isAnyAnnounce = true;
          break;
        } else if( date.getTime() - current.getTime() <= 300000){
          System.out.println("Train \'" + entry.getKey() + "' departs in less than 5 minutes");
          isAnyAnnounce = true;
          break;
        }
        if( date.getTime() - current.getTime() <= 600000){
          System.out.println("Train \'" + entry.getKey() + "' departs in less than 10 minutes");
          isAnyAnnounce = true;
          break;
        }
      }
    }
    if(!isAnyAnnounce){
      System.out.println("There are no departures in the next 10 minutes");
    }
  }
  public Vector<String> getTrainsAfter(String afterTime){
    Vector<String> trains = new Vector<>();
    for(Map.Entry<String, TreeSet<String>> entry : train_table.entrySet())
      for(String time : entry.getValue())
        for(int i = 0; i<5; i++)
          if(time.charAt(i) > afterTime.charAt(i)){
            if(!trains.contains(entry.getKey()))
              trains.addElement(entry.getKey());
            break;
          }
    return trains;
  }
  public void addTrain(Train train){
      train_table.put(train.getName(), new TreeSet<String>());
  }
  public void addTime(Train train, String time){
      train_table.get(train.getName()).add(time);
  }
  public void showTimeTable(){
    System.out.println("Station name: \"" + name + "\"\nNext Station: \"" + next + "\"");
    // sortSet();
    for(Map.Entry<String, TreeSet<String>> entry : train_table.entrySet()){
      System.out.println("Train: " + entry.getKey());
      for(String time : entry.getValue()){
        System.out.print(time + " ");
      }
      System.out.println();
    }
  }
  public String getName(){
    return name;
  }
  public Vector<String> getTrains(){
    Vector<String> trains = new Vector<>();
    for(Map.Entry<String, TreeSet<String>> entry : train_table.entrySet()){
      trains.addElement(entry.getKey());
    }
    return trains;
  }
  // private void sortSet(){
  //   for(Map.Entry<String, TreeSet<String>> entry : train_table.entrySet()){
  //     List<String> stringList = new ArrayList<String>(entry.getValue()) ;
  //     Collections.sort(stringList);      
  //     entry.setValue(new LinkedTreeSet<>(stringList)); 
  //   }
  // }
}