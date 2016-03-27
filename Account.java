
/**
 * Store every information of each account
 * 
 * @author Aldwin Hermanudin 
 * @version 27/02/2016
 */
public abstract class Account
{
    protected double balance;
    protected String id;
    private Customer account_owner;

    /**
     * Constructor for objects of class Account
     */
    public Account(double amount) {
        balance = amount;
    }
       
    public abstract boolean withdraw(double amount);
    
    public String toString(){
        return id;        
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
 

}
