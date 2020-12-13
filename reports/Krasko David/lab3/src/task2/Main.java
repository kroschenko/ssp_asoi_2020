
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    Manager manager = new Manager();
    manager.loadFromJson("Manager.json");
    manager.showTrainsInfo("First Station");
    manager.showTrainsInfAfterTime("Third Station", "Fifth Station", "05:00");    
    manager.notificate("Second Station", "05:00");
    manager.showCapacitiesTo("Fourth Station");
    manager.showTimeTable();
  }
}