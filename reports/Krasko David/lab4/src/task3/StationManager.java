import java.util.*;

public class StationManager{

  private Vector<User> users;

  public StationManager(){
    users = new Vector<>();
  }

  public void changeNumber(User user, User target, String newNumber){
    if(checkPerm(user))
      target.changeNumber(newNumber);
  }
  public void addService(User user, User target, String name, double price){
    if(checkPerm(user))
      target.addService(name, price);
  }
  public void deleteService(User user, User target, String name){
    if(checkPerm(user))
      target.deleteService(name);
  }
  public void deactiveUser(User user, User target){
    if(checkPerm(user))
      target.setActive(false);
  }
  private boolean checkPerm(User user){
    if(user.isAdmin()){
      return true;
    } else {
      System.out.println("You dont have permissions. Please contact your administrator\n");
      return false;
    }
  }

  public void printAmount(User user){
    System.out.println("\'" + user.getNumber() + "\' : " + user.getAmount());
  }

  public void pay(User user, double value){
    user.addVallet(value);
  }
  public void addUser(User user){
    users.addElement(user);
  }
  public void print(User user){
    for(User u : users){
      if(u.equals(user)){
        u.print();
      }
    }
  }
}