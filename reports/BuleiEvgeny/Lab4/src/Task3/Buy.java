public class Buy {
    private String nameProduct;
    private double price;

    public Buy(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }
}
