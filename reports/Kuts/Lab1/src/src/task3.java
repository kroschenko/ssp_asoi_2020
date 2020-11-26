public class task3 {

    public static void main(String[] args) {
        String str1 = args[0], str2 = args[1];
        String res = xor(str1, str2);
        System.out.println("First string:     " + str1);
        System.out.println("Second string:    " + str2);
        System.out.println("Operation result: " + res);
    }

    static String xor(String str1, String str2) {
        String res = "";
        char buf1, buf2;
        int length = Math.max(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            buf1 = str1.charAt(i);
            buf2 = str2.charAt(i);
            if (buf1 != buf2) res += 1;
            else res += 0;
        }
        return res;
    }
}
