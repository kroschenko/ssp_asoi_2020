

public class Main {
    public static void main(String[] args) {
        double[] array = convertArray(args);
        double rmax, n = 10;
        String s;
        double[] b = new double[100];
        System.out.println("Входные значения: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        for (int i = 0; i < array.length; i++) {
            b[(int) array[i]]++;
        }
        rmax = b[0];
        int I = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] > rmax) {
                rmax = b[i];
                I = i;
            }
        }
        System.out.println(" ");
        System.out.println("Элемент: " + I + " Встречается наибольшее количество раз: " + rmax);
        double[] arr1;
        arr1 = shiftRigth(array,4);
        System.out.println("Смещение на n-раз");
        for(int j=0;j<arr1.length;j++){
            System.out.print(arr1[j]+" ");
        }

    }

    public static double[] convertArray(String[] stringArray) {
        double[] result = new double[stringArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(stringArray[i]);
        }
        return result;
    }

    static int getIndex(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return getIndex(b, a % b);
    }

    public static double[] shiftRigth(double[] arrayOf, int shift) {
        int currentIndex, movedIndex;
        double buffer;
        for (int i = 0; i < getIndex(shift, arrayOf.length); i++) {
            buffer = arrayOf[i];

            currentIndex = i;

            if(shift > 0){
                while (true) {
                    movedIndex = currentIndex + shift;
                    if (movedIndex >= arrayOf.length)
                        movedIndex = movedIndex - arrayOf.length;
                    if (movedIndex == i)
                        break;
                    arrayOf[currentIndex] = arrayOf[movedIndex];
                    currentIndex = movedIndex;
                }
            }
            arrayOf[currentIndex] = buffer;
        }

        return arrayOf;
    }

}
