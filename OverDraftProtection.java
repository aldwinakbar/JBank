
/**
 * Write a description of class OverDraftProtection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OverDraftProtection extends Checking
{
    // instance variables - replace the example below with your own
    private int x;
    private Account savingsAccount;
    private double fee = 3;
    
    /**
     * Constructor for objects of class OverDraftProtection
     */
    public OverDraftProtection(Customer savings_customer, double amount, Account savings)
    {
        super(savings_customer, amount); // initialise instance variables
        savingsAccount = savingsAccount;
    }
    
    protected void feeAssesment(){
        monthlyFee += fee;
        balance -= fee;
        
    }
    
    public boolean withdraw(double amount) throws AmountOverDrawnException{
        if (amount > balance + savingsAccount.getBalance() - 10){
            throw new AmountOverDrawnException(this);  
            //return false;
        }
        
        else if ( amount > balance ){
            balance = 0;
            savingsAccount.withdraw(amount - balance);
            feeAssesment();
            return true;
        }
        
        else {
            balance = balance - amount;
            return true;
        }
    }
}
