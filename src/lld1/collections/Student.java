package lld1.collections;

public class Student implements Comparable<Student> {
    private int id;
    private int age;
    private String name;

    public Student(int id, int age, String name, double psp) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.psp = psp;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getPsp() {
        return psp;
    }

    private double psp;


    // We want to have the natual ordering for a leaderboard
    @Override
    public int compareTo(Student other) {
        if(this.getPsp() == other.getPsp()){
            return 0;
        }

        if(this.getPsp() < other.getPsp()){
            // |other .. this|
            return 1;
        }

        return -1;
    }

    /*
    * this <-> other
    *
    * < 0 -> current object is smaller than the other object -> | this ... other |
    * =0 -> both students are equal -> | this ... other | or | other ... this |
    * > 0 -> current object is greater than the other object -> |other ... this|
    * */

}
