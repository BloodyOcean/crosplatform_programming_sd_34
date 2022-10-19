import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("text.txt");
        var sb = new StringBuilder();
        Scanner scnr = new Scanner(text);

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            sb.append(line);
        }

        var res = StringHelper.start(sb.toString());

        System.out.println(res);
    }
}
