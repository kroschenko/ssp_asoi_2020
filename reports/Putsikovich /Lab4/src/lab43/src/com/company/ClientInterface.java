package com.company;

public interface ClientInterface {

    void payOrder(boolean isCard);
    void paymentToOtherAccount(Account otherAccount, double sum, boolean isCard);
    void cancelAccount();
    void blockCard();
    void show();

}
