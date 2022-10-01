public class StringHelper {

    public static String change(String text)
    {
        var l = text.length();
        for (int i = 0; i <= 9; i++)
        {
            text = text.replace((char)('0' + i), '#');
        }
        return text;
    }
    public static String calc(String text)
    {
        var l = text.length();
        for (int i = 0; i < l; i++)
        {
            if (text.charAt(i) == '(')
            {
                for (int j = text.length() - 1; j > i; j--)
                {
                    if (text.charAt(j) == ')')
                    {
                        var substring = text.substring(i + 1, j);
                        System.out.println("[DEPTH]:" + substring);

                        return calc(substring);
                    }

                }

                return null;
            }
        }
        return text;
    }
}
