import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTests {
    @Test
    void firstRegexTest() throws FileNotFoundException {
        File text = new File("text.txt");
        var sb = new StringBuilder();
        Scanner scnr = new Scanner(text);

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            sb.append(line);
        }

        var res = StringHelper.start(sb.toString());
        assertTrue(res.equals("hello world my name is edik _ petro i am _ software engineer _ from _ epam system half _ houra _ _ _ _ _ _ _"));
    }

    @Test
    void secondRegexTest() throws FileNotFoundException {
        String str = "an an an a";
        var res = StringHelper.start(str);
        assertTrue(res.equals("_ _ _ _"));
    }

    @Test
    void thirdRegexTest() throws FileNotFoundException {
        String str = "an inan an ina";
        var res = StringHelper.start(str);
        assertTrue(res.equals("_ inan _ ina"));
    }

    @Test
    void fourthRegexTest() throws FileNotFoundException {
        String str = "(an inan an ina)";
        var res = StringHelper.start(str);
        System.out.println(res);
        assertTrue(res.equals("(_ inan _ ina)"));
    }
}
