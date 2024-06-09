public class CardPayment implements Payment{

    Card card;
    public CardPayment(Card card){
        this.card = card;
    }
    @Override
    public boolean pay(int payment) {
        int cardMoney = card.getMoney();
        if(cardMoney<payment){
            System.out.println("You don't have sufficient payment to pay bill");
            System.out.println();
            return false;
        }

        card.setMoney(cardMoney-payment);
        System.out.println("Payment succeeded!");
        System.out.println();
        return true;
    }
    
}
