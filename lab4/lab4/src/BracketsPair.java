import java.util.Objects;

public class BracketsPair {
    private int left;
    private int right;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public boolean isZero()
    {
        return this.left == 0 && this.right == 0;
    }

    public boolean isPair()
    {
        return this.left == this.right;
    }

    public BracketsPair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BracketsPair that = (BracketsPair) o;
        return left == that.left && right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
