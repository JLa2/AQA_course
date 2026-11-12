import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @Test
     public void testFactorial() {
        Factorial f = new Factorial();
        int result = f.getFactorial(5);
        assertEquals(120, result);
    }
    
}
