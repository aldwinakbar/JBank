import java.io.Serializable;

/**
 * An abstract class for every concrete Account class
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public abstract class Account implements Serializable
{
    protected double balance;
    protected String id;
    private Customer account_owner;

    /**
     * Account Constructor
     *
     * @param amount A parameter for the initial amount
     */
    public Account(double amount) {
        balance = amount;
    }

    /**
     * Method withdraw for the abstract method in every concrete Account class
     *
     * @param amount A parameter for the withdraw value
     */
    public abstract void withdraw(double amount) throws AmountOverDrawnException;

    /**
     * Method toString
     *
     * @return The return value is the account id
     */
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
