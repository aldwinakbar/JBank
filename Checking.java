
/**
 * Abstract class Checking - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Checking extends Account
{
    // instance variables - replace the example below with your own
    protected double monthlyFee;
    
    public Checking(Customer savings_customer, double amount)
    {
        super(amount);
        id = Integer.toString(savings_customer.getCustomerId());
    }
    
    protected abstract void feeAssesment();
    
    public void resetMonthlyFee(){
        monthlyFee = 0 ;
    }
    
    public double getMonthlyFee(){
        return monthlyFee;
    }
        
}
