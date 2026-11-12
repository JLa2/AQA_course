import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparerTest {
    @Test
    public void testNumber() {
        NumberComparer x=new NumberComparer();
        boolean result=x.compare(6, 5);
        assertEquals(true, result);
    }
    
}
