/**
 * An abstract class for the LineOfCredit and OverDraftProtection class
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public abstract class Checking extends Account
{

    protected double monthlyFee;

    /**
     * Checking Constructor
     *
     * @param savings_customer A parameter of the customer savings account.
     * @param amount A parameter of the initial account amount
     */
    public Checking(Customer savings_customer, double amount)
    {
        super(amount);
        id = Integer.toString(savings_customer.getCustomerId());
    }

    /**
     * Method feeAssesment is tthe abstract method for the concrete class
     *
     */
    protected abstract void feeAssesment();

    /**
     * Method resetMonthlyFee to reset the monthly fee
     *
     */
    public void resetMonthlyFee(){
        monthlyFee = 0 ;
    }

    /**
     * Method getMonthlyFee to get the value of the monthly fee
     *
     * @return The return value is the monthly fee in double
     */
    public double getMonthlyFee(){
        return monthlyFee;
    }

}
