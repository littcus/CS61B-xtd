import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {


    @Test
    public void testEqualChars() {

        OffByN N1 = new OffByN(5);
        boolean test1 = N1.equalChars('a', 'f');
        assertTrue(test1);
        assertTrue(N1.equalChars('f', 'a'));
        assertFalse(N1.equalChars('f', 'h'));


        OffByN N2 = new OffByN(2);
        assertTrue(N2.equalChars('a', 'c'));
        assertFalse(N2.equalChars('b', 'x'));

    }
}


