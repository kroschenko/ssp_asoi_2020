import java.util.*;

public class Disk{
  public class Catalog{
    public class Record{
      private String name;
      private Byte[] data;

      public Record(String name){
        this.name = name;
      }

      public String getName(){
        return name;
      }
      public Byte[] getData(){
        return data;
      }      
    }

    public Catalog(String name){
      this.name = name;
      catalogs = new Vector<>();
      records = new Vector<>();
    }

    public Vector<Catalog> getCatalogs(){
      return catalogs;
    }
    public Vector<Record> getRecords(){
      return records;
    }
    public void deleteCatalog(String name){
      for(int i = 0; i<catalogs.size(); i++){
        if(catalogs.elementAt(i).getName().equals(name)){
          catalogs.remove(i);
          break;
        }
      }
    }
    public void createCatalog(String name){
      for(int i = 0; i<catalogs.size(); i++){
        if(catalogs.elementAt(i).getName().equals(name)){
          return;
        }
      }
      catalogs.addElement(new Catalog(name));
    }
    public void createRecord(String name){
      for(int i = 0; i<records.size(); i++){
        if(records.elementAt(i).getName().equals(name)){
          return;
        }
      }
      records.addElement(new Record(name));
    }
    public String getName(){
      return name;
    }
    public void showCatalog(){
      System.out.println("\'" + name + "\' includes:");
      System.out.println("Catalogs:");
      for(Catalog c : catalogs){
        System.out.println(c.getName());
      }
      System.out.println("Records:");
      for(Record r : records){
        System.out.println(r.getName());
      }
    }

    private Vector<Catalog> catalogs;
    private Vector<Record> records;
    private String name;
  }

  public Disk(){
    root = new Catalog("root");
  }

  public void createCatalog(String name){
    root.createCatalog(name);
  }
  public void createRecord(String name){
    root.createRecord(name);
  }
  public void showDiskFiles(){
    root.showCatalog();
  }

  public Catalog root;
}