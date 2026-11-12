import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NumberComparerTest {
    @Test
    public void testNumber_1() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(6, 5);
        assertEquals(true, result);
    }
    @Test
    public void testNumber_2() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(10, 5);
        assertEquals(true, result);
    }
    @Test
    public void testNumber_3() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(2, 8);
        assertEquals(false, result);
    }
    @Test
    public void testNumber_4() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(7, 7);
        assertEquals(false, result);
    }
    
}
