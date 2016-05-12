import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Write a description of class ButtonHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TellerHandler implements ActionListener {

    private TellerGUI tellerGUI;
    private JTextField customerField;
    private JTextField amountField;

    public JTextField firstNameField;   
    public JTextField lastNameField;      
    public JTextField dateField;     
    public JTextField monthField;      
    public JTextField yearField;   
    public JTextField phoneNumberField;    
    public JTextField streetAddressField; 
    public JTextField cityAddressField;
    public JTextField postalCodeField;
    public JTextField emailAddressField;

    private String actionType;

    public int customerID;
    public double amoutNumber;
    public String firstName;   
    public String lastName;      
    public int date;     
    public int month;      
    public int year;   
    public String phoneNumber;    
    public String streetAddress; 
    public String cityAddress;
    public String postalCode;
    public String emailAddress;
    public char accountType;

    public TellerHandler(String action_type, TellerGUI input_gui ) {
        actionType  = action_type;
        tellerGUI = input_gui;
    }

    @Override
    public void actionPerformed(ActionEvent buttonClicked) {
        this.receiveFieldData();
        if(actionType.equals("loadcustomer")){
            try {
                customerID    = Integer.parseInt(customerField.getText());     

                Customer load_customer = Bank.getCustomer(customerID);
                firstNameField.setText(load_customer.getCustomerFirstName());   
                lastNameField.setText(load_customer.getCustomerLastName());      
                dateField.setText(" ");     
                monthField.setText(" ");      
                yearField.setText(" ");   
                phoneNumberField.setText(load_customer.getPhoneNumber());    
                streetAddressField.setText(load_customer.getstreetAddress()); 
                cityAddressField.setText(load_customer.getcityAddress());
                postalCodeField.setText(load_customer.getzipOrPostalCode());
                emailAddressField.setText(load_customer.getEmail());
            }

            catch (Exception e){

                JOptionPane.showMessageDialog(null, "Failed loading customer");
            }

        }
        else if(actionType.equals("adda")){
            try {
                amoutNumber   = Double.parseDouble(amountField.getText());
                customerID    = Integer.parseInt(customerField.getText());
                accountType   = tellerGUI.accoutType;
                if (accountType == 'S'){
                    Savings new_savings = new Savings(Bank.getCustomer(customerID),amoutNumber);
                    Bank.getCustomer(customerID).addAccount(new_savings);
                }
                else if (accountType == 'O'){
                    OverDraftProtection new_odf_account = new OverDraftProtection(Bank.getCustomer(customerID),amoutNumber, Bank.getCustomer(customerID).getAccount('S'));
                    Bank.getCustomer(customerID).addAccount(new_odf_account);
                }
                else if (accountType == 'I'){
                    Investment new_investment_account = new Investment(Bank.getCustomer(customerID), amoutNumber, Integer.parseInt(tellerGUI.getInvestmentTermField().getText()));
                    Bank.getCustomer(customerID).addAccount(new_investment_account);
                }
                else if (accountType == 'C'){
                    LineOfCredit new_loc_account = new LineOfCredit(Bank.getCustomer(customerID), Double.parseDouble(tellerGUI.getCreditLimitField().getText()), amoutNumber);
                    Bank.getCustomer(customerID).addAccount(new_loc_account);
                }
                
                JOptionPane.showMessageDialog(null, "Success adding new account");
            }

            catch (Exception e){

                JOptionPane.showMessageDialog(null, e);
            }

        }
        else if(actionType.equals("addc")){

            try{
                date          = Integer.parseInt(tellerGUI.dateField.getText());     
                month         = Integer.parseInt(tellerGUI.monthField.getText());      
                year          = Integer.parseInt(tellerGUI.yearField.getText());
                Customer new_customer = new Customer(firstName,lastName, ( new GregorianCalendar( year,month,date).getTime()));
                new_customer.setPhoneNumber(phoneNumber);
                new_customer.setStreetAddress(streetAddress);
                new_customer.setCityAddress(cityAddress);
                new_customer.setPostalCode(postalCode);
                new_customer.setEmail(emailAddress);
                Bank.addCustomer(new_customer); 
                JOptionPane.showMessageDialog(null,"Customer created with ID of "+ new_customer.getCustomerId());

            }

            catch (Exception e){
                JOptionPane.showMessageDialog(null,"Failed to create customer");

            }

        }
        
        else if(actionType.equals("delete")){
            customerID    = Integer.parseInt(customerField.getText());

            try{
                Bank.getCustomer(customerID).removeAccount(accountType);
                JOptionPane.showMessageDialog(null, "Remove Account Success");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Remove Account Failed");

            }
        }
        
        else if (actionType.equals("loadfile")){
            try{
                CustomerFileReader file_reader = new CustomerFileReader();
                Bank.setCustomerData(file_reader.readCustomers());  
                
                JOptionPane.showMessageDialog(null, "Load from file success");
            }
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                
            }
                     
        }
        else if (actionType.equals("savefile")){
           try{
                CustomerFileWriter file_write = new CustomerFileWriter();
                file_write.saveCustomer(Bank.getCustomerData());
                
                JOptionPane.showMessageDialog(null, "Save to file success");
            }
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                
            }
        
        }
    }

    private void receiveFieldData(){
        customerField = tellerGUI.getCustomerIdField();
        amountField   = tellerGUI.getAmountField(); 
        firstName     = tellerGUI.firstNameField.getText() ;   
        lastName      = tellerGUI.lastNameField.getText();       
        phoneNumber   = tellerGUI.phoneNumberField.getText();    
        streetAddress = tellerGUI.streetAddressField.getText(); 
        cityAddress   = tellerGUI.cityAddressField.getText();
        postalCode    = tellerGUI.postalCodeField.getText();
        emailAddress  = tellerGUI.emailAddressField.getText();

        firstNameField     = tellerGUI.firstNameField;   
        lastNameField      = tellerGUI.lastNameField;       
        phoneNumberField   = tellerGUI.phoneNumberField;    
        streetAddressField = tellerGUI.streetAddressField; 
        cityAddressField   = tellerGUI.cityAddressField;
        postalCodeField    = tellerGUI.postalCodeField;
        emailAddressField  = tellerGUI.emailAddressField;
        dateField          = tellerGUI.dateField;     
        monthField         = tellerGUI.monthField;      
        yearField          = tellerGUI.yearField;

        accountType   = tellerGUI.accoutType;
    }
}