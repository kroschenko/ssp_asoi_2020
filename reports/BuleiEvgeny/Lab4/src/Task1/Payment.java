import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Payment {

    private int money;
    private ArrayList<Product> products; //= new ArrayList<Product>();

    public Payment(int money){
        this.money = money;
        this.products = new ArrayList<>();
    }

    private void addInListProduct(Product product){
        this.products.add(product);
    }

    public void listProducts() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter counts products :");
        String num = bufferedReader.readLine();
        int number = Integer.parseInt(num);
        for(int i = 0; i<number;i++){
            String Name,Prise,Count;
            System.out.print("Enter name product :");
            String name = bufferedReader.readLine();
            System.out.print("Enter prise product :");
            Prise = bufferedReader.readLine();
            int prise = Integer.parseInt(Prise);
            System.out.print("Enter count product :");
            Count = bufferedReader.readLine();
            int count = Integer.parseInt(Count);
            Product product = new Product(name,prise,count);
            this.addInListProduct(product);
        }
    }

    public void buy(){
        for(Product product : this.products) {
            if (this.money > 0) {
                this.money -= product.priseProduct * product.countProduct;
                System.out.println("Buy " + product.nameProduct + ", count " + product.countProduct);
            } else {
                System.out.println("not money");
                System.out.println("Not buy " + product.nameProduct + ", count " + product.countProduct);
            }
        }
    }

    public int getMoney() {
        return money;
    }

    public void getBalance() {
        System.out.println("Balance : "+this.getMoney());
    }


    public class Product{
        private String nameProduct;
        private int priseProduct;
        private int countProduct;

        public Product(String nameProduct, int priseProduct, int countProduct){
            this.nameProduct = nameProduct;
            this.priseProduct = priseProduct;
            this.countProduct = countProduct;
        }

    }
}
