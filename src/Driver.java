public class Driver {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
        CardHolder cardHolder = new CardHolder(creditCard);

        Thread John = new Thread(cardHolder, "John"); //Both of these people share 1 credit card and will try to use it together.
        Thread Mary = new Thread(cardHolder,"Mary");

        John.start();
        Mary.start();

    }
}
