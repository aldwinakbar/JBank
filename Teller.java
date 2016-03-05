import java.util.Scanner;
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
         String continue_flag;
         
         do{
             Scanner in = new Scanner(System.in);
             Scanner in_2 = new Scanner(System.in);
             String create_customer;
             String first_name;
             String last_name;
             String date_of_birth;
             String phone_number;
             String account_type_str;
             char account_type_char;
             System.out.println("Create a customer? (yes/no)");
             create_customer = in.nextLine();
             if (create_customer.equals("yes")){
                  System.out.println("Insert your first name.");
                  first_name = in.nextLine();                  
                  System.out.println("Insert your last name.");
                  last_name = in.nextLine();
                  System.out.println("Insert your date of birth.(dd/mm/yyyy)");
                  date_of_birth = in.nextLine();
                  System.out.println("Insert your phone number.");
                  phone_number = in.nextLine();
                  
                  Customer new_customer = new Customer(first_name,last_name,date_of_birth);
                  new_customer.setPhoneNumber(phone_number);
                 
                  double initial_balance;
                  System.out.println("\nS : Savings");
                  System.out.println("O : Overdraft");
                  System.out.println("I : Investment");
                  System.out.println("C : Credit Checking");
                  System.out.println("N : No Account");
                  System.out.println("What account do you want to make?(S/O/I/C/N)");
                  account_type_str = in.nextLine();
                  account_type_char = account_type_str.charAt(0);
                  
                  if (account_type_char !=  'N'){                   
                  
                      System.out.println("\nInput your initial balance");
                      initial_balance = in.nextDouble();
                      
                      while(initial_balance < 10){
                          System.out.println("\nInitial input cannot be below 10. Input your initial balance");
                          initial_balance = in.nextDouble();
                          
                        }
                  }
                  
                  else{
                      initial_balance = 0;
                      
                    }
                  Account new_account = new Account(account_type_char,initial_balance);
                  new_customer.setAccount(new_account);
                  
                  System.out.println("Here are your account information");
                  System.out.println("Name          : "+new_customer.getCustomerName());
                  System.out.println("Date of birth : "+date_of_birth);
                  System.out.println("Phone number  : "+new_customer.getPhoneNumber());
                  System.out.println("Account type  : "+new_customer.getAccount().getAcctType());
                  System.out.println("Balance       : "+new_customer.getAccount().getBalance());
                  
                  System.out.println("Continue?(yes/no)");
                  continue_flag = in_2.nextLine();
                  
            }
            
            else{
                
                continue_flag = "no";
            }
        }
        while(continue_flag.equals("yes"));
            
         // put your code here
        //Customer c1 = new Customer("Sanadhi","Sutandi");
        //System.out.print(c1.getCustomerName()+"\n");
        
        //Account a1 = new Account();
        //a1.setBalance(123);
        
       // c1.setAccount(a1);
        //System.out.print(c1.getAccount().getBalance()+"\n");
    }
}
