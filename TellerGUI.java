import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
import java.math.*;

/**
 * A class to handle the TellerGUI
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class TellerGUI extends JPanel{

   private JFrame mainFrame;
   private JPanel upperPanel;
   private JPanel lowerPanel;
   
   private JPanel investTermFlow;
   private JPanel creditLimitFlow;
   
   public char accoutType = 'S';
      
   private JTextField customerIdField;
   private JTextField amountField;
   private JTextField investTermField;
   private JTextField creditLimitField;
   
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
      
   /**
    * TellerGUI Constructor to construct the GUI
    *
    */
   public TellerGUI(){
      buildGUI();
      this.customerIdField();
      this.accountTypeRadio();
      this.amountField();
      this.customerInfoArea(); 
      this.actionButton();
   }
   
    /**
     * Method buildGUI to construct the main frame
     *
     */
    private void buildGUI(){
      mainFrame = new JFrame("Teller Menu");
      mainFrame.setSize(710, 520);
      mainFrame.setLayout(new GridLayout(2, 1));     

      mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            { 
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,"You are exitting, goodbye!","JBank",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
                if(PromptResult==JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });    
      
      upperPanel = new JPanel();
      upperPanel.setLayout(new GridLayout(1,5));
       
      lowerPanel = new JPanel();
      lowerPanel.setLayout(new GridLayout(1,2));
      
      mainFrame.add(upperPanel);
      mainFrame.add(lowerPanel);
      mainFrame.setVisible(true);  
   }

     /**
      * Method accountTypeRadio to construct the radio button
      *
      */
     private void accountTypeRadio(){
         
      final JRadioButton radSavings = new JRadioButton("Savings", true);
      final JRadioButton radInvestment = new JRadioButton("Investment");
      final JRadioButton radLOC = new JRadioButton("Line Of Credit");
      final JRadioButton radOverdraft = new JRadioButton("Overdraft");
      
      
      radSavings.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {         
             accoutType = 'S';
         }           
      });

      radInvestment.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {             
            accoutType = 'I';
         }           
      });

      radLOC.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {             
            accoutType = 'C';
         }           
      });
      
       radOverdraft.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {             
            accoutType = 'O';
         }           
      });

      //Group the radio buttons.
      ButtonGroup group = new ButtonGroup();
      group.add(radSavings);
      group.add(radInvestment);
      group.add(radLOC);
      group.add(radOverdraft);
      
      JPanel radioPanel = new JPanel();
      radioPanel.setLayout(new GridLayout(4,1));
      
      JPanel radSavings_flow = new JPanel();
      radSavings_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      radSavings_flow.add(radSavings);
      
      JPanel radInvestment_flow = new JPanel();
      radInvestment_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      radInvestment_flow.add(radInvestment);
      
      JPanel radLOC_flow = new JPanel();
      radLOC_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      radLOC_flow.add(radLOC);
      
      JPanel radOverdraft_flow = new JPanel();
      radOverdraft_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      radOverdraft_flow.add(radOverdraft);
      
      radioPanel.add(radSavings_flow);
      radioPanel.add(radInvestment_flow);
      radioPanel.add(radLOC_flow);
      radioPanel.add(radOverdraft_flow); 
      upperPanel.add(radioPanel);

      mainFrame.setVisible(true);  
   }
   
   /**
    * Method customerIdField to coonstruct the customer field
    *
    */
   private void customerIdField(){

      
      JPanel customer_flow = new JPanel();
      customer_flow.setLayout((new FlowLayout()));
      
      JLabel  customer_label= new JLabel("Enter Customer ID: ", JLabel.CENTER); 
       JTextField customer_field = new JTextField(6); 
      customerIdField = customer_field;
      
      customer_flow.add(customer_label);
      customer_flow.add(customer_field);
      
      JPanel spacer = new JPanel();
      spacer.setLayout(new GridLayout());
      spacer.setSize(100,100);
      
      JPanel spacer_layout = new JPanel();
      spacer_layout.setLayout(new GridLayout(2,1));
      spacer_layout.add(spacer);
      spacer_layout.add(customer_flow);  
      
      upperPanel.add(spacer_layout);
      
      mainFrame.setVisible(true);  
   }
   
   /**
    * Method amountField to construct the amount, credit_limit, and investment_term field
    *
    */
   private void amountField(){
       
      JPanel amount_flow = new JPanel();
      amount_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JLabel  amount_label= new JLabel("Enter initial ammount: ", JLabel.LEFT);
       JTextField amount_field = new JTextField(6); 
      amountField = amount_field;
      
      amount_flow.add(amount_label);
      amount_flow.add(amount_field);
      
      JPanel invest_term_flow = new JPanel();
      invest_term_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JLabel  invest_term_label= new JLabel("Enter investment term: ", JLabel.LEFT);
       JTextField invest_term_field = new JTextField(2);
      investTermField = invest_term_field;
            
      invest_term_flow.add(invest_term_label);
      invest_term_flow.add(invest_term_field);
      investTermFlow = invest_term_flow;
      
      JPanel credit_limit_flow = new JPanel();
      credit_limit_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JLabel  credit_limit_label= new JLabel("Enter credit limit: ", JLabel.LEFT);
       JTextField credit_limit_field = new JTextField(6); 
      creditLimitField = credit_limit_field;
            
      credit_limit_flow.add(credit_limit_label);
      credit_limit_flow.add(credit_limit_field);
      creditLimitFlow = credit_limit_flow;
      
      JPanel spacer = new JPanel();
      spacer.setLayout(new GridLayout());
      spacer.setSize(100,100);
      
      JPanel spacer_layout = new JPanel();
      spacer_layout.setLayout(new GridLayout(4,1));
      spacer_layout.add(spacer); 
      spacer_layout.add(credit_limit_flow);     
      spacer_layout.add(invest_term_flow);
      spacer_layout.add(amount_flow);  
      
      upperPanel.add(spacer_layout);
   
      mainFrame.setVisible(true);  
   }
   
      /**
       * Method customerInfoArea to construct the customer info area
       *
       */
      private void customerInfoArea(){
      
      JPanel customer_info = new JPanel();
      customer_info.setLayout(new GridLayout(8,0));
      
      JPanel first_name_flow = new JPanel();
      first_name_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel last_name_flow = new JPanel();
      last_name_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel birthdate_flow = new JPanel();
      birthdate_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel phone_number_flow = new JPanel();
      phone_number_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel street_address_flow = new JPanel();
      street_address_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel city_address_flow = new JPanel();
      city_address_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel postal_code_flow = new JPanel();
      postal_code_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      JPanel email_address_flow = new JPanel();
      email_address_flow.setLayout((new FlowLayout(FlowLayout.LEFT)));
      
      
      JLabel  first_name_label = new JLabel("First Name : ", JLabel.LEFT); 
       JTextField first_name_field = new JTextField(10); 
      
      JLabel  last_name_label = new JLabel("Last Name : ", JLabel.LEFT); 
       JTextField last_name_field = new JTextField(10); 
      
      JLabel  birthdate_label = new JLabel("Birthdate : ", JLabel.LEFT); 
       JTextField date_field = new JTextField(2); 
      
       JTextField month_field = new JTextField(2); 
     
       JTextField year_field = new JTextField(4);
      
      JLabel  phone_number_label = new JLabel("Phone Number : ", JLabel.LEFT); 
       JTextField phone_number_field = new JTextField(12);
      
      JLabel  street_address_label = new JLabel("Street Address : ", JLabel.LEFT); 
       JTextField street_address_field = new JTextField(12); 
      
      JLabel  city_address_label = new JLabel("City Address : ", JLabel.LEFT); 
       JTextField city_address_field = new JTextField(12); 
      
      JLabel  postal_code_label = new JLabel("Postal Code : ", JLabel.LEFT); 
       JTextField postal_code_field = new JTextField(6); 
      
      JLabel  email_address_label = new JLabel("Email Address : ", JLabel.LEFT); 
       JTextField email_address_field = new JTextField(15); 
      
      firstNameField        =   first_name_field;
      lastNameField         =   last_name_field;
      dateField             =   date_field;
      monthField            =   month_field;
      yearField             =   year_field;
      phoneNumberField      =   phone_number_field;
      streetAddressField    =   street_address_field;
      cityAddressField      =   city_address_field;
      postalCodeField       =   postal_code_field;
      emailAddressField     =   email_address_field;
      
      first_name_flow.add(first_name_label);
      first_name_flow.add(first_name_field);
      last_name_flow.add(last_name_label);
      last_name_flow.add(last_name_field);

      birthdate_flow.add(birthdate_label);
      birthdate_flow.add(date_field);
      birthdate_flow.add(month_field);
      birthdate_flow.add(year_field);
      
      phone_number_flow.add(phone_number_label);
      phone_number_flow.add(phone_number_field);
      street_address_flow.add(street_address_label);
      street_address_flow.add(street_address_field);
      city_address_flow.add(city_address_label);
      city_address_flow.add(city_address_field);
      postal_code_flow.add(postal_code_label);
      postal_code_flow.add(postal_code_field);
      email_address_flow.add(email_address_label);
      email_address_flow.add(email_address_field);
                  
      customer_info.add(first_name_flow);
      customer_info.add(last_name_flow);
      customer_info.add(birthdate_flow);
      customer_info.add(phone_number_flow);
      customer_info.add(street_address_flow);
      customer_info.add(city_address_flow);
      customer_info.add(postal_code_flow);
      customer_info.add(email_address_flow);

      JPanel spacer_layout = new JPanel();
      spacer_layout.setLayout(new FlowLayout());
      spacer_layout.add(customer_info);
      
      lowerPanel.add(spacer_layout);     
      mainFrame.setVisible(true);  
   }
   
    /**
     * Method actionButton to construct the button
     *
     */
    private void actionButton(){
        
      JButton addCButton = new JButton("Add Customer");
      JButton addAButton = new JButton("Add Account");
      JButton deleteButton = new JButton("Delete Account");
      JButton loadCustomerButton = new JButton("Load Customer");
      
      JButton loadFromFile = new JButton("Load from file");
      JButton saveToFile = new JButton("Save to File");
      
      loadFromFile.addActionListener(new TellerHandler("loadfile", this));
      saveToFile.addActionListener(new TellerHandler("savefile", this));

      addCButton.addActionListener(new TellerHandler("addc", this));

      addAButton.addActionListener(new TellerHandler("adda", this));
      
      deleteButton.addActionListener(new TellerHandler("delete", this));
      
      loadCustomerButton.addActionListener(new TellerHandler("loadcustomer", this));
      
      JPanel actionPanel = new JPanel();
      actionPanel.setLayout(new GridLayout(4,2));

      actionPanel.add(addCButton);
      actionPanel.add(addAButton);
      actionPanel.add(deleteButton);
      actionPanel.add(loadCustomerButton);    
      
      actionPanel.add(loadFromFile);
      actionPanel.add(saveToFile);
      
      lowerPanel.add(actionPanel); 
      mainFrame.setVisible(true);  
   }
      
   public JTextField getCustomerIdField(){
       return customerIdField;
   }
   
   public JTextField getAmountField(){
       return amountField;
   }
   
   public JTextField getInvestmentTermField(){
       
       return investTermField;
   }
   
   public JTextField getCreditLimitField(){
              
       return creditLimitField;
    }
    
   public JPanel getInvestmentTermFlow(){
       
       return investTermFlow;
   }
  
   public JPanel getCreditLimitFlow(){
       
       return creditLimitFlow;
    }
}   