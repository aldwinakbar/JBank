
/**
 * Write a description of class AccountTypeNotFoundException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountTypeNotFoundException extends Exception
{
    // instance variables - replace the example below with your own
    private char accType;

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public AccountTypeNotFoundException(char account_input)
    {
        super("account does not exist");
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
