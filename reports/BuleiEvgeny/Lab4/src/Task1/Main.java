import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Payment payment = new Payment(1000);
        payment.listProducts();
        payment.buy();
        payment.getBalance();
    }
}
