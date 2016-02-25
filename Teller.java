
/**
 * Write a description of class Teller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teller
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Teller
     */
    public Teller()
    {
        // initialise instance variables
    }
    
     public static void main(String[] args) {
        // put your code here
        Customer c1 = new Customer();
        c1.setName("Sanadhi","Sutandi");
        System.out.print(c1.getCustomerName()+"\n");
        
        Account a1 = new Account();
        a1.setBalance(123);
        
        c1.setAccount(a1);
        Account c1a1 = c1.getAccount();
        System.out.print(c1a1.getBalance()+"\n");
    }
}
