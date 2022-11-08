import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixReader {
    public static ArrayList<ArrayList<Double>> readMatrix(String path) throws FileNotFoundException {
        // read in the data
        ArrayList<ArrayList<Double>> a = new ArrayList<ArrayList<Double>>();
        Scanner input = new Scanner(new File(path));
        while(input.hasNextLine())
        {
            Scanner colReader = new Scanner(input.nextLine());
            ArrayList col = new ArrayList();
            while(colReader.hasNextDouble())
            {
                col.add(colReader.nextDouble());
            }
            a.add(col);
        }

        return a;
    }
}
