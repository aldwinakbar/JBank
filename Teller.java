import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
import java.math.*;

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
     * Calculate the compound interest rate for investment account
     * 
     * @param  days, rate, balance, investment_term
     */
    
    private static double compoundInterestRate(int days, double rate, double balance, int investment_term){
        
        if (investment_term > 0 && investment_term <= 6)    rate = 0.05;
        else if (investment_term > 6 && investment_term <= 12 ) rate = 0.06;
        else if (investment_term > 12)  rate = 0.07;
        
        return compoundInterestRate(days, rate, balance);
    }
    
    /**
     * Calculate the compound interest rate for savings account
     * 
     * @param  days, rate, balance     
     */
    
    private static double compoundInterestRate(int days, double rate, double balance){
                
        BigDecimal bal = new BigDecimal(balance);
        BigDecimal n = new BigDecimal(360.0); 
        BigDecimal t = new BigDecimal(days);
        BigDecimal r = new BigDecimal(rate);
        BigDecimal one = new BigDecimal(1); 
        BigDecimal f1 = r.divide(n, BigDecimal.ROUND_HALF_EVEN).add(one);
        BigDecimal f2 = bal.multiply(f1);
        BigDecimal f3 = n.multiply(t);
        return Math.pow(f2.doubleValue(), f3.doubleValue());
    }
    
    /**
     * Main method in Teller class, as the entry point of the JBank program
     * 
     * @param  args     
     */
    
     public static void main(String[] args) {
         
         Account savings_account = new Account('S',1000);
         Account investment_account = new Account('I',1000);
         Account credit_account = new Account('C',500);         
         savings_account.setBalance(compoundInterestRate(1,0.03,savings_account.getBalance()));
         investment_account.setBalance(compoundInterestRate(1,0.03,investment_account.getBalance(),12));
         
         
         Bank.setStartTime(11,10);
         Bank.setCloseTime(22,10);
         
         SimpleDateFormat sdf_24 = new SimpleDateFormat("k:m");
         String date_s_24 = sdf_24.format(Bank.getStartTime());
         String date_c_24 = sdf_24.format(Bank.getCloseTime());
         
         System.out.println("Woring Hours");
         System.out.println(Bank.getHoursOfOperation());
         System.out.println(date_s_24 + " To " + date_c_24);
         
         
         String continue_flag;
         do{
             Scanner in = new Scanner(System.in);
             Scanner in_2 = new Scanner(System.in);
             String create_customer;
             String first_name;
             String last_name;
             int year = 1995;
             int month = 1;
             int day = 1;
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
                  year = in.nextInt();
                  month = in.nextInt();
                  day = in.nextInt();
                  System.out.println("Insert your phone number.");
                  phone_number = in.nextLine();
                  
                  
                  Customer new_customer = new Customer(first_name,last_name, ( new GregorianCalendar(year, month, day).getTime()));
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
                  System.out.println("Date of birth : "+new_customer.getDateOfBirth());
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
