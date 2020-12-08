public class BankAccount{
    private String name;
    private double money;
    private boolean status = true;

    public BankAccount(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void cancellation(){
        this.money = 0;
        this.name = "Delete";
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isStatus() {
        return status;
    }
}
