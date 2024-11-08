package lld1.ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Doer {

    public void fetchStudentInfo(int roll_no){ // -1
        // Code that fetches the student data
    }

    // There are 2 types of exceptions
    /*
    * 1. Checked Exceptions -> Compile-time exceptions
    *    FileNotFoundException, IOException
    * 2. Unchecked Exceptions
    *   NullPointerException, ArrayIndexOutOfBoundsException
    *
    * */

    public void readFile() throws FileNotFoundException {
        File file = new File("hello.txt");
        Scanner reader = new Scanner(file);
    }

    public void divide(int a, int b){
        if(b == 0) {
            System.out.println();
            return;
        }
        int res = a / b; // Risk of division by zero (unchecked)
    }


    // handling exceptions using try-catch block
    // Purpose?
    // -> Wrap your risky code in a try block
    // -> Use catch block/s to specify how to handle various exceptions that might occur within your try block

//    try{
//        // code that may throw an exception
//    } catch(Exception ex){
//        // handle the exception
//    }

    public void readData(){
        try {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);

            // Some code which can throw SQLException
            throw new SQLException();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found. Please check the file path.");
        }
        catch (SQLException ex) {
            System.out.println("Problem connection to SQL Server");
        }
    }
}
