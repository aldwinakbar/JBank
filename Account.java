
/**
 * Write a description of class Account here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
   
    private void deposit(double amount) {
    
    }
    
    public char getAcctType() {
        
        return acctType;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getId() {
        return id;
    }
    
    public void setBalance(double amount) {
        balance = amount;
    }
    
    public void setID(String acctId) {
        
        id = acctId;
    }
    
    public void setAcctType(char type) {
        
        acctType = type;
    }
    
    private void withdraw(double amount) {
        
    }
}
