public class Train {
  private int capacity;
  private String name;

  public Train(String _name, int _capacity){
    name = _name;
    capacity = _capacity;
  }
  public String getName(){
    return name;
  }
  public int getCapacity(){
    return capacity;
  }
}