import java.util.Date;
import java.util.Calendar;
import java.util.*;

/**
 * Write a description of class Investment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Investment extends Savings
{
    // instance variables - replace the example below with your own
    private Date startDate;
    private Date endDate;
    private int term;
    private double interestRate;
    /**
     * Constructor for objects of class Investment
     */
    public Investment(Customer savings_customer, double amount, int term_in_month)
    {
        super(savings_customer, amount);
        if (term_in_month < 6){
            term = 6;
        }
        else {
            term = term_in_month;
        }
        
        Calendar s = new GregorianCalendar();
        startDate = s.getTime();
        s.add(Calendar.MONTH, term);
        endDate = s.getTime();
    }
    
     public boolean withdraw(double amount) {
    
        double balance_temp = balance;
        double withdraw_result = balance_temp-amount;
        Calendar s = new GregorianCalendar();
        if(withdraw_result >=0){
            balance = withdraw_result;
            return true;
        }
        else if (s.getInstance().before(endDate)){
            return false;            
        }
        else{
            return false;
        }
    }

    
    public void addDailyInterest(int days){
        double days_to_years = days/365;
        double r = interestRate;
        double f = balance * Math.pow(1 + (r / 365), 365*days);
        interestEarned = f- balance;
        balance = f;
    }
}
