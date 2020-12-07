import java.util.ArrayList;

class Set {

    private final int power = 0;
    private final ArrayList<Double> numbers;

    public Set() { numbers = new ArrayList<>(); }

    public int getPower() { return power; }

    public boolean existCheck(double element) { return numbers.contains(element); }

    public void add(double element) { numbers.add(element); }

    public void remove(double element) { numbers.remove(element); }

    public void removeAll() { numbers.removeAll(numbers); }

    public ArrayList intersection(Set set) {
        ArrayList<Double> crossedNumbers = new ArrayList<>();
        for (double element: numbers) if(set.numbers.contains(element)) crossedNumbers.add(element);
        return crossedNumbers;
    }

    public void print() {
        for (double element: numbers) System.out.print(element + "; ");
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (double element: numbers) {
            str.append(element);
            str.append("; ");
        }
        return str.toString();
    }

    public boolean equals(Set set) {
        if(set.getPower() != power) return false;
        for (double element: numbers) if (!set.existCheck(element)) return false;
        return true;
    }
}

public class task1 {

    public static void main(String[] args) {
        Set set1 = new Set();
        for(int i = 0; i < 5 ; i++) {
            double random = Math.random()*100;
            set1.add(random);
        }
        Set set2 = new Set();
        for(int i = 0; i < 5 ; i++) {
            double random = Math.random()*100;
            set2.add(random);
        }

        System.out.println("Set 1 to string: " + set1.toString());
        System.out.println("Set 2 to string: " + set2.toString());

        set1.add(55.55);
        set2.add(55.55);
        System.out.println("\nElement 55.55 added to Set 1 and Set 2.");
        System.out.print("Set 1 after adding: ");
        set1.print();
        System.out.print("\nSet 2 after adding: ");
        set2.print();
        ArrayList<Double> crossedNumbers = set2.intersection(set1);
        System.out.print("\nIntersection check. Result of intersection: ");
        for (double element: crossedNumbers) System.out.print(element + "; ");

        set1.remove(55.55);
        System.out.print("\n\nElement 55.55 removed.\nSet 1 after removal: ");
        set1.print();

        System.out.println("\n\nSet 1 contain check of 99.99: " + set1.existCheck(99.99));
        set1.add(99.99);
        System.out.print("Element 99.99 added.\nSet1 after adding: ");
        set1.print();
        System.out.println("\nSet 1 contain check of 99.99: " + set1.existCheck(99.99));

        System.out.println("\nSet 1 equal check to Set 2: " + set1.equals(set2));
        set1.removeAll();
        set2.removeAll();
        System.out.println("All elements removed from Set 1 and Set 2.");
        set1.add(25.25);
        set2.add(25.25);
        System.out.println("Element 25.25 added to Set 1 and Set 2.");
        System.out.print("Set 1 after adding: ");
        set1.print();
        System.out.print("\nSet 2 after adding: ");
        set2.print();
        System.out.println("\nSet 1 equal check to Set 2: " + set1.equals(set2));
    }
}