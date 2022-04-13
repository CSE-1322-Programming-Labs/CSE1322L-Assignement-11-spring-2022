import java.util.Random;

public class CardHolder implements Runnable{

    //Constants to prevent "magic numbers".
    final double amountToWithdraw = 500; //constant to decide how much to withdraw.
    final long timeToSleep = 6000; //Time for the Thread to sleep in-between withdrawals.
    final int upperBoundRandom = 7; //The upper bound (Exclusive) for the RNG regarding how many times each person should withdraw.

    private CreditCard card;

    CardHolder(CreditCard card){
        this.card = card;
    }

    @Override
    public void run() {
        Random rand = new Random();

        for(int i=0;i<rand.nextInt(1,upperBoundRandom);i++){
            try{
                makeWithdrawal(amountToWithdraw);
            }catch (Exception e){
                System.out.println("Could not withdraw "+amountToWithdraw);
            }

        }
    }

    //This method is synchronised meaning that only 1 thread can access it at a time.
    //What this method aims to do is just withdraw a set amount from a card and print it's state before and after.
    private synchronized void makeWithdrawal(double amountToWithdraw){
        if(card.getBalance()<amountToWithdraw){
            System.out.println("Not enough in account for "+Thread.currentThread().getName()+" to withdraw: $"+amountToWithdraw+",Balance:$"+card.getBalance());
        }else{
            System.out.println(Thread.currentThread().getName()+", before withdrawing $"+amountToWithdraw+",Balance:$"+card.getBalance()); //Before withdrawal
            try{ //wait 6 seconds
                Thread.sleep(timeToSleep);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            card.withdraw(amountToWithdraw);
            System.out.println(Thread.currentThread().getName()+", after withdrawing $"+amountToWithdraw+",Balance:$"+card.getBalance()); //After withdrawing
        }
    }
}
