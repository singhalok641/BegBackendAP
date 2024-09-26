package lld1.oops2_accessModifiers_constructors.inheritance;


// extends is a keyword in java that is used to create a child class
public class Instructor extends User{
    String batchName;
    double avgRating;

    void scheduleClass(){
        System.out.println("Scheduled a new class ...");
    }


}
