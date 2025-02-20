package lld1.designPatterns.prototype;

public class IntelligentStudent extends Student{
    private int iq;

    IntelligentStudent() {

    }

    IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }
}
