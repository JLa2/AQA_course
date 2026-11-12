import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testCAddition_1() {
        Calculator a=new Calculator();
        int result=a.add(2, 3);
        assertEquals(5, result);
    }
    @Test
    public void testCAddition_2() {
        Calculator a=new Calculator();
        int result=a.add(3, 0);
        assertEquals(3, result);
    }
    @Test
    public void testCSubtraction_1() {
        Calculator b=new Calculator();
        int result=b.subtract(5, 4);
        assertEquals(1, result);
    }
    @Test
    public void testCSubtraction_2() {
        Calculator b=new Calculator();
        int result=b.subtract(3, 5);
        assertEquals(-2, result);
    }
    @Test
    public void testMultiplication_1() {
        Calculator c=new Calculator();
        int result=c.multiply(5, 5);
        assertEquals(25, result);
    }
    @Test
    public void testMultiplication_2() {
        Calculator c=new Calculator();
        int result=c.multiply(0, 0);
        assertEquals(0, result);
    }
    @Test
    public void testDivision_1() {
        Calculator d=new Calculator();
        int result=d.divide(10, 2);
        assertEquals(5, result);
    }
    @Test
    public void testDivision_2() {
        Calculator d=new Calculator();
        int result=d.divide(6, 3);
        assertEquals(2, result);
    }
}
