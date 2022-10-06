import java.util.List;
import java.util.stream.Collectors;

public class Indicator {
    private List<Integer> left;
    private List<Integer> right;

    public List<Integer> getLeft() {
        return left;
    }

    public void setLeft(List<Integer> left) {
        this.left = left.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getRight() {
        return right;
    }

    public void setRight(List<Integer> right) {
        this.right = right.stream().sorted().collect(Collectors.toList());
    }

    public Indicator(List<Integer> left, List<Integer> right) {
        this.left = left.stream().sorted().collect(Collectors.toList());
        this.right = right.stream().sorted().collect(Collectors.toList());
    }
}
