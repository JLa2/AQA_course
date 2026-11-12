import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testCAddition() {
        Calculator a=new Calculator();
        int result=a.add(2, 3);
        assertEquals(5, result);
    }
    @Test
    public void testCSubtraction() {
        Calculator b=new Calculator();
        int result=b.subtract(5, 4);
        assertEquals(1, result);
    }
    @Test
    public void testMultiplication() {
        Calculator c=new Calculator();
        int result=c.multiply(5, 5);
        assertEquals(25, result);
    }
    @Test
    public void testDivision() {
        Calculator d=new Calculator();
        int result=d.divide(10, 2);
        assertEquals(5, result);
    }
}
