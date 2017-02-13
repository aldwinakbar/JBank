/**
 * A class that creates the exception if account already exist
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class AccountTypeAlreadyExistsException extends Exception{
    
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
     * Method getMessage to generate error message
     *
     * @return The return value is the string of the error message
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
