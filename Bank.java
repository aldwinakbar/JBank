import java.util.*;
import java.text.*;
import java.util.Scanner;

/**
 * Bank class to store every customer information.
 * 
 * @author Aldwin Hermanudin 
 * @version 27/02/2016
 */

public class Bank
{
    private static double creditInterestRate;
    private static Date closeTime;
    private static double investmentInterestRate;
    private static int lastCustID = 1000;
    private static int nextCustID = 1000;
    private static String phone;
    private static double premiumInterestRate;
    private static Date startTime;
    private static int numOfCurrentCustomer;
    public static String website;
    public static final String  BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    public static final int MAX_NUM_OF_CUSTOMERS;
    public static final String  BANK_NAME = "JBANK";
    private static SortedSet<Customer> customer = new TreeSet<Customer>(); 
    
    static{
        Scanner in = new Scanner(System.in);
        System.out.println("Input Maximum Customer : ");
        MAX_NUM_OF_CUSTOMERS = in.nextInt();
    }

    public static void setCustomerData(SortedSet<Customer> customer_data){
        customer = customer_data;
    }
    
    public static SortedSet<Customer> getCustomerData(){
        
        return customer;
    }
    
    public static boolean addCustomer(Customer customer_new){
        if (numOfCurrentCustomer < MAX_NUM_OF_CUSTOMERS){
            customer.add(customer_new);  
            return true;
        }
        else {
            return false;
        }
    } 
        
    public static Customer getCustomer(int custID){ 
        
        Iterator it = customer.iterator();
        while (it.hasNext()) {
         Customer element = (Customer) it.next();
         if(element.getCustomerId() == custID){
			    return element;
			 }
         }
        return null;
    }
    
    public static int getMaxNumOfCustomers(){
        return MAX_NUM_OF_CUSTOMERS;
    }
    
    public static double getCreditRate() {
        return 0;
    }
    
    public static double getInvestmentRate() {
        return 0;
    }
    
    public static String getHoursOfOperation() {
        
         SimpleDateFormat sdf_12 = new SimpleDateFormat("hh:mm aa");
         String date_s_12 = sdf_12.format(Bank.getStartTime());
         String date_c_12 = sdf_12.format(Bank.getCloseTime());
        return date_s_12 + " To " + date_c_12;
    }
    
    public static int getLastID() {
        return lastCustID;
    }
    
    public static int getNumOfCurrentCustomers(){
        return numOfCurrentCustomer;
    }
   
    public static Date getStartTime(){
        
        return startTime;
    }
    
    public static Date getCloseTime(){
    
        return closeTime;
    }
    
    public static void setStartTime(int hour, int minute){
        int year = 1995;
        int month = 11;
        int day = 20;
        startTime =  (new GregorianCalendar(year, month, day, hour, minute).getTime());
    }
    
    public static void setCloseTime(int hour, int minute){
        int year = 1995;
        int month = 11;
        int day = 20;     
        closeTime =  (new GregorianCalendar(year, month, day, hour, minute).getTime());
    }
    
    public static int getNextID() {
       
        if (numOfCurrentCustomer == MAX_NUM_OF_CUSTOMERS){
            // do nothing           
        }
        else{
            numOfCurrentCustomer++;
            nextCustID++;
            lastCustID = nextCustID - 1;
        }
        return nextCustID;
    }
    
    
    
    public static String getWebsite() {
        return "";
    }
    
    public static double getPremiumRate() {
        return 0;
    }
    
    public static String getPhone() {
        return "";
    }
    
    public static void setCreditRate(double rate) {
        
    }
    
    public static void setInvestmentRate(double rate) {
        
    }
    
    public static void setPremium(double rate) {
        
    }
}
