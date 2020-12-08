public class Main {
    public static void main(String[] args){
        Buy buy = new Buy("Gold",500);
        Klient klient = new Klient();
        klient.createCardAndAccount("AAAAAAAAAA",800,"vix");
        Klient klient1 = new Klient();
        klient1.createCardAndAccount("BBBBBBBB",1000,"zek");
        klient.buyProduct(buy);
        System.out.println("Money - "+klient.money());
        klient.giftMoney(klient1.getBankAccount(),400);
        System.out.println("Money klient - "+klient.money());
        System.out.println("Money klient1 - "+klient1.money());

        klient1.blockedCard();
        klient1.cancellation();
    }
}
