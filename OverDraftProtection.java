/**
 * Account class of the OverDraftProtection account
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class OverDraftProtection extends Checking
{
    // instance variables - replace the example below with your own
    private Account savingsAccount;
    private double fee = 3;

    /**
     * Constructor for objects of class OverDraftProtection
     */
    public OverDraftProtection(Customer savings_customer, double amount, Account savings)
    {
        super(savings_customer, amount); // initialise instance variables
        savingsAccount = savings;
    }

    protected void feeAssesment(){
        monthlyFee += fee;
        balance -= fee;

    }

    public void withdraw(double amount) throws AmountOverDrawnException{
        if (amount > balance + savingsAccount.getBalance() - 10){
            throw new AmountOverDrawnException(this);  
            //return false;
        }

        else if ( amount > balance ){
            balance = 0;
            savingsAccount.withdraw(amount - balance);
            feeAssesment();
        }

        else {
            balance = balance - amount;
        }
    }
}
