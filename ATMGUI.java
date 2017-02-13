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
 * The GUI class of the ATM for customer to withdraw or deposit their money
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class ATMGUI extends JPanel{

    private JFrame mainFrame;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JTextField customerIdField;
    private JTextField amountField;
    private JTextArea infoArea;
    private char accoutType = 'S';

    /**
     * ATMGUI Constructor, this call the every method thats responsible to generate each ATM GUI component
     *
     */
    public ATMGUI(){
        buildGUI();
        this.customerIdField();
        this.accountTypeRadio();
        this.amountField();
        this.infoTextArea(); 
        this.transactionButton();
    }

    /**
     * Method buildGUI to create the main frame of the ATM GUI
     *
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

    /**
     * Method accountTypeRadio handle the GUI of the account radio button.
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

        radioPanel.add(radSavings);
        radioPanel.add(radInvestment);
        radioPanel.add(radLOC);
        radioPanel.add(radOverdraft); 
        upperPanel.add(radioPanel);

        mainFrame.setVisible(true);  
    }

    /**
     * Method customerIdField handles the GUI of the customer ID field
     *
     */
    private void customerIdField(){

        JLabel  customer_label= new JLabel("Enter Customer ID: ", JLabel.CENTER); 
        final JTextField customer_field = new JTextField(6); 
        customerIdField = customer_field;

        upperPanel.add(customer_label);
        upperPanel.add(customer_field);

        mainFrame.setVisible(true);  
    }

    /**
     * Method amountField handles the GUI of the amount field
     *
     */
    private void amountField(){

        JLabel  amount_label= new JLabel("Enter amount here: ", JLabel.LEFT);
        final JTextField amount_field = new JTextField(6); 
        amountField = amount_field;

        upperPanel.add(amount_label);
        upperPanel.add(amount_field);

        mainFrame.setVisible(true);  
    }

    /**
     * Method infoTextArea is to handle TextArea if the info
     *
     */
    private void infoTextArea(){
        JTextArea text_area = new JTextArea(5, 5);
        JScrollPane scrollPane = new JScrollPane(text_area);    
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        infoArea = text_area;

        lowerPanel.add(scrollPane);     
        mainFrame.setVisible(true);  
    }

    /**
     * Method transactionButton is to handle the transaction button
     *
     */
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

    /**
     * Method appendToInfoArea to append a string in TextArea
     *
     * @param input_string A parameter that will be appended to the TextArea
     */
    public void appendToInfoArea(String input_string){

        infoArea.append(input_string);
    }

    /**
     * Method getAccountRadio to get the accountType from radio button
     *
     * @return The return value is the accountType in char
     */
    public char getAccountRadio(){

        return accoutType;
    }

    /**
     * Method getCustomerIdField to get the customer field
     *
     * @return The return value is a JTextField
     */
    public JTextField getCustomerIdField(){
        return customerIdField;
    }

    /**
     * Method getAmountField to get the amount field
     *
     * @return The return value is a JTextField
     */
    public JTextField getAmountField(){
        return amountField;
    }

    /**
     * Method getInfoArea to get info area field
     *
     * @return The return value is a JTextArea
     */
    public JTextArea getInfoArea(){
        return infoArea;
    }
}