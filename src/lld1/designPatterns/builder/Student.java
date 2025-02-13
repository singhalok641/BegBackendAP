package lld1.designPatterns.builder;

public class Student {
    private String name;
    private int age;
    private double psp;
    private String batch;
    private int gradYear;
    private String univName;
    private int rollNumber;
    private String address;


    private Student(StudentBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.batch = builder.batch;
        this.gradYear = builder.gradYear;
        this.rollNumber = builder.rollNumber;
        this.psp = builder.psp;
    }

    public static StudentBuilder getStudentBuilder(){
        return new StudentBuilder();
    }


    // Internal class
     static class StudentBuilder {
        private String name;
        private int age;
        private double psp;
        private String batch;
        private int gradYear;
        private String univName;
        private int rollNumber;
        private String address;

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public StudentBuilder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public StudentBuilder setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            // start validation
            if(this.getGradYear() >= 2024){
                throw new RuntimeException("Grad year should be less than 2024");
            }

            // end validation

            return new Student(this);
        }
    }
}
