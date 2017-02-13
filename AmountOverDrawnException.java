/**
 * A class that creates the exception if amount overdrawn
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class AmountOverDrawnException extends Exception{
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
     * Method getMessage to generate error message
     *
     * @return The return value is the string of the error message
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
