import java.sql.Array;
import java.util.ArrayList;

public class StringHelper {

    public static BracketsPair calcBrackets(String str)
    {
        var len = str.length();
        int r = 0, l = 0;
        for (int i = 0; i < len; i++)
        {
            if (str.charAt(i) == ')')
            {
                r++;
            }

            if (str.charAt(i) == '(')
            {
                l++;
            }
        }

        return new BracketsPair(l, r);
    }

    public static Indicator calcIndexes(String str)
    {
        var len = str.length();
        var li = new ArrayList<Integer>();
        var ri = new ArrayList<Integer>();
        for (int i = 0; i < len; i++)
        {
            if (str.charAt(i) == ')')
            {
                ri.add(i);
            }

            if (str.charAt(i) == '(')
            {
                li.add(i);
            }
        }

        return new Indicator(li, ri);

    }

    public static void start(String str)
    {
        var lst_bracket = calcIndexes(str);

        for (var item_l : lst_bracket.getLeft())
        {
            for (var item_r : lst_bracket.getRight())
            {
                if (item_l < item_r)
                {
                    var cnt_brackets = calcBrackets(str.substring(item_l + 1, item_r));

                    if (cnt_brackets.isZero())
                    {
                       System.out.println(change(str.substring(item_l + 1, item_r)));
                    }
                }
            }
        }
    }

    public static String change(String text)
    {
        var l = text.length();
        for (int i = 0; i <= 9; i++)
        {
            text = text.replace((char)('0' + i), '#');
        }
        return text;
    }
}
