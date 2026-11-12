import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorial() {
        Factorial f = new Factorial();
        int result = f.getFactorial(5);
        assertEquals(120, result);
    }
}
