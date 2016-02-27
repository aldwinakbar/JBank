
/**
 * Store every information of each account
 * 
 * @author Aldwin Hermanudin 
 * @version 27/02/2016
 */
public class Account
{
    // instance variables - replace the example below with your own
    private char acctType;
    private double balance;
    private String id;

    /**
     * Constructor for objects of class Account
     */
    public Account() {
        // initialise instance variables
        
    }

    public Account(char type, double amount) {
        
    }
   
    /**
     * Method to deposit a value to balance. If deposit value above zero, it'll returns true. else it'll return false.
     * 
     * @return true, false in boolean
     * @param amount
     */
    public boolean deposit(double amount) {
        if (amount >= 0){
            balance += amount;
            return true;
        }
        
        else {
            return false;
        }
    }
    
    /**
     * Method to get account type
     * 
     * @return account type in char
     */
    public char getAcctType() {
        
        return acctType;
    }
    
    /**
     * Method to get balance value
     * 
     * @return balance in double
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Method to get accout id
     * 
     * @return id in String
     */
    public String getId() {
        return id;
    }
    
    /**
     * Method to change balance value
     * 
     * @param amount
     */
    public void setBalance(double amount) {
        balance = amount;
    }
    
    /**
     * Method to change id
     * 
     * @param acctID
     */
    public void setID(String acctId) {
        
        id = acctId;
    }
    
    /**
     * Method to change account type
     * 
     * @param type
     */
    public void setAcctType(char type) {
        
        acctType = type;
    }
    
    /**
     * Method to withdraw value from balance. If balance-amount_withdraw above zero, it will set the result to the balance variable and return true, else it'll return false
     * @param amount
     * @return true, false
     */
    public boolean withdraw(double amount) {
    
        double balance_temp = balance;
        double withdraw_result = balance_temp-amount;
        if(withdraw_result >=0){
            balance = withdraw_result;
            return true;
        }
        else{
            return false;
        }
    }
}
