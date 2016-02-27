
/**
 * The main class of the JBank program. 
 * 
 * @author Aldwin Hermanudin 
 * @version 27/02/2016
 */
public class Teller
{
    /**
     * Constructor for objects of class Teller
     */
    public Teller()
    {
        
    }
    
    /**
     * Main method in Teller class, as the entry point of the JBank program
     * 
     * @param  args     
     */
    
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
