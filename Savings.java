/**
 * Write a description of class Savings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Savings extends Account{
    
    protected double interestEarned;

    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer savings_customer, double amount)
    {
        super(amount);
        id = Integer.toString(savings_customer.getCustomerId());
    }

    public double getInterestEarned() {
        return interestEarned ;
    }    
    
    public void addDailyInterest(int days){
        double r = 0.03;
        double f = balance * Math.pow(1 + (r / 365), days);
        interestEarned = f - balance;
        balance = f;
    }
    
    public boolean withdraw(double amount) throws AmountOverDrawnException {
    
        double balance_temp = balance;
        double withdraw_result = balance_temp-amount;
        if(withdraw_result >=0){
            balance = withdraw_result;
            return true;
        }
        else{
            throw new AmountOverDrawnException(this);
           // return false;
        }
    }
}
