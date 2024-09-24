package lld1.oops2_accessModifiers_constructors;

public class Main {
    public static void main(String[] args) {

//        Student s1 = new Student();
//        // class name, object name, new keyword, call the constructor
//        // rank is accessible because it is public
//        s1.rank = 5;
//
//        // roll no is accessible because it is default
//        s1.rollNo = 35;
//        s1.printDetails();



        // name is private
//        s.name = "Malideedu";

        Student s2 = new Student(1, "Alok", 5);
        s2.printDetails();




    }
}

// .java -> .class -> bytecode -> runs
// Main.java -> Main.class ->
