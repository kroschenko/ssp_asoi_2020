public class Klient {
    CreditCard creditCard;
    Adminictrator adminictrator = new Adminictrator();

    public void createCardAndAccount(String nameAccout,double money,String nameCard){
        this.creditCard = new CreditCard(new BankAccount(nameAccout,money),nameCard);
    }

    public void buyProduct(Buy buy) {
        if (creditCard.isStatus() && !creditCard.bankAccount.getName().equals("Delete")) {
            creditCard.buyProduct(buy);
            if (creditCard.bankAccount.getMoney() < 0) adminictrator.blockedCard(creditCard);
            return;
        }
        System.out.println("Card broken or dekete bank account");
    }

    public void blockedCard(){
        System.out.println("Card broken");
        creditCard.blockCard();
    }

    public void cancellation(){
        System.out.println("Delete accaunt");
        creditCard.bankAccount.cancellation();
    }

    public void giftMoney(BankAccount bankAccount, double money) {
        if (creditCard.isStatus() && !creditCard.bankAccount.getName().equals("Delete")) {
            creditCard.gifMoney(bankAccount, money);
            if (creditCard.bankAccount.getMoney() < 0) adminictrator.blockedCard(creditCard);
            return;
        }
        System.out.println("Card broken or dekete bank account");
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public double money(){
        return creditCard.bankAccount.getMoney();
    }

    public BankAccount getBankAccount(){
        return creditCard.bankAccount;
    }
    
}
