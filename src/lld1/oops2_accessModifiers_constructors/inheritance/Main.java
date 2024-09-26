package lld1.oops2_accessModifiers_constructors.inheritance;

public class Main {
    public static void main(String[] args) {
        Instructor instructor = new Instructor();

        // specific to instructor class
        instructor.batchName = "AP Batch";
        instructor.avgRating = 4.9;
        instructor.scheduleClass();

        // inherited from the parent class(User)
        instructor.username = "Alok";
        instructor.login();

    }
}
