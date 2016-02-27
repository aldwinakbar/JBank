
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
   
    public boolean deposit(double amount) {
        if (amount >= 0){
            balance += amount;
            return true;
        }
        
        else {
            return false;
        }
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
