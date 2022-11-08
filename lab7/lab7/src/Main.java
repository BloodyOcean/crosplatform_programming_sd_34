import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var res = MatrixReader.readMatrix("input.txt");
        System.out.println(res);
    }
}
