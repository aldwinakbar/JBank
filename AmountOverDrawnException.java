
/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmountOverDrawnException extends Exception
{
    // instance variables - replace the example below with your own
    private Account accType;

    /**
     * Constructor for objects of class AmountOverDrawnException
     */
    public AmountOverDrawnException(Account account_input)
    {
        super("Insufficient funds");
        accType = account_input;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public String getMessage() {
        if (accType instanceof Investment){
            return super.getMessage() + "in Investment Account";
        }
        
        else if (accType instanceof Savings){
            return super.getMessage() + "in Savings Account";
        }
                     
        else if (accType instanceof LineOfCredit){
            return super.getMessage() + "in LineOfCredit Account";
        }
        
        else if (accType instanceof OverDraftProtection){
            return super.getMessage() + "in OverDraftProtection Account";
        }
        
        else {
            return "Unknown Account.";
        }
    }
}
