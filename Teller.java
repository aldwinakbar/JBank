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
     * Main method in Teller class, as the entry point of the JBank program
     * 
     * @param  args     
     */
    
     public static void main(String[] args) {
         
          String first_name = "Aldwin";
          String last_name = "Hermanudin";
          int year = 1995;
          int month = 11 - 1;
          int day = 20;
          Customer new_customer = new Customer(first_name,last_name, ( new GregorianCalendar(year, month, day).getTime()));
          
          Savings new_savings_account = new Savings(new_customer,500);
          new_savings_account.addDailyInterest(280);
          
          Investment new_investment_account = new Investment(new_customer, 1000, 6);
          new_investment_account.addDailyInterest(280);
          
          System.out.println("Savings account after 280 days");
          System.out.println(new_savings_account.getBalance());
          
          System.out.println("Savings investment after 280 days");
          System.out.println(new_investment_account.getBalance());
         //Account test = new Account();
         /*
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
             String street_address;
             String city_address;
             String postal_code;
             String email_address;
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
                  Customer new_customer = new Customer(first_name,last_name, ( new GregorianCalendar(year, month, day).getTime()));
                  
                  System.out.println("Insert your phone number.");
                  phone_number = scan_line.nextLine();
                  new_customer.setPhoneNumber(phone_number);
                  
                  System.out.println("Insert your street address.");
                  street_address = scan_line.nextLine();
                  new_customer.setStreetAddress(street_address);
                  
                  System.out.println("Insert your city address.");
                  city_address = scan_line.nextLine();
                  new_customer.setCityAddress(city_address);
                  
                  System.out.println("Insert your postal code.");
                  postal_code = scan_line.nextLine();
                  new_customer.setPostalCode(postal_code);
                  
                  System.out.println("Insert your email address.");
                  email_address = scan_line.nextLine();
                  while(!(new_customer.setEmail(email_address))){
                          System.out.println("Your email is invalid. Insert your email address.");
                          email_address = scan_line.nextLine();
                          
                  }
                  
                 
                  double initial_balance = 10;
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
                  
                  new_customer.addAccount(initial_balance,account_type_char);
                  
                  System.out.println((Bank.addCustomer(new_customer)) ? "Customer created\n":"Failed to create customer\n");
                  int counter_customer = 1001;
                  while (Bank.getCustomer(counter_customer) != null){
                      System.out.println((Bank.getCustomer(counter_customer) != null) ? "\nCustomer with ID of "+ counter_customer +" found\n":"Failed to found customer\n");
                      if(Bank.getCustomer(counter_customer) != null){
                          System.out.println("Here are your account information");
                          System.out.println("Name          : "+Bank.getCustomer(counter_customer).getCustomerName());
                          System.out.println("Date of birth : "+Bank.getCustomer(counter_customer).getDateOfBirth());
                          System.out.println("Phone number  : "+Bank.getCustomer(counter_customer).getPhoneNumber());
                          System.out.println("Address       : "+Bank.getCustomer(counter_customer).getAddress());
                          System.out.println("Email Address : "+Bank.getCustomer(counter_customer).getEmail());
                          account_type_char = 'S';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getAcctType());
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                          account_type_char = 'O';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getAcctType());
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                          account_type_char = 'I';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getAcctType());
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                          account_type_char = 'C';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getAcctType());
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                      }
                      
                      counter_customer++;
                  }
                  System.out.println("Continue?(yes/no)");
                  continue_flag = scan_line.nextLine();
                  
            }
            
            else{
                
                continue_flag = "no";
            }
        }
        while(continue_flag.equals("yes"));
        */
     }
}
