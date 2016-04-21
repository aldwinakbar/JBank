import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * Write a description of class CustomerFileWriter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CustomerFileWriter
{
    // instance variables - replace the example below with your own
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    
    public void saveCustomer(SortedSet<Customer> customers){
  
      try {

         // create a new file with an ObjectOutputStream
         fileOutputStream = new FileOutputStream("customer_data.jbank");
         objectOutputStream = new ObjectOutputStream(fileOutputStream);

         // write something in the file
         objectOutputStream.writeObject(customers);
         // close the stream
         objectOutputStream.close();
         fileOutputStream.close();

      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }
    
    /**
     * Constructor for objects of class CustomerFileWriter
     */
    public CustomerFileWriter()
    {
    
    }
}
