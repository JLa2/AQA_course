import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NumberComparerTest {
    @Test
    public void testNumber() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(6, 5);
        assertEquals(true, result);
    }
    
    
}
