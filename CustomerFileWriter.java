import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * Class to write the SortedSet of the Customer from the Bank class
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class CustomerFileWriter
{
    // instance variables - replace the example below with your own
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    /**
     * Method saveCustomer to save the SortedSet in the parameter to a file.
     *
     * @param customers A parameter for the given SortedSet data
     */
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
    public CustomerFileWriter(){

    }
}
