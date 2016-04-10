import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMGUI extends JPanel{

   private JFrame mainFrame;
   //private JLabel headerLabel;
   //private JLabel statusLabel;
   //private JPanel controlPanel;
   private JPanel upperPanel;
   private JPanel lowerPanel;
   
   public ATMGUI(){
      buildGUI();
   }

   public static void main(String[] args){
      ATMGUI ATMGuiLayout = new ATMGUI();
      ATMGuiLayout.customerIdField();
      ATMGuiLayout.accountTypeRadio();
      ATMGuiLayout.amountField();
      ATMGuiLayout.showTextAreaDemo(); 
      ATMGuiLayout.transactionButton();
   }

   private void buildGUI(){
      mainFrame = new JFrame("ATMGuiLayout");
      mainFrame.setSize(500,500);
      mainFrame.setLayout(new GridLayout(2, 1));     

      //statusLabel.setSize(350,100);
      
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
      
      //controlPanel = new JPanel();
      //controlPanel.setLayout(new FlowLayout());
      
      upperPanel = new JPanel();
       upperPanel.setLayout(new GridLayout(1,5));
       
       lowerPanel = new JPanel();
       lowerPanel.setLayout(new GridLayout(1,2));
       
       
      
      mainFrame.add(upperPanel);
      mainFrame.add(lowerPanel);
      //mainFrame.add(controlPanel);
      mainFrame.setVisible(true);  
   }

     private void accountTypeRadio(){
         
      final JRadioButton radSavings = new JRadioButton("Savings", true);
      final JRadioButton radInvestment = new JRadioButton("Investment");
      final JRadioButton radLOC = new JRadioButton("Line Of Credit");
      
      final JRadioButton radOverdraft = new JRadioButton("Overdraft");
      
      /*
      radApple.setMnemonic(KeyEvent.VK_C);
      radMango.setMnemonic(KeyEvent.VK_M);
      radPeer.setMnemonic(KeyEvent.VK_P);

      radApple.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {         
            statusLabel.setText("Apple RadioButton: " 
            + (e.getStateChange()==1?"checked":"unchecked"));
         }           
      });

      radMango.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {             
            statusLabel.setText("Mango RadioButton: " 
            + (e.getStateChange()==1?"checked":"unchecked")); 
         }           
      });

      radPeer.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {             
            statusLabel.setText("Peer RadioButton: " 
            + (e.getStateChange()==1?"checked":"unchecked"));
         }           
      });
      */

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

      JPanel wrapper = new JPanel( new FlowLayout(FlowLayout.CENTER));

      JLabel  namelabel= new JLabel("Enter Customer ID: ", JLabel.CENTER); 
      wrapper.add(namelabel);
      final JTextField userText = new JTextField(6); 
      wrapper.add(userText);
      upperPanel.add(wrapper);
      
      mainFrame.setVisible(true);  
   }
   
   private void amountField(){
         
      JLabel  namelabel= new JLabel("Enter amount here: ", JLabel.LEFT);
     
      final JTextField userText = new JTextField(6); 


      upperPanel.add(namelabel);
      upperPanel.add(userText);
      mainFrame.setVisible(true);  
   }
   
      private void showTextAreaDemo(){
      JTextArea textArea = new JTextArea(5, 5);

      JScrollPane scrollPane = new JScrollPane(textArea);    

      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      lowerPanel.add(scrollPane);     
      mainFrame.setVisible(true);  
   }
   
    private void transactionButton(){
      JButton depositButton = new JButton("Deposit");        
      JButton withdrawButton = new JButton("Withdraw");
      JButton exitButton = new JButton("Exit");
      exitButton.setHorizontalTextPosition(SwingConstants.LEFT);   

      depositButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        //    statusLabel.setText("Ok Button clicked.");
         }          
      });

      withdrawButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        //    statusLabel.setText("Submit Button clicked.");
         }
      });

      exitButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        //    statusLabel.setText("Cancel Button clicked.");
         }
      });
      
         JPanel transactionPanel = new JPanel();
       transactionPanel.setLayout(new GridLayout(3,1));

      transactionPanel.add(depositButton);
      transactionPanel.add(withdrawButton);
      transactionPanel.add(exitButton);       
      lowerPanel.add(transactionPanel); 
      mainFrame.setVisible(true);  
   }
}