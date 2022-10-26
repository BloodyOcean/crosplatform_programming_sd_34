import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScopesTests {

    @Test
    void simpleTestScopes() {
        var res = StringHelper.start("(five 5!!)");
        assertTrue(res.size() == 1 && res.get(0).equals("five #!!"));
    }

    @Test
    void deepTwoTestScopes() {
        var res = StringHelper.start("(fi(ve 5)!!)");
        assertTrue(res.size() == 1 && res.get(0).equals("ve #"));
    }

    @Test
    void multipleScopesTest() {
        var res = StringHelper.start("(hello)(world)(hi)");
        assertTrue(res.size() == 3 &&
                res.get(0).equals("hello") &&
                res.get(1).equals("world") &&
                res.get(2).equals("hi"));
    }

    @Test
    void multipleScopesDeepWithNumbersTest() {
        var res = StringHelper.start("(h(e2l)(l3o))(wo(r4l)d)((h5i))");
        assertTrue(res.size() == 4 &&
                res.get(0).equals("e#l") &&
                res.get(1).equals("l#o") &&
                res.get(2).equals("r#l") &&
                res.get(3).equals("h#i"));
    }

}
