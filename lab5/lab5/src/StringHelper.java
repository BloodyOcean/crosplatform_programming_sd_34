import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    private static final String regex = "\\b(a|an|or|the|on|in|out|are)\\b";
    public static String start(String str)
    {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        return matcher.replaceAll("_");
    }
}
