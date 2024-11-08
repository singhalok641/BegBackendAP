package lld1.ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Attempting to open a file");
            File file = new File("db.txt");
            Scanner scanner = new Scanner(file);
            return;
        }
        catch (FileNotFoundException ex){
            System.out.println("File not found");

        }
        finally {
            // clean any resources
            // closing a file
            // closing a network connection
            System.out.println("closing resources");
        }
    }
}
