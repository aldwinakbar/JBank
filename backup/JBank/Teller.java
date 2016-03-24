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
         
         Bank.setStartTime(9,10);
         Bank.setCloseTime(22,10);
         
         System.out.println("Working Hours");
         System.out.println(Bank.getHoursOfOperation());
         
         String continue_flag;
         do{
             Scanner scan_int = new Scanner(System.in);
             Scanner scan_line = new Scanner(System.in);
             Scanner scan_double = new Scanner(System.in);
             String create_customer;
             String first_name;
             String last_name;
             int year;
             int month;
             int day;
             String phone_number;
             String account_type_str;
             char account_type_char;
             System.out.println("Create a customer? (yes/no)");
             create_customer = scan_line.nextLine();
             if (create_customer.equals("yes")){
                  
                 System.out.println("Insert your first name.");
                  first_name = scan_line.nextLine();                  
                  System.out.println("Insert your last name.");
                  last_name = scan_line.nextLine();
                  System.out.println("Insert your date of birth.(yyyy/mm/dd)");
                  year = scan_int.nextInt();
                  month = scan_int.nextInt() - 1;
                  day = scan_int.nextInt();
                  System.out.println("Insert your phone number.");
                  phone_number = scan_line.nextLine();
                  
                  Customer new_customer = new Customer(first_name,last_name, ( new GregorianCalendar(year, month, day).getTime()));
                  new_customer.setPhoneNumber(phone_number);
                 
                  double initial_balance;
                  System.out.println("\nS : Savings");
                  System.out.println("O : Overdraft");
                  System.out.println("I : Investment");
                  System.out.println("C : Credit Checking");
                  System.out.println("N : No Account");
                  System.out.println("What account do you want to make?(S/O/I/C/N)");
                  account_type_str = scan_line.nextLine();
                  account_type_char = account_type_str.charAt(0);
                  
                  if (account_type_char !=  'N'){                   
                  
                      System.out.println("\nInput your initial balance");
                      initial_balance = scan_double.nextDouble();
                      
                      while(initial_balance < 10){
                          System.out.println("\nInitial input cannot be below 10. Input your initial balance");
                          initial_balance = scan_double.nextDouble();
                          
                        }
                  }
                  
                  else{
                      initial_balance = 0;
                      
                    }
                  Account new_account = new Account(account_type_char,initial_balance);
                  new_customer.setAccount(new_account);
                  
                  System.out.println((Bank.addCustomer(new_customer)) ? "Customer created\n":"Failed to create customer\n");
                  
                  System.out.println((Bank.getCustomer(new_customer.getCustomerId()) != null) ? "Customer found\n":"Failed to found customer\n");
                  
                  System.out.println("Here are your account information");
                  System.out.println("Name          : "+Bank.getCustomer(new_customer.getCustomerId()).getCustomerName());
                  System.out.println("Date of birth : "+Bank.getCustomer(new_customer.getCustomerId()).getDateOfBirth());
                  System.out.println("Phone number  : "+Bank.getCustomer(new_customer.getCustomerId()).getPhoneNumber());
                  System.out.println("Account type  : "+Bank.getCustomer(new_customer.getCustomerId()).getAccount().getAcctType());
                  System.out.println("Balance       : "+Bank.getCustomer(new_customer.getCustomerId()).getAccount().getBalance());
                  
                  System.out.println("Continue?(yes/no)");
                  continue_flag = scan_line.nextLine();
                  
            }
            
            else{
                
                continue_flag = "no";
            }
        }
        while(continue_flag.equals("yes"));
    }
}
