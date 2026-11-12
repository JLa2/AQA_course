import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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
        int result = f.getFactorial(0);
        assertEquals(1, result);
    }
     @Test
     public void testFactorial_3() {
        Factorial f = new Factorial();
        int result = f.getFactorial(3);
        assertEquals(6, result);
    }
     @Test
     public void testFactorial_4() {
        Factorial f = new Factorial();
        int result = f.getFactorial(1);
        assertEquals(1, result);
    }
}
