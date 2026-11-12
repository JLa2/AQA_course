import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorial_1() {
        Factorial f = new Factorial();
        int result = f.getFactorial(5);
        assertEquals(120, result);
    }
    @Test
    public void testFactorial_2() {
        Factorial f = new Factorial();
        int result = f.getFactorial(1);
        assertEquals(1, result);
    }
    @Test
    public void testFactorial_3() {
        Factorial f = new Factorial();
        int result = f.getFactorial(0);
        assertEquals(1, result);
    }
    @Test
    public void testFactorial_4() {
        Factorial f = new Factorial();
        int result = f.getFactorial(7);
        assertEquals(5040, result);
    }
}
