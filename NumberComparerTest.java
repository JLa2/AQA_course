import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        boolean result=x.compare(2, 1);
        assertEquals(true, result);
    }
     @Test
    public void testNumber_3() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(7, 8);
        assertEquals(false, result);
    }
     @Test
    public void testNumber_4() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(-1, 3);
        assertEquals(false, result);
    }
    
}
