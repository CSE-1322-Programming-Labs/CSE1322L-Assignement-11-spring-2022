public class CreditCard {
    private double creditCardBalance;

    //Default constructor sets the account balance to 5000;
    public CreditCard(){
        creditCardBalance = 5000.0;
    }

    public double getBalance(){
        return creditCardBalance;
    }

    //Withdraw a certain amount of money. If there is not enough money to withdraw, an exception will be thrown.
    public void withdraw(double amtToWithdraw){
        creditCardBalance -= amtToWithdraw; //This will be exception handled in the class that uses it, Ideally you also want to exception handle here too. However, since we're catching it in the cardholder, I have omitted it for this example.
    }
}
