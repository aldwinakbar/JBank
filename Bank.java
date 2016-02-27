
/**
 * Write a description of class Bank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bank
{
    // instance variables - replace the example below with your own
    private static double creditInterestRate;
    private static String closeTime;
    private static double investmentInterestRate;
    private static int lastCustID = 1000;
    private static int nextCustID = 1000;
    private static String phone;
    private static double premiumInterestRate;
    private static String startTime;
    private static int numOfCurrentCustomer;
    //private static int nextID; //modul 2
    public static String website;
    public static String bankAddress = "1234 JavaStreet, AnyCity, ThisState, 34567";
    public static int maxNumOfCustomers = 20;
    public static String bankName = "JBANK";

    /**
     * Constructor for objects of class Bank
     */
    public Bank() {
        // initialise instance variables
        
    }

    public static String getAddress() {
        return "";
    }
    
    public static double getCreditRate() {
        return 0;
    }
    
    public static double getInvestmentRate() {
        return 0;
    }
    
    public static String getHoursOfOperation() {
        return "";
    }
    
    public static int getLastID() {
        return lastCustID;
    }
    
    public static int getMaxCustomers() {
        return 0;
    }
    
    public static int getNumOfCurrentCustomers(){
        return numOfCurrentCustomer;
    }
    
    public static String getName() {
        return "";
    }
    
    public static int getNextID() {
        nextCustID ++;
        lastCustID = nextCustID - 1;
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
