package lld1.oops2_accessModifiers_constructors;

public class Student {
    int rollNo;
    private String name;
    public int rank;

    // No Args constructor. not a default constructor
    public Student(){
    }

    // Manual/Parameterized cons
    public Student(int sRollNo, String sName, int sRank){
        System.out.println("DEBUG");
        rollNo = sRollNo;
        name = sName;
        rank = sRank;
    }

    void printDetails(){
        System.out.println("Students details : ");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name : " + name);
        System.out.println("Rank : " + rank);
    }
}
