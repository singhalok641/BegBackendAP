package lld1.designPatterns.prototype;

public class Client {

    private static final StudentRegistry studentRegistry = new StudentRegistry();
    public static void main(String[] args) {
        fillRegistry();

        Student prototype = studentRegistry.get("September24APBeginner");

        Student malideedu = prototype.clone();
        malideedu.setName("Malideedu");
        malideedu.setAge(25);
        malideedu.setPsp(94);

        Student rajat = prototype.clone();
        rajat.setPsp(93);
        rajat.setName("Rajat");
        rajat.setAge(24);

        Student intelligentPrototype = studentRegistry.get("feb25APBeginner");
        Student guru = intelligentPrototype.clone();
        guru.setName("Guru");
        guru.setAge(30);
        guru.setPsp(96);


        System.out.println("DEBUG");
    }

    public static void fillRegistry(){
        Student sep24ApBeginner = new Student();
        sep24ApBeginner.setBatch("September24APBeginner");
        sep24ApBeginner.setAvgBatchPsp(87.84);
        studentRegistry.register("September24APBeginner", sep24ApBeginner);

        Student feb25ApBeginner = new IntelligentStudent();
        feb25ApBeginner.setBatch("feb25APBeginner");
        feb25ApBeginner.setAvgBatchPsp(89);
        studentRegistry.register("feb25APBeginner", feb25ApBeginner);
    }
}
