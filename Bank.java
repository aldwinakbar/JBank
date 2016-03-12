import java.util.*;
import java.text.*;

/**
 * Bank class to store every customer information.
 * 
 * @author Aldwin Hermanudin 
 * @version 27/02/2016
 */

public class Bank
{
    // instance variables - replace the example below with your own
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
    public static final int MAX_NUM_OF_CUSTOMERS = 20;
    public static final String  BANK_NAME = "JBANK";

    /**
     * Constructor for objects of class Bank
     */
    private Bank() {
        // initialise instance variables
        
    }

    /*
    public static String getAddress() {
        return "";
    }
    */
    
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
    
    /*
    public static int getMaxCustomers() {
        return 0;
    }
    */
   
    public static int getNumOfCurrentCustomers(){
        return numOfCurrentCustomer;
    }
    
    /*
    public static String getName() {
        return "";
    }
    */
   
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
