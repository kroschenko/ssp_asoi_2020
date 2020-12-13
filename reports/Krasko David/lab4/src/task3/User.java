  import java.util.*;

  public class User<T>{
    public abstract class Service{
      private int type;
      private double price;
      private String name;

      public Service(){
      }

      public Service(String _name, int _type, double _price){
        name = _name;
        type = _type;
        price = _price;
      }
      public double getPrice(){
        return price;
      }

      public int getType(){
        return type;
      }

      public String getName(){
        return name;
      }
    }
    public class ExtraService extends Service{
      public ExtraService(String _name, double _price){
        super.Service(_name, 2, _price);
      }
    }
    public class Calls extends Service{
      public Calls(String _name){
        super.Service(_name, 2, 10.0);
      }
    }
    private T someMeta;
    private boolean isAdmin;
    private boolean isActive;
    private double vallet;
    private String number;
    private Vector<Service> services;

    public User(String _number, boolean _isAdmin){
      number = _number;
      isAdmin = _isAdmin;
      vallet = 0;
      isActive = true;
      services = new Vector<>();
      if(!isAdmin)
        services.add(new Calls("Calls"));
    }
    public void setMeta(T value){
      someMeta = value;
    }
    public T getMeta(){
      return someMeta;
    }
    public void changeNumber(String newNumber){
      number = newNumber;
    }
    public boolean isAdmin(){
      return isAdmin;
    }
    public boolean isActive(){
      return isActive;
    }
    public void setActive(boolean active){
      isActive = active;
    }
    public String getNumber(){
      return number;
    }
    public void addVallet(double value){
      vallet += value;
      if(!isActive && vallet > 0)
        isActive = true;
    }
    public void addService(String name, double price){
      services.add(new ExtraService(name, price));
    }
    public double getAmount(){
      double total = 0;
      for(Service s : services){
        total += s.getPrice();
      }
      return total;
    }

    public void print(){
      System.out.println(
        (isAdmin ? "Administrator. " : "Abonent. ") +
        "Number: " + number);
        if(!isAdmin){
          String serv=  "Services: \n";
          for(Service s : services)
                serv+= s.getName() + "("+s.getPrice()+")\n";
          System.out.print(serv);
          System.out.println("Vallet: " + vallet);
        }
        System.out.println(isActive ? "Active\n" : "Deactivated\n");
    }
    public void deleteService(String name){
      for(int i = 0; i<services.size(); i++){
        if(services.elementAt(i).getName().equals(name)){
          services.remove(i);
          return;
        }
      }
      System.out.println("Service not found\n");
    }
    
}