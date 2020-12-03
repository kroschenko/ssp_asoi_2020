package com.company;

public class Client extends People implements ClientInterface {
    private Account account;
    private Card card;
    private Order order=null;

    public Client(int id, String fio, Account account, Card card) {
        super(id, fio);
        this.account = account;
        this.card = card;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void payOrder(boolean isCard){
        if(isCard){
            card.setDept(card.getDept()+order.getSum());
        }
        else{
            if(account.isCanceled()||account.getMoneyCount()<order.getSum())
                return;

            account.setMoneyCount(account.getMoneyCount()-order.getSum());
        }

        order.setPayed(true);
    }

    public void paymentToOtherAccount(Account otherAccount, double sum, boolean isCard) {
        if(isCard){
            card.setDept(card.getDept()+sum);
        }
        else{
            if(account.isCanceled()||account.getMoneyCount()<sum)
                return;

            account.setMoneyCount(account.getMoneyCount()-sum);
        }

        otherAccount.setMoneyCount(otherAccount.getMoneyCount()+sum);
    }

    public void cancelAccount(){
        account.setCanceled(true);
    }

    public void blockCard(){
        card.setBlocked(true);
    }

    public void show(){
        System.out.println("Клиент: "+id+"; фио: "+fio+";");
        System.out.println("Счёт: "+account.getId()+"; баланс: "+account.getMoneyCount()+"; аннулирован: "+account.isCanceled());
        System.out.println("Карта: "+card.getId()+"; кредит: "+card.getDept()+"; макс.кредит: "+card.getMaxDept()+"; заблокирована: "+card.isBlocked());

        if(order==null)
            System.out.println("Заказов нет.");
        else
            System.out.println("Заказ: "+order.getId()+"; получатель: "+order.getReceiver()+"; сумма: "+order.getSum()+"; оплачен: "+order.isPayed());
    }
}
