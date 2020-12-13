class Main {
  public static void main(String[] args) {
    Disk disk = new Disk();
    disk.createCatalog("first cat");
    disk.createCatalog("second cat");
    disk.createRecord("a.mp3");
    disk.showDiskFiles();
    
    System.out.println();
    disk.root.getCatalogs().elementAt(0).createCatalog("included in first cat");
    disk.root.getCatalogs().elementAt(0).createRecord("included in first cat record.mp3");
    disk.root.getCatalogs().elementAt(0).showCatalog();
  }
}
/*
Реализовать указанный класс, включив в него вспомогательный внутренний класс или классы. Реализовать 2-3 метода (на выбор). Продемонстрировать использование реализованных классов. 

Создать класс CD (mp3-диск) с внутренним классом, с помощью объектов которого можно хранить информацию о каталогах, подкаталогах и записях.
*/