public class CreditCard{
    private String nameCard;
    private boolean status;
    BankAccount bankAccount;

    public CreditCard(BankAccount bankAccount, String nameCard) {
        this.bankAccount = bankAccount;
        this.nameCard = nameCard;
        this.status = true;
    }

    public void blockCard(){
        this.status = false;
    }

   public void gifMoney(BankAccount bankAccount, double money){
        if(bankAccount.isStatus()) {
            bankAccount.setMoney(bankAccount.getMoney() + money);
            this.bankAccount.setMoney(this.bankAccount.getMoney() - money);
            return;
        }
        System.out.println("Account delete");
    }

    public void buyProduct(Buy buy){
        if(bankAccount.isStatus()) {
            System.out.println("Buy product "+buy.getNameProduct());
            this.bankAccount.setMoney(this.bankAccount.getMoney()-buy.getPrice());
            return;
        }
        System.out.println("Account delete");
    }

    public boolean isStatus() {
        return status;
    }


}
