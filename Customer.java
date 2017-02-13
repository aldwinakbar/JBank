import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;


/**
 * Customer class to store customer information. Using regex.Matcher and regex.Pattern library
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class Customer implements Comparable<Customer>, Serializable
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
     * Customer Constructor
     *
     * @param fname A parameter for customer first name
     * @param lname A parameter for customer last name
     */
    public Customer(String fname, String lname) {
        this(fname, lname, null);
    }

    /**
     * Constructor overload for objects of class Customer
     * @param firstName, lastName, dateOfBirth, custId of the customer
     * 
     */
    public Customer(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.custId = Bank.getNextID();
    }

     /**
     * Method to get account data of the customer
     * 
     * @param account type in char, S, I, O, or C
     * @return an account object
     * @throws throws an Exception of AccountTypeNotFoundException, if account does not exsist
     */
    public Account getAccount(char type) throws AccountTypeNotFoundException{
        // modify(remove) the multiple elseif by using OR statements in if

        for (int i = 0; i < accounts.length; i++){
            if(accounts[i] != null){
                if (type == 'S' && accounts[i] instanceof Savings)  return accounts[i];
                else if (type == 'O' && accounts[i] instanceof OverDraftProtection)  return accounts[i];
                else if (type == 'I' && accounts[i] instanceof Investment)  return accounts[i];
                else if (type == 'C' && accounts[i] instanceof LineOfCredit)  return accounts[i];
            }
        }
        throw new AccountTypeNotFoundException(type);
    }

     /**
     * Method to change the account of the Customer
     * 
     * @param Account object for the Customer object
     * @throws an exception of AccountTypeAlreadyExistsException, if account already exsist
     * @return true if success, false if failed
     */
    public boolean addAccount(Account type) throws AccountTypeAlreadyExistsException{
        boolean accountAdded = false;
        if (numberOfCurrentAccounts < accounts.length ){
            for (int i = 0; i < accounts.length; i++){
                if(accounts[i] != null){
                    if ( (accounts[i].getClass().equals(type.getClass())) ) {
                        break;
                    }
                }

                else if (accounts[i] == null){
                    accounts[i] = type; 
                    accountAdded = true;
                    numberOfCurrentAccounts++;
                    break;
                }
            }
        }

        if (accountAdded){
            return accountAdded;
        }
        else {
            throw new AccountTypeAlreadyExistsException(type);
        }  
    }
    
    /**
     * Method removeAccount of the related customer object, and give the related slot to a null value
     *
     * @param type A parameter to for the account type
     * @return The return value true or false.
     */
    public boolean removeAccount(char type) {
        // modify(remove) the multiple elseif by using OR statements in if
        for (int i = 0; i < accounts.length; i++){
            if(accounts[i] != null){
                if (type == 'S' && accounts[i] instanceof Savings)  {
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    return true;
                }
                else if (type == 'O' && accounts[i] instanceof OverDraftProtection){  
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    return true;
                }
                else if (type == 'I' && accounts[i] instanceof Investment){  
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    return true;
                }
                else if (type == 'C' && accounts[i] instanceof LineOfCredit){  
                    accounts[i] = null;
                    numberOfCurrentAccounts--;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Method to get address information of the related customer.
     * 
     * @param firstName, lastName, dateOfBirth, custId of the customer
     * @return address information as String
     */
    public String getAddress() {
        return streetAddress+","+cityAddress+","+zipOrPostalCode;
    }

    /**
     * Method getstreetAddress to get the Street Address of the customer
     *
     * @return The return value is the street addres in string
     */
    public String getstreetAddress() {
        return streetAddress ;
    }

    /**
     * Method getcityAddress to get the city address of the customer
     *
     * @return The return value is the city address in string
     */
    public String getcityAddress() {
        return cityAddress ;
    }

    /**
     * Method getzipOrPostalCode to get the postalCode of the customer address
     *
     * @return The return value is the postal code in string
     */
    public String getzipOrPostalCode() {
        return zipOrPostalCode;
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

    /**
     * Method getDateOfBirth to get the customer date of birth
     *
     * @return The return value is the customer date of birth in Date
     */
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
     * Method getCustomerFirstName to get the customer first nme
     *
     * @return The return value of the customer first name in string
     */
    public String getCustomerFirstName() {
        return firstName;
    }

    /**
     * Method getCustomerLastName to get the customer last name
     *
     * @return The return value of the customer last name in string
     */
    public String getCustomerLastName() {
        return lastName;
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
    public void setCustId(int cust_id_input){
        custId = cust_id_input;        
    }

    /**
     * Method to change phone number that belongs to customer
     * 
     * @param phoneNum
     */
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }

    /**
     * Method setStreetAddress to set customer street address
     *
     * @param street A parameter of the street address
     */
    public void setStreetAddress(String street) {
        streetAddress = street;
    }

    /**
     * Method setCityAddress to set city address of the customer
     *
     * @param city A parameter of the address of the city
     */
    public void setCityAddress(String city) {
        cityAddress = city;
    }

    /**
     * Method setPostalCode to set postal code of the customer address
     *
     * @param zip_code A parameter of the customer postal code
     */
    public void setPostalCode(String zip_code) {
        zipOrPostalCode = zip_code;
    }

    /**
     * Method compareTo to use as a comparator to sort the Customer object in a SortedSet
     *
     * @return The return value is a id for the sorted customer
     */
    @Override
    public int compareTo(Customer o) {

        //ascending order
        return this.custId - o.getCustomerId();

    }
}