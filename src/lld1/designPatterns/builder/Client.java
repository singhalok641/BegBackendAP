package lld1.designPatterns.builder;

public class Client {
    public static void main(String[] args) {

        // I want to create a Student object
//        Student.StudentBuilder studentBuilder = Student.getStudentBuilder();
//
//        studentBuilder.setAge(27);
//        studentBuilder.setName("Alok");
//        studentBuilder.setPsp(99);
//        studentBuilder.setGradYear(2019);
//        studentBuilder.setRollNumber(21);
//
//        Student student = studentBuilder.build();

        Student student = Student.getStudentBuilder()
                .setName("Alok")
                .setAge(27)
                .setPsp(99.0)
                .setRollNumber(21)
                .setBatch("September AP")
                .setGradYear(2029)
                .setUnivName("TU")
                .build();

        System.out.println("DEBUG");
    }
}
