package lld1.generics.tripletExample;

public class Triplet<TYPE> {
    private TYPE left;
    private TYPE right;
    private TYPE middle;

    public Triplet(TYPE left, TYPE right, TYPE middle) {
        this.left = left;
        this.right = right;
        this.middle = middle;
    }

    public TYPE getLeft() {
        return left;
    }

    public TYPE getRight() {
        return right;
    }

    public TYPE getMiddle() {
        return middle;
    }
}
