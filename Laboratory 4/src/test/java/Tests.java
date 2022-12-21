import org.example.Calculating;
import org.example.Input;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Tests {
    @Test
    public void Test1() {
        Input i = new Input(0, 0, 0, 1, 1, 1, 1, 1, 1, -3);
        i.lang = "ukrainian";
        Calculating c = new Calculating(i);
        assertSame(c.check(), "Пряма перпендикулярна до площини");
    }
    @Test
    public void Test2() {
        Input i = new Input(2, 3, 4, 1, 0, 1, 1, 1, -1, 10);
        i.lang = "ukrainian";
        Calculating c = new Calculating(i);
        assertSame(c.check(), "Пряма паралельна до площини");
    }
    @Test
    public void Test3() {
        Input i = new Input(20, -3, 43, 14, 11, 3, 1, 2, 3, 10);
        i.lang = "ukrainian";
        Calculating c = new Calculating(i);
        assertSame(c.check(), "Пряма перетинає площину");
    }
}