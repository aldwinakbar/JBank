import java.util.*;
import java.text.*;
import java.util.Scanner;

/**
 * Bank class to store every customer-related methods and information. Every method is a static method in this class
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class Bank
{
    private static double creditInterestRate;
    private static Date closeTime;
    private static double investmentInterestRate;
    private static int lastCustID = 1000;
    private static int nextCustID = 1000;
    private static double premiumInterestRate;
    private static Date startTime;
    private static int numOfCurrentCustomer;
    public static final String  BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
    public static final int MAX_NUM_OF_CUSTOMERS;
    public static final String  BANK_NAME = "JBANK";
    private static SortedSet<Customer> customer = new TreeSet<Customer>(); 

    static{
        Scanner in = new Scanner(System.in);
        System.out.println("Input Maximum Customer : ");
        MAX_NUM_OF_CUSTOMERS = in.nextInt();
    }

    /**
     * Method setCustomerData to set the array object that contains all of the customer information including personal information and account data
     *
     * @param ArrayList of customer object as SortedSet in customer_data
     */
    public static void setCustomerData(SortedSet<Customer> customer_data){
        customer = customer_data;
    }

    /**
     * Method getCustomerData to return the object that contains all of the customer data
     *
     * @return the SortedSet object of customer
     */
    public static SortedSet<Customer> getCustomerData(){
        
        return customer;
    }

    /**
     * Method addCustomer to add a Customer object to the SortedSet customer
     *
     * @param customer_new A parameter of the custmer object
     * @return true if numOfCurrentCustomer less than MAX_NUM_OF_CUSTOMERS, else false.
     */
    public static boolean addCustomer(Customer customer_new){
        if (numOfCurrentCustomer < MAX_NUM_OF_CUSTOMERS){
            customer.add(customer_new);  
            return true;
        }
        else {
            return false;
        }
    } 

    /**
     * Method getCustomer to return a Customer object in the SortedSet of the customers
     *
     * @param custID A ID that very Customer object hold to identify themself
     * @return The return is the Customer object if finds the Customer object with the same custID, else return null
     */
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

    /**
     * Method getMaxNumOfCustomers to get the maximum number of customer that the JBank program can handle
     *
     * @return The return value is MAX_NUM_OF_CUSTOMERS
     */
    public static int getMaxNumOfCustomers(){
        return MAX_NUM_OF_CUSTOMERS;
    }

    /**
     * Method getHoursOfOperation to get the operation time of the bank.
     *
     * @return The return the start and end clock of the operation time in 12 Hour format
     */
    public static String getHoursOfOperation() {

        SimpleDateFormat sdf_12 = new SimpleDateFormat("hh:mm aa");
        String date_s_12 = sdf_12.format(Bank.getStartTime());
        String date_c_12 = sdf_12.format(Bank.getCloseTime());
        return date_s_12 + " To " + date_c_12;
    }

    /**
     * Method getLastID to get the last customer ID
     *
     * @return The return value is integer of the lastCustID variable
     */
    public static int getLastID() {
        return lastCustID;
    }

    /**
     * Method getNumOfCurrentCustomers to get the number of the current total Customer
     *
     * @return The return value is integer of the numOfCurrentCustomer variable
     */
    public static int getNumOfCurrentCustomers(){
        return numOfCurrentCustomer;
    }

    /**
     * Method getStartTime to get the start time of the bank operation
     *
     * @return The return value is a Date object in startTime variable
     */
    public static Date getStartTime(){

        return startTime;
    }

    /**
     * Method getCloseTime to get the close time of the bank operation
     *
     * @return The return value is a Date object in closeTime variable
     */
    public static Date getCloseTime(){

        return closeTime;
    }

    /**
     * Method getNextID to get the next Customer ID for the Customer object
     *
     * @return The return value is an integer in nextCustID variable
     */
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

    /**
     * Method setStartTime to set start time of bank operation
     *
     * @param hour A parameter for the hour start time
     * @param minute A parameter for the minute start time
     */
    public static void setStartTime(int hour, int minute){
        int year = 1995;
        int month = 11;
        int day = 20;
        startTime =  (new GregorianCalendar(year, month, day, hour, minute).getTime());
    }

    /**
     * Method setCloseTime to set close time of bank operation
     *
     * @param hour A parameter for the hour close time
     * @param minute A parameter for the minute close time
     */
    public static void setCloseTime(int hour, int minute){
        int year = 1995;
        int month = 11;
        int day = 20;     
        closeTime =  (new GregorianCalendar(year, month, day, hour, minute).getTime());
    }

}
