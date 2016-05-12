import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class ButtonHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonHandler implements ActionListener {
    
    private ATMGUI transactionGUI;
    private JTextField customerField;
    private JTextField amountField;
    private String actionType;
    private JTextArea infoArea;
    
    public ButtonHandler(String action_type, ATMGUI input_gui ) {
        customerField = input_gui.getCustomerIdField();
        amountField = input_gui.getAmountField();
        actionType  = action_type;
        transactionGUI = input_gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent buttonClicked) {
        if(actionType.equals("deposit")){
            try{
            Bank.getCustomer(Integer.parseInt(customerField.getText())).getAccount(transactionGUI.getAccountRadio()).deposit(Integer.parseInt(amountField.getText()));
              transactionGUI.appendToInfoArea(customerField.getText() + " saves an amount of money: "+ amountField.getText() + "\n");
            }
            
            catch (AccountTypeNotFoundException e){
                transactionGUI.appendToInfoArea(customerField.getText()+ " " + e.getMessage() +"\n");
            }
            
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
                   
        }
        
        else if(actionType.equals("total")){
           try{
           JOptionPane.showMessageDialog(null, customerField.getText() + " now have: "+ Bank.getCustomer(Integer.parseInt(customerField.getText())).getAccount(transactionGUI.getAccountRadio()).getBalance());
           }
           
            catch (AccountTypeNotFoundException e){
                JOptionPane.showMessageDialog(null, customerField.getText()+ " " + e.getMessage() );
       
            }
             catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
                   
            
        }
        
        
        else if(actionType.equals("withdraw")){
           try{
               Bank.getCustomer(Integer.parseInt(customerField.getText())).getAccount(transactionGUI.getAccountRadio()).withdraw(Integer.parseInt(amountField.getText())) ;
               transactionGUI.appendToInfoArea(customerField.getText() + " withdraws an amount of money: "+ amountField.getText() + "\n");
            }
            
            catch (AmountOverDrawnException e){
               transactionGUI.appendToInfoArea(e.getMessage()+"\n");
            }
             catch (AccountTypeNotFoundException e){
                transactionGUI.appendToInfoArea(customerField.getText() + " " + e.getMessage() +"\n");
            }            
             catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
                   
        }
    }
}