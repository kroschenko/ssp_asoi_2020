import java.util.*;

class Mobile {

    static class MobileSpec {

        private final int id, RAM, ROM, price;
        private final String manufacturer, name;

        public MobileSpec(int id, String manufacturer, String name, int RAM, int ROM, int price) {
            this.id = id;
            this.manufacturer = manufacturer;
            this.name = name;
            this.RAM = RAM;
            this.ROM = ROM;
            this.price = price;
        }

        public int getId() { return id; }

        public String getManufacturer() { return manufacturer; }

        public int getRAM() { return RAM; }

        public int getROM() { return ROM; }

        public int getPrice() { return price; }

        public void printElement() {
            System.out.println("\nПроизводитель: " + manufacturer + "\nНаименование: " + name
                    + "\nОбъем оперативной памяти (ГБ): " + RAM + "\nОбъем встроенной памяти (ГБ): " + ROM
                    + "\nСтоимость (руб): " + price);
        }
    }

    private final ArrayList<MobileSpec> phoneList = new ArrayList<>();

    public Mobile() {
        phoneList.add(new MobileSpec(1,"Nokia","2.3", 2, 32, 299));
        phoneList.add(new MobileSpec(2,"Apple","iPhone 11", 4, 128, 2499));
        phoneList.add(new MobileSpec(3,"Samsung","Galaxy J7", 3, 16, 449));
        phoneList.add(new MobileSpec(4,"Xiaomi","Mi 10 Ultra", 8, 256, 3150));
        phoneList.add(new MobileSpec(5,"Redmi","Note 9 Pro", 6, 64, 650));
    }

    public void printMobileList() { for (MobileSpec mobileSpec : phoneList) mobileSpec.printElement(); }

    private final Map<Integer, Integer> RAMMap = new HashMap<>();
    private final Map<Integer, Integer> ROMMap = new HashMap<>();
    private final Map<Integer, Integer> priceMap = new HashMap<>();
    private final Map<String, Integer> manufacturerMap = new HashMap<>();

    public void sortMobileList() {

        System.out.println("\n1 - по производителю в алфавитном порядке");
        System.out.println("2 - по возрастанию оперативной памяти");
        System.out.println("3 - по возрастанию встроенной памяти");
        System.out.println("4 - по возрастанию стоимости\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите, чтобы продолжить: ");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1 -> {
                for (MobileSpec spec : phoneList) manufacturerMap.put(spec.getManufacturer(), spec.getId());
                Map<String, Integer> sortManufacturer = new TreeMap<>(manufacturerMap);
                for (Map.Entry<String, Integer> entry : sortManufacturer.entrySet())
                    for (MobileSpec spec : phoneList)
                        if (entry.getValue() == spec.getId()) spec.printElement();
            }
            case 2 -> {
                for (MobileSpec spec : phoneList) RAMMap.put(spec.getRAM(), spec.getId());
                Map<Integer, Integer> sortRAM = new TreeMap<>(RAMMap);
                for (Map.Entry<Integer, Integer> entry : sortRAM.entrySet())
                    for (MobileSpec spec : phoneList)
                        if (entry.getValue() == spec.getId()) spec.printElement();
            }
            case 3 -> {
                for (MobileSpec spec : phoneList) ROMMap.put(spec.getROM(), spec.getId());
                Map<Integer, Integer> sortROM = new TreeMap<>(ROMMap);
                for (Map.Entry<Integer, Integer> entry : sortROM.entrySet())
                    for (MobileSpec spec : phoneList)
                        if (entry.getValue() == spec.getId()) spec.printElement();
            }
            case 4 -> {
                for (MobileSpec spec : phoneList) priceMap.put(spec.getPrice(), spec.getId());
                Map<Integer, Integer> sortPrice = new TreeMap<>(priceMap);
                for (Map.Entry<Integer, Integer> entry : sortPrice.entrySet())
                    for (MobileSpec spec : phoneList)
                        if (entry.getValue() == spec.getId()) spec.printElement();
            }
        }
    }
}

public class task1 {

    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        System.out.println("1 - Список устройств");
        System.out.println("2 - Сортировка\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите, чтобы продолжить: ");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1: mobile.printMobileList(); break;
            case 2: mobile.sortMobileList(); break;
            default: break;
        }
    }
}