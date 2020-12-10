import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.ParseException;

public class Manager{
  private Vector<Station> stations;
  private Vector<Train> trains;

  public Manager(){
    stations = new Vector<>();
    trains = new Vector<>();
  }

  public void loadFromJson(String path){
    String str = "";
    try{
      FileReader r = new FileReader(path);
      BufferedReader reader = new BufferedReader(r);
      String temp = reader.readLine();
      while(temp != null){
        str += temp;
        temp = reader.readLine();
      }
      Gson gson = new Gson();
      Manager m = gson.fromJson(str, Manager.class);
      stations = m.stations;
      trains = m.trains;
    }
    catch (FileNotFoundException ex){
         System.out.println(ex);
    }
    catch (IOException ex){
        System.out.println(ex);
    }
  }

  public void addStation(Station st){
    if(!stations.contains(st)){
      stations.addElement(st);
      System.out.println("Station successfully added.");
    } else {
      System.out.println("Station exists in manager.");
    }
  }

  public void showTimeTable(){
    System.out.println();
    System.out.println("Timetable");
    for(Station st : stations){
      st.showTimeTable();
      System.out.println();
    }
  }

  public Vector<Train> getTrains(){
    return trains;
  }

  public void showTrainsInfo(String station){
    System.out.println();
    System.out.println("Train's info on station \'" + station + "\'");
    for(Station st : stations){
      if(st.getName().equals(station)){
        Vector<String> t = st.getTrains();
        if(t.size() < 1){
          System.out.println("No trains info on this station");
          return;
        }
        for(Train train : trains){
          if(t.contains(train.getName())){
            System.out.println("Train name: \'" + train.getName() + "'. Capacity: " + train.getCapacity());
          }
        }
        return;
      }
    }
    System.out.println("Station not found");
  }

  public void showTrainsInfAfterTime(String fromStation, String toStation, String afterTime){
    if(fromStation.equals(toStation)){
      System.out.println("Wron input parametrs");
      return;
    }
    Station firstStation = stations.elementAt(0), secondStation = stations.elementAt(0);
    for(Station st : stations){
      if(st.getName().equals(fromStation)){
        firstStation = st;
      }
      if(st.getName().equals(toStation)){
        secondStation = st;
      }
    }
    Vector<String> first_trains = firstStation.getTrainsAfter(afterTime);
    Vector<String> second_trains = secondStation.getTrainsAfter(afterTime);

    System.out.println();
    System.out.println("Trains leaving after " + afterTime + " from \'" + fromStation + "\' to \'" + toStation + "\'");
    for(String train : first_trains){
      if(second_trains.contains(train)){
        System.out.println(train + " ");
      }
    }
  }
  public void notificate(String station, String current_time){
    System.out.println();
    System.out.println("Notification");
    for(Station st : stations){
      if(st.getName().equals(station)){
        try{
          st.notificate(current_time);
        } catch(ParseException ex){
          
        }
      }
    }
  }
  public void showCapacitiesTo(String station){
    int cap = 0;
    for(Station st : stations){
      if(st.getName().equals(station)){
        Vector<String> trs = st.getTrains();
        for(Train train : trains){
          if(trs.contains(train.getName())){
            cap += train.getCapacity();
          }
        }
      }
    }
    System.out.println();
    System.out.println("Summed train\'s capacity on \'" + station + "\' is " +  cap);
  }
}