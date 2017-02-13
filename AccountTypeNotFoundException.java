/**
 * A class that creates the exception if account not found
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class AccountTypeNotFoundException extends Exception
{
    
    private char accType;
    
    /**
     * AccountTypeNotFoundException Constructor
     *
     * @param account_input A parameter
     */
    public AccountTypeNotFoundException(char account_input)
    {
        super("account does not exist");
        accType = account_input;
    }

    
    /**
     * Method getMessage to generate error message
     *
     * @return The return value is the string of the error message
     */
    @Override
    public String getMessage() {
        if (accType == 'I'){
            return "Investment" + super.getMessage();
        }
        
        else if (accType == 'S'){
            return "Savings" + super.getMessage();
        }
                     
        else if (accType == 'C'){
            return "LineOfCredit" + super.getMessage();
        }
        
        else if (accType == 'O'){
            return "OverDraftProtection" + super.getMessage();
        }
        
        else {
            return "Unknown Account.";
        }
    }
}
