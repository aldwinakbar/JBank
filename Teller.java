import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
import java.math.*;
import java.awt.*;  // Using Frame class in package java.awt

/**
 * The main class that contain the entry point of the JBank program. 
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */
public class Teller
{
    /**
     * Main method in Teller class, as the entry point of the JBank program
     * 
     * @param  args     
     */

    public static void main(String[] args) {
        Bank.setStartTime(9,10);
        Bank.setCloseTime(22,10);
        System.out.println("Working Hours");
        System.out.println(Bank.getHoursOfOperation());
        
        TellerGUI TellerLayout = new TellerGUI();
        ATMGUI ATMGuiLayout = new ATMGUI();
    }
}
