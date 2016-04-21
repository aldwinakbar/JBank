import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
import java.math.*;

public class ATMGUI extends JPanel{

   private JFrame mainFrame;
   private JPanel upperPanel;
   private JPanel lowerPanel;
   private JTextField customerIdField;
   private JTextField amountField;
   private JTextArea infoArea;
   private char accoutType = 'S';
   
   public ATMGUI(){
      buildGUI();
      this.customerIdField();
      this.accountTypeRadio();
      this.amountField();
      this.infoTextArea(); 
      this.transactionButton();
   }

   /*
   public static void main(String[] args){
      
      String first_name = "Aldwin";
          String last_name = "Hermanudin";
          int year = 1995;
          int month = 11 - 1;
          int day = 20;
          Customer new_customer = new Customer(first_name,last_name, ( new GregorianCalendar(year, month, day).getTime()));
          
          Savings new_savings_account = new Savings(new_customer,500);
          new_savings_account.addDailyInterest(280);
          
          Investment new_investment_account = new Investment(new_customer, 1000, 6);
          new_investment_account.addDailyInterest(280);
          
          OverDraftProtection new_odf_account = new OverDraftProtection(new_customer,500, new_savings_account);
          LineOfCredit new_loc_account = new LineOfCredit(new_customer, 500, 100);
          
          System.out.println("Savings account after 280 days");
          System.out.println(new_savings_account.getBalance());
          
          System.out.println("Savings investment after 280 days");
          System.out.println(new_investment_account.getBalance());
          
          System.out.println((Bank.addCustomer(new_customer)) ? "Customer created\n":"Failed to create customer\n");
          int counter_customer = 1001;
          char account_type_char;
          System.out.println( " Add Savings " + new_customer.addAccount(new_savings_account));
          System.out.println( " Add Investment " + new_customer.addAccount(new_investment_account));
          System.out.println( " Remove Investment " + new_customer.removeAccount('I'));
          System.out.println( " Add Investment " + new_customer.addAccount(new_investment_account));
          System.out.println( " Add ODF " + new_customer.addAccount(new_odf_account));
          System.out.println( " Add LOC " + new_customer.addAccount(new_loc_account));          
          System.out.println( " Savings vs investmen : " + (new_savings_account.getClass().equals(new_investment_account.getClass())));
          if(Bank.getCustomer(counter_customer) != null){
                          System.out.println("Here are your account information");
                          System.out.println("Name          : "+Bank.getCustomer(counter_customer).getCustomerName());
                          System.out.println("Date of birth : "+Bank.getCustomer(counter_customer).getDateOfBirth());
                          System.out.println("Phone number  : "+Bank.getCustomer(counter_customer).getPhoneNumber());
                          System.out.println("Address       : "+Bank.getCustomer(counter_customer).getAddress());
                          System.out.println("Email Address : "+Bank.getCustomer(counter_customer).getEmail());
                          account_type_char = 'S';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : Savings");
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                          account_type_char = 'O';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : OverDraft");
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                          account_type_char = 'I';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : Investment");
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
                          account_type_char = 'C';
                          if (Bank.getCustomer(counter_customer).getAccount(account_type_char) != null){
                            System.out.println("Account type  : Credit");
                            System.out.println("Balance       : "+Bank.getCustomer(counter_customer).getAccount(account_type_char).getBalance());
                          }
          }
      
      ATMGUI ATMGuiLayout = new ATMGUI();
    }
    */
   
   private void buildGUI(){
      mainFrame = new JFrame("ATMGuiLayout");
      mainFrame.setSize(500,500);
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
       
      radioPanel.add(radSavings);
      radioPanel.add(radInvestment);
      radioPanel.add(radLOC);
      radioPanel.add(radOverdraft); 
      upperPanel.add(radioPanel);

      mainFrame.setVisible(true);  
   }
   
   private void customerIdField(){

      JLabel  customer_label= new JLabel("Enter Customer ID: ", JLabel.CENTER); 
      final JTextField customer_field = new JTextField(6); 
      customerIdField = customer_field;
      
      upperPanel.add(customer_label);
      upperPanel.add(customer_field);
      
      mainFrame.setVisible(true);  
   }
   
   private void amountField(){
         
      JLabel  amount_label= new JLabel("Enter amount here: ", JLabel.LEFT);
      final JTextField amount_field = new JTextField(6); 
      amountField = amount_field;
      
      upperPanel.add(amount_label);
      upperPanel.add(amount_field);
   
      mainFrame.setVisible(true);  
   }
   
      private void infoTextArea(){
      JTextArea text_area = new JTextArea(5, 5);
      JScrollPane scrollPane = new JScrollPane(text_area);    
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      infoArea = text_area;

      lowerPanel.add(scrollPane);     
      mainFrame.setVisible(true);  
   }
   
    private void transactionButton(){
      JButton depositButton = new JButton("Deposit");        
      JButton withdrawButton = new JButton("Withdraw");
      JButton totalButton = new JButton("Total");
      JButton exitButton = new JButton("Exit");
      
      depositButton.addActionListener(new ButtonHandler("deposit", this));

      withdrawButton.addActionListener(new ButtonHandler("withdraw", this));
      
      totalButton.addActionListener(new ButtonHandler("total", this));
      
      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String ObjButtons[] = {"Yes","No"};
                    int PromptResult = JOptionPane.showOptionDialog(null,"You are exitting, goodbye!","JBank",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
                    if(PromptResult==JOptionPane.YES_OPTION)
                    {
                        System.exit(0);
                    }
         }
      });
      
      JPanel transactionPanel = new JPanel();
      transactionPanel.setLayout(new GridLayout(4,1));

      transactionPanel.add(depositButton);
      transactionPanel.add(withdrawButton);
      transactionPanel.add(totalButton);
      transactionPanel.add(exitButton);       
      lowerPanel.add(transactionPanel); 
      mainFrame.setVisible(true);  
   }
      
   public void appendToInfoArea(String input_string){
              
       infoArea.append(input_string);
    }
    
   public char getAccountRadio(){
       
       return accoutType;
    }

   public JTextField getCustomerIdField(){
       return customerIdField;
    }
   public JTextField getAmountField(){
       return amountField;
    }
   public JTextArea getInfoArea(){
       return infoArea;
    }
}