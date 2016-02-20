
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
       
    private String getAddress() {
            return "";
    }
    
    private Account getAccount() {
        return null;
    }
    
    private int getCustomerId() {
        return 0;
    }
    
    private String getEmail(){
        return "";
    }
    
    private String getCustomerName() {
        return "";
    }
    
    public int getNumOfAccounts() {
        return 0;
    }
    
    private String getPhoneNumber() {
        return "";
    }
    
    private void setAddress(String street, String city, String code) {
        
    }
    
    private void setEmail(String emailAddress) {
        
    }
    
    private void setCustomerName(String lname, String fname) {
        
    }
    
    private void setPhoneNumber(String phoneNum) {
        
    }
}
