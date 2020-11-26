public class task1 {

    public static void main(String[] args) {
        int [] N = new int[args.length];
        int s1=0, s2=0, s3=0, s4=0, s5=0, s6=0, smore=0;
        System.out.print("Input array: ");
        for(int i=0; i<args.length; i++) {
            N[i] = Integer.parseInt(args[i]);
            System.out.print(args[i] + "; ");
        }
        for (int i=0; i<N.length; i++) {
            if(N[i]>0 && N[i]<10) s1++;
            if(N[i]>9 && N[i]<100) s2++;
            if(N[i]>99 && N[i]<1000) s3++;
            if(N[i] > 999 && N[i] < 10000) s4++;
            if(N[i] > 9999 && N[i] < 100000) s5++;
            if(N[i] > 99999 && N[i] < 1000000) s6++;
            if(N[i] > 999999) smore++;
        }
        System.out.println(" ");
        System.out.println("Sum of one-digit numbers: " + s1);
        System.out.println("Sum of two-digit numbers: " + s2);
        System.out.println("Sum of three-digit numbers: " + s3);
        System.out.println("Sum of four-digit numbers: " + s4);
        System.out.println("Sum of five-digit numbers: " + s5);
        System.out.println("Sum of six-digit numbers: " + s6);
        System.out.println("Sum of more than six-digit numbers: " + smore);
    }
}