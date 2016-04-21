
/**
 * Write a description of class AccountTypeAlreadyExistsException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountTypeAlreadyExistsException extends Exception
{
    // instance variables - replace the example below with your own
    private Account accType;

    /**
     * Constructor for objects of class AccountTypeAlreadyExistsException
     */
    public AccountTypeAlreadyExistsException(Account account_input)
    {
        super("Unable to create duplicate account of type ");
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
            return super.getMessage() + "Investment";
        }
        
        else if (accType instanceof Savings){
            return super.getMessage() + "Savings";
        }
                     
        else if (accType instanceof LineOfCredit){
            return super.getMessage() + "LineOfCredit";
        }
        
        else if (accType instanceof OverDraftProtection){
            return super.getMessage() + "OverDraftProtection";
        }
        
        else {
            return "Unknown Account.";
        }
    }
}
