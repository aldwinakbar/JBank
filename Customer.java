
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private Account accounts = new Account();
    private String cityAddress;
    private int custId;
    private String dateOfBirth;
    private String email;
    private String firstName; 
    private String lastName;
    private int numberOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;

    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        
    }
    
     public Customer(String fname, String lname, String dob) {
    
    }
    
    public Customer(String firstName, String lastName, String dateOfBirth, int custId) {
        
    }
       
    public String getAddress() {
        return streetAddress+cityAddress+zipOrPostalCode;
    }
    
    public Account getAccount() {
        return accounts;
    }
    
    public int getCustomerId() {
        return custId;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getCustomerName() {
        return lastName+","+firstName;
    }
    
    public int getNumOfAccounts() {
        return numberOfCurrentAccounts;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setAddress(String street, String city, String code) {
        String streetAddress = street;
        cityAddress = city;
        zipOrPostalCode = code;
        
    }
    
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
    
    public void setName(String lname, String fname) {
         lastName = lname;
         firstName = fname;
        
    }
    
    public void setAccount(Account account_input){
        accounts = account_input;        
    }
    
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }
}
