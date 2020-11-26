public class task2 {

    public static void main(String[] args) {
        double[] array = new double[args.length];
        System.out.print("Input string: ");
        for (int i = 0; i < args.length; i++) {
            array[i] = Double.parseDouble(args[i]);
            System.out.print(args[i] + "; ");
        }
        System.out.println("");
        System.out.print("Shift string: ");
        shiftLeft(array, 5);
    }

    static void shiftLeft(double[] array, int shift) {
        double[] arrayShifted = new double[array.length];
        for(int i = 0; i < array.length; i++) {
            if (i+shift >= array.length) {
                int remainder = (i+shift) % array.length;
                arrayShifted[i] = array[remainder];
            }
            else arrayShifted[i] = array[i+shift];
        }
        for (int i = 0; i < arrayShifted.length; i++) {
            double result = arrayShifted[i];
            System.out.print(result + "; ");
        }
    }
}