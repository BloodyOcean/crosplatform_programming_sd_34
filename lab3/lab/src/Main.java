import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IManager fm = new FirstManager();
        IManager sm = new SecondManager();

        fm.readFromFile("film.json");

        sm.readFromFile("film2.json");

        fm.print();

        sm.print();
    }
}
