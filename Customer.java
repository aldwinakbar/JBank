import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Customer class to store customer information. Using regex.Matcher and regex.Pattern library
 * 
 * @author Aldwin Hermanudin 
 * @version 27/02/2016
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private Account[] accounts = new Account[4];
    private String cityAddress;
    private int custId;
    private Date dateOfBirth;
    private String email;
    private String firstName; 
    private String lastName;
    private int numberOfCurrentAccounts = 0;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    
    /**
     * Constructor overload for objects of class Customer
     * @param  fname, lname, dob
     * 
     */
    public Customer(String fname, String lname) {
         this(fname, lname, null);
    }
    
    /**
     * Constructor overload for objects of class Customer
     * @param firstName, lastName, dateOfBirth, custId
     * 
     */
    public Customer(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.custId = Bank.getNextID();
    }
       
    /**
     * Method to get address information
     * @param firstName, lastName, dateOfBirth, custId
     * @return address information in String
     */
    public String getAddress() {
        return streetAddress+","+cityAddress+","+zipOrPostalCode;
    }
    
    /**
     * Method to get account data of the customer
     * 
     * @return account object
     */
    public Account getAccount(char type) {
        for (int i = 0; i < accounts.length; i++){
                if(accounts[i] != null){
                    if (accounts[i].getId().endsWith(Character.toString(type))) {
                        return accounts[i];
                    }
                }
        }
        return null;
    }

    
    public boolean removeAccount(char type) {
        for (int i = 0; i < accounts.length; i++){
                if(accounts[i] != null){
                    if (accounts[i].getId().endsWith(Character.toString(type))) {
                        accounts[i] = null;
                        numberOfCurrentAccounts--;
                        return true;
                    }
                }
        }
        return false;
    }
    
    
    /**
     * Method to get customer id number
     * 
     * @return customer id in integer
     */
    public int getCustomerId() {
        return custId;
    }
    
    /**
     * Method to get email information
     * 
     * @return email in String
     */
    public String getEmail(){
        return email;
    }
    
    public Date getDateOfBirth(){
        
        return dateOfBirth;
    }
    
    /**
     * Method to get customer name
     * 
     * @return lastname,firstname of the customer in String
     */
    public String getCustomerName() {
        return lastName+","+firstName;
    }
    
    /**
     * Meethod to get the number of accounts of the customer
     * 
     * @return number oof accounts in integer
     */
    public int getNumOfAccounts() {
        return numberOfCurrentAccounts;
    }
    
    /**
     * Method to get the customer phone number 
     * 
     * @return customer phone number in String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Method to set email of the customer, also checks the format of the email using regex with RFC 5322
     *
     * @param emailAddress
     * @return false, true
     */
    public boolean setEmail(String emailAddress) {
        String regex_email = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex_email);
        Matcher matcher = pattern.matcher(emailAddress);
        if(matcher.matches()){
            email = emailAddress; 
            return true;
        }
        else{
            return false;
        }
    }
        
    /**
     * Method to change the account of the Customer
     * 
     * @param account_input
     */
    public boolean addAccount(double balance, char type){
        boolean accountAdded = false;
        if (numberOfCurrentAccounts < accounts.length ){
            for (int i = 0; i < accounts.length; i++){
                if(accounts[i] != null){
                    if (accounts[i].getId().endsWith(Character.toString(type))) {break;}
                }
                
                else if (accounts[i] == null){
                    accounts[i] = new Account(type,balance,this);
                    accountAdded = true;
                    numberOfCurrentAccounts++;
                }
            }
        }
        return accountAdded;     
    }
    
    /**
     * Method to change the account of the Customer
     * 
     * @param account_input
     */
    public void setCustId(int cust_id_input){
        custId = cust_id_input;        
    }
    
    /**
     * Method to change phone number
     * 
     * @param phoneNum
     */
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }
    
    public void setStreetAddress(String street) {
        streetAddress = street;
    }
    
    public void setCityAddress(String city) {
        cityAddress = city;
    }
        
    public void setPostalCode(String zip_code) {
        zipOrPostalCode = zip_code;
    }
    
    
}